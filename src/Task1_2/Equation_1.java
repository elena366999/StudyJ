package Task1_2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Equation_1 {
      public static void main(String args[]) {
          System.out.println("Решим два уравнения: ");
          double x = checkX();
          double a = checkA();
          double k = checkK();
          double t = 2*(k/a)-(Math.log(2+x)+(Math.pow(x,2)));
          System.out.println("Значение t равно: " + t);
          if (t>=-1){
             double u = (Math.sqrt(t+1))/((Math.pow(t,2))- t + 1);
             System.out.println("Значение u равно: " + u);

          }
          else{
              System.out.println("При данном значении t значение u не является вещественным числом");
          }

   }
    public static double checkX() {
          double x;
        System.out.println("Введите x: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            x = sc.nextDouble();
            if (x > -2)
                break;
            else {
                System.out.println("При данном значении переменной x результат вычисления будет некорректным! Введите другое значение x: ");
            }
        }
        return x;
    }

    public static double checkA() {
        double a;
        System.out.println("Введите a: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            a = sc.nextDouble();
            if (a != 0)
                break;
            else {
                System.out.println("Некорретная операция: деление на ноль! Введите другое число: ");
            }
        }
        return a;
    }

    public static double checkK() {
        double k;
        System.out.println("Введите k: ");
        Scanner sc = new Scanner(System.in);
        k = sc.nextDouble();
        return k;
    }



}
