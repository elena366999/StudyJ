package Task2;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {
        int a [] = {1,3,4,6,5,34,3,3,5,8,3,4,6,2,5}; //Массив, который будем сдвигать
        int b [] = {1,3,6,6,5,34,7,3,5,10,3,4,6,2,5};
        b=a;

        System.out.println(b);

        System.out.println(b);
        System.out.print("Массив  до  сдвига: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            b[i+5]=a[i];
            a[i]=b[i];
        }
        System.out.println();
        System.out.print("Массив после сдвига:");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
    /*public static int[] shift(int arr[]) {
        int b[] = new int[arr.length];
        b[0] = arr[arr.length - 1];
        System.arraycopy(arr, 0, b, 1, arr.length - 1);
        return b;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 4, 6, 5, 34, 3, 3, 5, 8, 3, 4, 6, 2, 5};
        int b[] = shift(a);
        System.out.println("Before " + Arrays.toString(a));
        System.out.println("After " + Arrays.toString(b));
    }*/
}
