package Task2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class ArrayRand3 {

    private static ArrayRand3 array3 = new ArrayRand3(8);
    private static int i;

    public static void main(String[] args) {

        int[] array = new int[10];
        Random random2 = new Random();
        System.out.println("Original array is ");
        for (int i = 0; i < array.length; i++) {
            array[i] = random2.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();


        int [] arrayWithRemovedElements = array3.removeElements(array,i);
        int countEven = array3.countEven(arrayWithRemovedElements);
        int [] newArray = array3.createNewArray(arrayWithRemovedElements, countEven);
        System.out.println(Arrays.toString(array3.add(newArray, countEven)));
    }

    private ArrayRand3(int i) {
        ArrayRand3.i = i;
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        ArrayRand3.i = i;
    }

   private int[] removeElements(int[] a, int k) {
       for (int i = 0; i < a.length; i++) {
           if (a[i] == k) {
               a= ArrayUtils.remove(a, i);
           }
       }
       return a;
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
                    a[i + count] = a[i];
                    count--;
                    a[i + count] = 0;
                    break;
                }
            } else {
                a[i + count] = a[i];
            }
        }
        return a;
    }
}