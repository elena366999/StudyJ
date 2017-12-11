package Task2.TaskUserArray;

import java.util.Scanner;

public class UserArray3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int array[] = new int[6]; // Создаём массив int размером в size

        System.out.println("Insert array elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();             // Заполняем массив элементами, введёнными с клавиатуры
        }
        System.out.print("Inserted array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();

        for (int i = 0; i < array.length; i++)
        {
            int nCount = 1;
            for (int k = i + 1; k < array.length && array[i] > Integer.MIN_VALUE; k++)
                if (array[i] == array[k])
                { array[k] = Integer.MIN_VALUE; nCount++; }

            if (nCount == 2){
                System.out.println(array[i] + " is found in the array only twice");}
        }

        }
}
