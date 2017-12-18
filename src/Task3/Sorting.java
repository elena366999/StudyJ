package Task3;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] unsortedArray1 = new int[5000];

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
        long start = System.currentTimeMillis();
        int[] arraySortedUsingQuicksort = quickSort(arrayForQuicksort, 0, arrayForQuicksort.length-1);
        long stop = System.currentTimeMillis();
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
        long start = System.currentTimeMillis();
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
        long stop = System.currentTimeMillis();
        System.out.println("\nSorting time:" +(stop-start));
    }

    public static void bubbleSort(int[] arrayToSort){
        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.currentTimeMillis();
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
        long stop = System.currentTimeMillis();
        System.out.println("\nSorting time:" +(stop-start));
    }

    public static void insertSort(int[] arrayToSort) {
        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.currentTimeMillis();
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
        long stop = System.currentTimeMillis();
        System.out.println("Sorting time:" +(stop-start));
    }

    public static void countingSort(int[] arraytoSort){
        int[] array = Arrays.copyOf(arraytoSort, arraytoSort.length);
        long start = System.currentTimeMillis();
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
        long stop = System.currentTimeMillis();
        System.out.println("Sorting time:" +(stop-start));
    }

    public static void cocktailSort(int[] arraytoSort){
        int[] array = Arrays.copyOf(arraytoSort, arraytoSort.length);
        long start = System.currentTimeMillis();
            boolean swapped = true;
            int i = 0;
            int j = array.length - 1;
            while(i < j && swapped){
                swapped = false;
                for(int k = i; k < j; k++){
                    if(array[k] > array[k + 1]){
                        int temp = array[k];
                        array[k] = array[k + 1];
                        array[k + 1] = temp;
                        swapped = true;
                    }
                }
                j--;
                if(swapped){
                    swapped = false;
                    for(int k = j; k > i; k--){
                        if(array[k] < array[k - 1]){
                            int temp = array[k];
                            array[k] = array[k - 1];
                            array[k - 1] = temp;
                            swapped = true;
                        }
                    }
                }
                i++;
            }
        System.out.println("Cocktail sort: ");
        System.out.println(Arrays.toString(array));
        long stop = System.currentTimeMillis();
        System.out.println("Sorting time:" +(stop-start));
    }

    public static void radixSort(int[] arrayToSort) {
        int[] array = Arrays.copyOf(arrayToSort, arrayToSort.length);
        int exp = 1;
        int R = 10;
        long start = System.currentTimeMillis();
        int[] aux = new int[array.length];
        while (array[0] / exp > 0) {
            int[] count = new int[R];
            for (int i = 0; i < array.length; i++) {
                count[(array[i] / exp) % 10]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = array.length - 1; i >= 0; i--) {
                aux[--count[(array[i] / exp) % 10]] = array[i];
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = aux[i];
            }
            exp *= 10;
        }
        System.out.println("Radix sort: ");
        System.out.println(Arrays.toString(array));
        long stop = System.currentTimeMillis();
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







