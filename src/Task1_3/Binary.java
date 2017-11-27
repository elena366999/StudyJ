package Task1_3;

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите число a: ");
            int a = sc.nextInt();
            System.out.println("Введите число b: ");
            int b = sc.nextInt();

            if ((a>=32) && (b>=4)) {
            String abin = Integer.toBinaryString(a);
            String bbin = Integer.toBinaryString(b);

            String extractedNumbersFromA = abin.substring(1, 6);

            StringBuffer abin2 = new StringBuffer(abin);
            abin2.delete(1, 6);
            String abin3 = abin2.toString();
            //System.out.println("5 символов из числа а: " + extractedNumbersFromA); (5 битов, извлеченных из числа ф)
            System.out.println("Число a после извлечения битов: " + abin2);
            //вставляем символы в строку b;

            StringBuffer bbin2 = new StringBuffer(bbin);
            bbin2.insert(2, extractedNumbersFromA);
            String bbin3 = bbin2.toString();
            System.out.println("Число b после вставки битов: " + bbin2);

            System.out.println("Число а  после извлечения битов в десятичном виде: " + Integer.parseInt(abin3, 2));
            System.out.println("Число b после вставки битов в десятичном виде: " + Integer.parseInt(bbin3, 2));
            System.out.println("Первончальное число а в двоичном виде: " + abin);
            System.out.println("Первончальное число b в двоичном виде: " + bbin);
            } else {
            System.out.println("Введите другие числа!");
            }

        } catch (RuntimeException e) {
            System.out.println("Недопустимая операция!");
            }


        }
    }