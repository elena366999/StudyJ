package Task3;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] unsortedArray1 = new int[1000];

        Sorting S1 = new Sorting();
        System.out.println("Original unsorted array: ");
        printArray(S1.getArray(unsortedArray1)); // print array;
        System.out.println();
        System.out.println();

        choiceSort(unsortedArray1);
        System.out.println();
        bubbleSort(unsortedArray1);
        System.out.println();
        insertSort(unsortedArray1);
        System.out.println();
        countingSort(unsortedArray1);
        System.out.println();
        cocktailSort(unsortedArray1);
        System.out.println();
        radixSort(unsortedArray1);
        System.out.println();
        int[] arrayForQuicksort = Arrays.copyOf(unsortedArray1, unsortedArray1.length);
        long start = System.nanoTime();
        int[] arraySortedUsingQuicksort = quickSort(arrayForQuicksort, 0, arrayForQuicksort.length-1);
        long stop = System.nanoTime();
        System.out.println("Quick sort: ");
        System.out.println(Arrays.toString(arraySortedUsingQuicksort));
        System.out.println("Sorting time:" +(stop-start));
    }

    private int[] getArray(int[] arrayToGet) {
        for (int i = 0; i < arrayToGet.length; i++) {
            arrayToGet[i] = (int) (Math.random() * 100);
        }
        return arrayToGet;
    }

    public static void printArray(int[] arrayToPrint) {
        int[] array = Arrays.copyOf(arrayToPrint, arrayToPrint.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void choiceSort(int[] arrayToSort){
        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int indexMin;
        for (int index = 0; index < array.length-1; index++) {
            indexMin = index;
            for (int indexToScan = index; indexToScan < array.length; indexToScan++) {
                if(array[indexMin]> array[indexToScan]){
                    indexMin = indexToScan;
                }
            }
            int temp = array[index];
            array[index] = array[indexMin];
            array[indexMin] = temp;
        }
        System.out.println("Choice sort: ");
        printArray(array);
        long stop = System.nanoTime();
        System.out.println("\nSorting time:" +(stop-start));
    }

    public static void bubbleSort(int[] arrayToSort){
        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int changeCounter;
        do {
            changeCounter =0;
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                    changeCounter++;
                }
            }
        } while(changeCounter>0);
        System.out.println("Bubble sort: ");
        printArray(array);
        long stop = System.nanoTime();
        System.out.println("\nSorting time:" +(stop-start));
    }

    public static void insertSort(int[] arrayToSort) {
        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int element;
        int indexToInsert;
        for (int index = 0; index < array.length; index++) {
            element = array[index];
            indexToInsert = index;

            while(indexToInsert>0 && array[indexToInsert-1]>element){
                array[indexToInsert] = array[indexToInsert-1];
                indexToInsert--;
                array[indexToInsert] = element;
            }
        }
        System.out.println("Insert sort: ");
        System.out.println(Arrays.toString(array));
        long stop = System.nanoTime();
        System.out.println("Sorting time:" +(stop-start));
    }

    public static void countingSort(int[] arraytoSort){
        int[] array = Arrays.copyOf(arraytoSort, arraytoSort.length);
        long start = System.nanoTime();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : array){
            if (element < min){
                min = element;
            }
            if (element > max){
                max = element;
            }
        }
        int[] buckets = new int[max - min + 1];
        for (int element : array){
            buckets[element - min]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < buckets.length; i++){
            for (int j = buckets[i]; j > 0; j--){
                array[arrayIndex++] = i + min;
            }
        }
        System.out.println("Counting sort: ");
        System.out.println(Arrays.toString(array));
        long stop = System.nanoTime();
        System.out.println("Sorting time:" +(stop-start));
    }

    public static void cocktailSort(int[] arraytoSort){
        int[] array = Arrays.copyOf(arraytoSort, arraytoSort.length);
        long start = System.nanoTime();
        int left = 1;
        int right = array.length-1;
        do {
            for (int i = right; i >= left; i--) {
                if (array[i - 1] > array[1]) {
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }
            left++;
            for (int i = left; i <=right; i++) {
                if (array[i-1]>array[i]){
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }
            right--;
        }while(left<=right);
        System.out.println("Cocktail sort: ");
        System.out.println(Arrays.toString(array));
        long stop = System.nanoTime();
        System.out.println("Sorting time:" +(stop-start));
    }

    public static void radixSort(int[] arraytoSort) {
        int[] array = Arrays.copyOf(arraytoSort, arraytoSort.length);
        long start = System.nanoTime();
        int cnt[][] = new int[4][];
        int b[];
        int i, j;
        int a_len = array.length;

        if (a_len < 2) {
            return;}

        for (j = 0; j < 4; j++) {
            cnt[j] = new int[257];
            for (i = 0; i < 257; i++) cnt[j][i] = 0;}

        b = new int[a_len];

        for (i = 0; i < a_len; i++) {
            for (j = 0; j < 4; j++) {
                cnt[j][1 + ((array[i] >>> (8 * j)) & 0xff)]++;
            }
        }
        for (j = 0; j < 4; j++) {
          for (i = 1; i < 256; i++) {
              cnt[j][i] += cnt[j][i - 1];
          }
            for (i = 0; i < a_len; i++) {
                b[cnt[j][(array[i] >>> (8 * j)) & 0xff]++] = array[i];
            }
            for (i = 0; i < a_len; i++){
                array[i] = b[i];
            }
        }
        System.out.println("Radix sort: ");
        System.out.println(Arrays.toString(array));
        long stop = System.nanoTime();
        System.out.println("Sorting time:" +(stop-start));
    }

    public static int [] quickSort(int[] arrayToSort, int low, int high) {
        if (low >=high) return arrayToSort;
        int i = low;
        int j = high;
        int pivot = i-(i-j)/2;

        while (i < j){
                while((i<pivot)&& (arrayToSort[i] <= arrayToSort[pivot])) i++;
                while((j>pivot)&& (arrayToSort[j] >= arrayToSort[pivot])) j--;

                if(i<j){
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                    if(i==pivot) pivot = j;
                    else if (j==pivot) pivot = i;
                }
            }

            quickSort(arrayToSort, low, pivot);
            quickSort(arrayToSort, pivot+1, high);

        return arrayToSort;

    }
}







