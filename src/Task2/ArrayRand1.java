package Task2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class ArrayRand1 {
    public static void main(String[] args) {

        int[] array = new int[10];
        Random random2 = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random2.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int[] removedK = ArrayUtils.remove(array, 3);//create a new array
        int countEven = 0;

        for (int i = 0; i < removedK.length; i++) {
            System.out.print(removedK[i] + " ");
            if (removedK[i] % 2 == 0 && removedK[i] != 0) {
                countEven++;
            }
        }
        System.out.println();
        System.out.println(countEven);

        int b[] = new int[removedK.length + countEven];
        System.arraycopy(removedK, 0, b, 0, removedK.length);
        System.out.println(Arrays.toString(b));


        for (int i = 8; i >= 0; i--) {
            if (b[i] % 2 == 0 && b[i]!=0) {
                for (int j = countEven; j >=0; j--) {
                    b[i + countEven] = 0;
                    countEven--;
                    b[i + countEven] = b[i];
                    break;
                }
                } else {
                    b[i + countEven] = b[i];

                }
            }

        System.out.println(Arrays.toString(b));

    }
}

