import java.util.ArrayList;

/**
 * Created by Сергей on 24.02.2017.
 */
public class Transcendence {
    public static void solve() {
        System.out.println("f = 5cosx - lnx -1, 5 <=x <= 20 , ε = 0.000001" );
        System.out.println("f` = -5sinx - 1/x");
        tabulate(5,20,15);
    }

    public static double f(double x) {
        double value = 5*Math.cos(x) - Math.log(x) - 1;
        return value;
    }

    public static double derivf(double x) {
        double deriv = -5*Math.sin(x) - 1/x;
        return deriv;
    }

    public static void tabulate (double A, double B, int N) {
        double h = (B-A)/N;
        double x1 = A;
        double x2 = x1 + h;
        double y1 = f(x1);
        int c = 0;
        ArrayList<Double> d = new ArrayList<Double>();
        while (x2 <= B) {
            double y2 = f(x2);
            if (y1 * y2 <= 0) {
                d.add(x1);
                d.add(x2);
                System.out.print("[" + x1 + "," + x2 + "], ");
                c++;
            }
            x1 = x2;
            x2 = x1 + h;
            y1 = f(x1);
        }
        System.out.println("c=" +c);
        System.out.println();
        for (int j = 0; j < d.size(); j+=2) {
            System.out.println("[" + d.get(j) + "," + d.get(j+1) + "]");
            bisect(d.get(j), d.get(j+1), 0.000001);
            tang((d.get(j) + d.get(j+1)) / 2, 0.000001);
            mtang((d.get(j) + d.get(j+1)) / 2, 0.000001);
            sec(d.get(j), d.get(j+1), 0.000001);
        }
    }

    public static void bisect(double a, double b, double ε) {
        System.out.println("Метод бисекций");
        int M = 0;
        while (Math.abs(b - a) > 2 * ε) {
            double c = (a + b) / 2;
            double y = f(a);
            double z = f(c);
            if (y * z <= 0) {
                b = c;
            } else {
                a = c;
            }
            M++;
        }
        double x = (a + b) / 2;
        double Δ = (b - a) / 2;
        double r = Math.abs(f(x));
        System.out.println("x=" + x);
        System.out.println("Δ=" + Δ);
        System.out.println("r=" + r);
        System.out.println("M=" + M);
        System.out.println();
    }

    public static void tang(double x0, double ε){
        System.out.println("Метод Ньютона");
        int M=0;
        double x = x0;
        while (Math.abs(f(x)) > ε) {
            x = x - f(x)/derivf(x);
            M++;
        }
        double r = Math.abs(f(x));
        System.out.println("x=" +x);
        System.out.println("r=" +r);
        System.out.println("M=" +M);
        System.out.println();
    }

    public static void mtang(double x0, double ε) {
        System.out.println("Модифицированный метод Ньютона");
        int M = 0;
        double x = x0;
        while (Math.abs(f(x)) > ε) {
            x = x - f(x)/derivf(x0);
            M++;
        }
        double r = Math.abs(f(x));
        System.out.println("x=" +x);
        System.out.println("r=" +r);
        System.out.println("M=" +M);
        System.out.println();
    }

    public static void sec(double a, double b, double ε) {
        System.out.println("Метод хорд");
        int M = 0;
        double x0 = a;
        double x1 = b;
        double x = x1 - (f(x1)*(x1-x0))/(f(x1)-f(x0));
        while (Math.abs(f(x)) >= ε) {
            x = x1 - (f(x1)*(x1-x0))/(f(x1)-f(x0));
            double y = f(x0);
            double z = f(x);
            if (y*z<=0) {
                x1 = x;
            }
            else {
                x0 = x;
            }
            M++;
        }
        double r = Math.abs(f(x));
        System.out.println("x=" +x);
        System.out.println("r=" +r);
        System.out.println("M=" +M);
        System.out.println();
    }

}
