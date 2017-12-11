package Task2.TaskUserArray;

import java.util.Scanner;

public class UserArrays4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int array[] = new int[9]; // Создаём массив int размером в size

        System.out.println("Insert array elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();             // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print("Inserted array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();

    int sum = 1;
    int temp = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                temp = temp + 1;
                if (temp>sum)
                sum = temp;
            }else{
                sum = 0;
            }
        }
        System.out.println("Greatest number of consecutive identical elements is" + sum);
    }
}
