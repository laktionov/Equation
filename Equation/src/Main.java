/**
 * Created by Сергей on 23.02.2017.
 */
import java.util.Scanner;
public class Main {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("ЧИСЛЕННЫЕ МЕТОДЫ РЕШЕНИЯ НЕЛИНЕЙНЫХ АЛГЕБРАИЧЕСКИХ И ТРАНСЦЕНДЕНТНЫХ УРАВНЕНИЙ");
        System.out.println("Введите номер задания");
        int j = in.nextInt();
        if (j == 1) {
            RJ.solve();
        }
        if (j == 2) {
            Orb.solve();
        }
        if (j == 3) {
            Transcendence.solve();
        }
    }
}
