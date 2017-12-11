package Task2.TaskUserArray;

import java.util.Arrays;
import java.util.Scanner;

public class UserArrays2 {
    public static void main(String[] args) {
        UserArrays2 UA2 = new UserArrays2();

        int array[] = new int[6];
        array = UA2.getUserArray(array);

        System.out.print("Inserted array elements:");
        for (int anArray : array) {
            System.out.print(" " + anArray); // Выводим на экран, полученный массив
        }
        System.out.println();
        System.out.println(UA2.getClosestValueToAverage(array));
        getElementsFoundOnlyTwice(array);

        System.out.println("Greatest number of consecutive identical elements is: " + UA2.getMaxNumberOfSameElementsInSequence(array));


        int third = UA2.getThirdElement(array);
        int [] arrayWithReplacedValues = Arrays.copyOf((UA2.replaceWithThird(array, third)), array.length);
        System.out.println("Преобразованный массив: " + Arrays.toString(arrayWithReplacedValues));


    }

    private int getClosestValueToAverage(int[] arrayToProcess) {
        int[] array = Arrays.copyOf(arrayToProcess, arrayToProcess.length);
        double average = 0;
        for (int anArray : array) {
            average += anArray;
        }
        average = average / array.length;

        double difference;
        int closestValue = 0;

        for (int i = 0; i < array.length - 1; i++) {
            difference = Math.abs(average - array[i]);
            closestValue = array[i];
            if (difference > Math.abs(average - array[i + 1])) {
                closestValue = array[i + 1];
            }
        }
        return closestValue;
    }

    public static void getElementsFoundOnlyTwice(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int nCount = 1;
            for (int k = i + 1; k < array.length && array[i] > Integer.MIN_VALUE; k++)
                if (array[i] == array[k]) {
                    array[k] = Integer.MIN_VALUE;
                    nCount++;
                }

            if (nCount == 2) {
                System.out.println(array[i] + " is found in the array only twice");
            }
        }
    }

    private int getMaxNumberOfSameElementsInSequence(int[] array) {
        int sum = 1;
        int temp = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                temp = temp + 1;
                if (temp > sum)
                    sum = temp;
            } else {
                sum = 0;
            }
        }
        return sum;
    }

    private int getThirdElement(int[] arrayToProcess) {
        int[] array = Arrays.copyOf(arrayToProcess, arrayToProcess.length);
        Arrays.sort(array);
        return array[2];
    }

    private int[] replaceWithThird(int[] arrayToProcess, int y){
         int[] array = Arrays.copyOf(arrayToProcess, arrayToProcess.length);
         for (int i = 0; i < array.length; i++) {
             if (array[i] > y) {
                 array[i] = array[2];
             }
         }
         return array;
     }

    public Scanner sc = new Scanner(System.in);

    private int [] getUserArray(int[] array) {
        System.out.println("Insert array elements:");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
        return array;
    }
}
