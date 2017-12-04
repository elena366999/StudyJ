package Task2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[10];
        Random random2 = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random2.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}