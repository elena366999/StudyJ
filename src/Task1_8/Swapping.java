package Task1_8;
import java.util.Scanner;

public class Swapping {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        try {
            System.out.println("Введите число x: ");
            double x = sc1.nextDouble();
            System.out.println("Введите число y: ");
            double y = sc2.nextDouble();
            System.out.println("Введите число z: ");
            double z = sc3.nextDouble();
            double min = Math.min(x, Math.min(y, z));
            double max = Math.max(x, Math.max(y, z));
            double mid = Math.min(max, Math.min(x, Math.max(y, z)));
            x=max;
            y=mid;
            z=min;

            System.out.println("Теперь x = " + x + ", " + "y = " + y + " и z = " + z);

        } catch (RuntimeException e) {
            System.out.println("Недопустимая операция!");
        }



   }

    }



