package Task2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class ArrayRand2 {
    public static void main(String[] args) {

        ArrayRand2 array2 = new ArrayRand2();

        int[] array = new int[10];
        Random random2 = new Random();
        System.out.println("Original array is ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random2.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int[] arrayWithRemovedZero = array2.removeZero(array);
        int countEven = array2.countEven(arrayWithRemovedZero);
        int [] newArray = array2.createNewArray(arrayWithRemovedZero, countEven);
        System.out.println(Arrays.toString(array2.add(newArray, countEven)));
    }

    private int[] removeZero(int [] a) {
        int[] newA = a;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                newA = ArrayUtils.remove(a, i);
                break;
            }
        }
        return newA;
    }

    private int countEven(int[] a){
        int count = 0;
        for (int anA : a) {
            if (anA % 2 == 0 && anA != 0) {
                count++;
            }
        }
            return count;
    }

    private  int[] createNewArray(int [] a, int count) {
        int b[] = new int[a.length + count];
        System.arraycopy(a, 0, b, 0, a.length);
       return b;
    }

    private int[] add(int [] a, int count) {
        int l = a.length;
        for (int i = l-1-count; i >= 0; i--) {
            if (a[i] % 2 == 0 && a[i] != 0) {
                for (int j = count; j >= 0; j--) {
                    a[i + count] = a[i - 1] + 2;
                    count--;
                    a[i + count] = a[i];
                    break;
                }
            } else {
                a[i + count] = a[i];
            }
        }
return a;
    }
}

