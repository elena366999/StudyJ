package Task2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayRand1 {
    public static void main(String[] args) {
        ArrayRand1 AR1 = new ArrayRand1();

        int[] array = new int[10];
        Random random2 = new Random();

        System.out.println("Original array: ");

        for (int i = 0; i < array.length; i++) {
            array[i] = random2.nextInt(10);
            System.out.print(array[i] + " ");
        }

        System.out.println();
        System.out.println(Arrays.toString(AR1.removeKAndAddZeros(array)));

    }

    private int[] removeKAndAddZeros(int[] arrayToProcess) {
        int[] array = Arrays.copyOf(arrayToProcess, arrayToProcess.length);
        int[] removedK = ArrayUtils.remove(array, getKValue());//create a new array
        int countEven = 0;

        for (int aRemovedK : removedK) {
            if (aRemovedK % 2 == 0 && aRemovedK != 0) {
                countEven++;
            }
        }
        System.out.println();

        int b[] = new int[removedK.length + countEven];
        System.arraycopy(removedK, 0, b, 0, removedK.length);

        for (int i = 8; i >= 0; i--) {
            if (b[i] % 2 == 0 && b[i] != 0) {
                int j = countEven;
                while (j >= 0) {
                    b[i + countEven] = 0;
                    countEven--;
                    b[i + countEven] = b[i];
                    break;
                }
            } else {
                b[i + countEven] = b[i];
            }
        }
        return b;
    }

    public Scanner sc = new Scanner(System.in);

    private int getKValue() {
        System.out.println("Enter k value:");
        return sc.nextInt();
    }
}

