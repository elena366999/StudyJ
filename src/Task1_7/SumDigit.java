package Task1_7;
import java.util.Scanner;
public class SumDigit {
    public static void main(String[] args) {

        int num = enterNum();
        compare(num);
    }

      private static int enterNum() {
            System.out.print("Введите трехзначное число: ");
            int num;
            while (true) {
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            if ((num / 100) >= 1 && (num / 100) < 10)
                break;
            else {
                System.out.println("Введено некорректное значение!");
            }
            }
                return num;
      }

    private static void compare(int num) {
        int num1 = num / 100;
        int num2 = (num %= 100)/10;
        int num3 = (num %= 10);
       if (num1 == (num2 + num3))
            System.out.println("Первая цифра введенного Вами трехзначного числа РАВНА сумме двух его последних цифр");
        else System.out.println("Первая цифра введенного Вами трехзначного числа НЕ РАВНА сумме двух его последних цифр");
            }

}
