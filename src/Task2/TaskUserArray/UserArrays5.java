package Task2.TaskUserArray;

import java.util.Arrays;
import java.util.Scanner;

public class UserArrays5 {
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
        int[] originalArray;
        originalArray = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(originalArray));

       int [] sortedArray = array;
        Arrays.sort(sortedArray);
        System.out.println(Arrays.toString(sortedArray));

       for (int i=0; i<array.length; i++)
        {
            if (originalArray[i] > sortedArray[2])
            {
                originalArray[i] =sortedArray[2];

            }
        }
            System.out.println("Третье по величине число: " + sortedArray[2]);
            System.out.println("Преобразованный массив: " + Arrays.toString(originalArray));

        }
    }

