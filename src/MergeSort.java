import java.util.Random;

public class MergeSort {

    // Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array1 = new int[10];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = rand.nextInt(101); // Random numbers between 0 and 100
        }
        int[] array2 = array1.clone();

        System.out.println("Unsorted array:");
        printArray(array1);
        System.out.println();

        long startTime = System.nanoTime();
        mergeSort(array1, 0, array1.length - 1);
        long endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime;

        startTime = System.nanoTime();
        bubbleSort(array2);
        endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;

        System.out.println("Merge Sort Time: " + mergeSortTime + " ns");
        System.out.println("Sorted array using Merge Sort:");
        printArray(array1);
        System.out.println();

        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ns");
        System.out.println("Sorted array using Bubble Sort:");
        printArray(array2);
        System.out.println();
    }
}