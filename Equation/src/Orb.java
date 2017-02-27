/**
 * Created by Сергей on 24.02.2017.
 */
public class Orb {
    public static void solve() {
        System.out.println("f = x^3 - 30x^2 + 3680 = 0, 0 <= x <= 20, ε = 0.000001");
        System.out.println("f` = 3x^2-60x");
        System.out.println();
        bisect(0,20,0.000001);
        tang(10,0.000001);
        mtang(10, 0.000001);
        sec(0,20,0.000001);
    }

    public static double f(double x) {
        double value = Math.pow(x,3) - 30*Math.pow(x,2) + 3680;
        return value;
    }

    public static double derivf(double x) {
        double deriv = 3*Math.pow(x,2) - 60*x;
        return deriv;
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
        double x = x1 - ((f(x1)*(x1-x0))/(f(x1)-f(x0)));
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
