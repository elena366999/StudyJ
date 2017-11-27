package Task1_4;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {

        int num = enterNum();
        int res = findRes(num);
        print(res);
    }

    static int enterNum() {
        System.out.print("Введите положительное четырехзначное число: ");
        int num;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            if ((num / 1000) >= 1 && (num / 1000) < 10) {
                break;
            } else {
                System.out.println("Введено некорректное значение!");
            }
        }
            return num;
        }

    private static int findRes(int num) {
        int a1 = num % 10;
        int a2 = num % 100 / 10;
        int a3 = num % 1000 / 100;
        int a4 = num / 1000;
        return a1 * a2 * a3 * a4;
    }

    private static void print(int res) {
        System.out.println("Произведение цифр заданного числа: " + res);
    }

}
