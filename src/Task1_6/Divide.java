package Task1_6;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Divide {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите число p: ");
            int p = sc.nextInt();
            System.out.println("Введите число q: ");
            int q = sc.nextInt();

            if (p % q == 0) {
                System.out.println(p % q == 0);
            } else
                System.out.println(p % q != 0);
        } catch (RuntimeException e) {
            System.out.println("Произошла недопустимая операция!");
        }

        }
    }

