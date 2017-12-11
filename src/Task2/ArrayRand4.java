package Task2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Random;

public class ArrayRand4 {

    public static void main(String[] args) {

        ArrayRand4 AR4 = new ArrayRand4();

        int[] array = new int[10];
        Random random2 = new Random();

        System.out.println("Original array is ");

        for (int i = 0; i < array.length; i++) {
            array[i] = random2.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int[] arrayWithReplacedValues = AR4.getArrayWithReplacedValues(array);
        System.out.println("Array with replaced first and max values is ");
        for (int anArray : arrayWithReplacedValues) {
            System.out.print(anArray + " ");
        }
        System.out.println();

        System.out.println("Array where values more than 8 are removed is ");
        for (int anArray : AR4.removeElementsExceedingEight(arrayWithReplacedValues)) {
            System.out.print(anArray + " ");
        }
    }

        private int[] getArrayWithReplacedValues(int [] array){
            int min = array[1];
            for (int i = 1; i < array.length; i++) {
                if (min > array[i]) {
                    min = array[i];
                }
            }

            int temp = array[0];
            array[0] = min;

            for (int y = 1; y < array.length; y++) {
                if (array[y] == min) {
                    array[y] = temp;
                }
            }

            return array;
        }

        private int[] removeElementsExceedingEight(int[]array) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 8) {
                    array = ArrayUtils.remove(array, i);

                }

            }
            return array;
        }

    }





