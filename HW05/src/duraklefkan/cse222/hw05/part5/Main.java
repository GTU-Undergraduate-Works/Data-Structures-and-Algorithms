package duraklefkan.cse222.hw05.part5;

import duraklefkan.cse222.hw05.part3.MergeSortWithDll;
import duraklefkan.cse222.hw05.part4.HeapSort;
import duraklefkan.cse222.hw05.part4.InsertionSort;
import duraklefkan.cse222.hw05.part4.MergeSort;
import duraklefkan.cse222.hw05.part4.QuickSort;

import java.util.LinkedList;

import static duraklefkan.cse222.hw05.part4.Main.*;

public class Main {

    /**
     * Sorts given array reverse order.
     * @param table The array to sort
     */
    private static void reverseSortWithArray(Integer[] table) {
        // A table with one element is sorted already.
        if (table.length > 1) {
            // Split table into halves.
            int halfSize = table.length / 2;
            Integer[] leftTable = new Integer[halfSize];
            Integer[] rightTable =  new Integer[table.length - halfSize];
            System.arraycopy(table, 0, leftTable, 0, halfSize);
            System.arraycopy(table, halfSize, rightTable, 0,
                    table.length - halfSize);
            // Sort the halves.
            reverseSortWithArray(leftTable);
            reverseSortWithArray(rightTable);
            // Merge the halves.
            mergeArrays(table, leftTable, rightTable);
        }
    }
    /**
     * Merges given left and right array to destination array.
     * @param outputSequence The destination array
     * @param leftSequence The left array
     * @param rightSequence The right array
     */
    private static void mergeArrays(Integer[] outputSequence,
                                    Integer[] leftSequence,
                                    Integer[] rightSequence) {

        int i = 0;
        // Index into the left input sequence.
        int j = 0;
        // Index into the right input sequence.
        int k = 0;
        // Index into the output sequence.
        // While there is data in both input sequences
        while (i < leftSequence.length && j < rightSequence.length) {
            // Find the smaller and
            // insert it into the output sequence.
            if (leftSequence[i].compareTo(rightSequence[j]) > 0) {
                outputSequence[k++] = leftSequence[i++];
            } else {
                outputSequence[k++] = rightSequence[j++];
            }
        }
        // assert: one of the sequences has more items to copy.
        // Copy remaining input from left sequence into the output.
        while (i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
        }
        // Copy remaining input from right sequence into output.
        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
        }
    }

    /**
     * Sorts given list reverse order.
     * @param list The list to sort
     */
    private static void reverseSortwithDll(LinkedList<Integer> list) {

        if (list.size() > 1) {
            int leftListSize = list.size()/2;
            int rightListSize = list.size() - leftListSize;
            LinkedList<Integer> leftList = new LinkedList<>();
            LinkedList<Integer> rightList = new LinkedList<>();
            for (int i = 0; i < leftListSize; i++)
                leftList.add(list.get(i));
            for (int i = 0; i < rightListSize; i++)
                rightList.add(list.get(leftListSize+i));
            reverseSortwithDll(leftList);
            reverseSortwithDll(rightList);
            mergeLists(list, leftList, rightList);
        }
    }

    /**
     * Merges given left and right list to destination list
     * @param destinationList The destination list
     * @param leftList The left list
     * @param rightList The right list
     */
    private static void mergeLists(LinkedList<Integer> destinationList,
                                   LinkedList<Integer> leftList,
                                   LinkedList<Integer> rightList) {
        int i = 0, j = 0, k = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) > 0)
                destinationList.set(k++, leftList.get(i++));
            else
                destinationList.set(k++, rightList.get(j++));
        }
        if (i < leftList.size()) {
            while (i < leftList.size())
                destinationList.set(k++, leftList.get(i++));
        } else {
            while (j < rightList.size())
                destinationList.set(k++, rightList.get(j++));
        }
    }

    /**
     * main method to test sorting algorithms.
     * @param args argument list
     */
    public static void main(String[] args) {

        mergeSortTest();
        heapSortTest();
        insertionSortTest();
        quickSortTest();
        mergeSortWithDllTest();

    }

    /**
     * test for merge sort.
     */
    private static void mergeSortTest() {

        System.out.println("-------- MERGE SORT TEST --------");

        Integer[] arr = genrateRandomIntegerArray(100, 1000);
        reverseSortWithArray(arr);
        long time1 = System.nanoTime();
        MergeSort.sort(arr);
        long time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 100 : " + (time2-time1));

        arr = genrateRandomIntegerArray(1000, 10000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        MergeSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 1000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(5000, 50000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        MergeSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 5000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(10000, 100000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        MergeSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 10000 : " + (time2-time1));

    }

    /**
     * test for heap sort.
     */
    private static void heapSortTest() {
        System.out.println("-------- HEAP SORT TEST --------");

        Integer[] arr = genrateRandomIntegerArray(100, 1000);
        reverseSortWithArray(arr);
        long time1 = System.nanoTime();
        HeapSort.sort(arr);
        long time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 100 : " + (time2-time1));

        arr = genrateRandomIntegerArray(1000, 10000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        HeapSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 1000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(5000, 50000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        HeapSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 5000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(10000, 100000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        HeapSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 10000 : " + (time2-time1));
    }

    /**
     * test for insertion sort.
     */
    private static void insertionSortTest() {
        System.out.println("-------- INSERTION SORT TEST --------");

        Integer[] arr = genrateRandomIntegerArray(100, 1000);
        reverseSortWithArray(arr);
        long time1 = System.nanoTime();
        InsertionSort.sort(arr);
        long time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 100 : " + (time2-time1));

        arr = genrateRandomIntegerArray(1000, 10000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        InsertionSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 1000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(5000, 50000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        InsertionSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 5000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(10000, 100000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        InsertionSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 10000 : " + (time2-time1));

    }

    /**
     * test for quick sort.
     */
    private static void quickSortTest() {
        System.out.println("-------- QUICK SORT TEST --------");

        Integer[] arr = genrateRandomIntegerArray(100, 1000);
        reverseSortWithArray(arr);
        long time1 = System.nanoTime();
        QuickSort.sort(arr);
        long time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 100 : " + (time2-time1));

        arr = genrateRandomIntegerArray(1000, 10000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        QuickSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 1000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(5000, 50000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        QuickSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 5000 : " + (time2-time1));

        arr = genrateRandomIntegerArray(10000, 100000);
        reverseSortWithArray(arr);
        time1 = System.nanoTime();
        QuickSort.sort(arr);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 10000 : " + (time2-time1));

    }

    /**
     * test for merge sort with double linked list.
     */
    private static void mergeSortWithDllTest() {
        System.out.println("-------- MERGE SORT WITH DLL TEST --------");

        LinkedList<Integer> list = genrateRandomIntegerList(100, 1000);
        reverseSortwithDll(list);
        long time1 = System.nanoTime();
        MergeSortWithDll.sort(list);
        long time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 100 : " + (time2-time1));

        list = genrateRandomIntegerList(1000, 10000);
        reverseSortwithDll(list);
        time1 = System.nanoTime();
        MergeSortWithDll.sort(list);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 1000 : " + (time2-time1));

        list = genrateRandomIntegerList(5000, 50000);
        reverseSortwithDll(list);
        time1 = System.nanoTime();
        MergeSortWithDll.sort(list);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 5000 : " + (time2-time1));

        list = genrateRandomIntegerList(10000, 100000);
        reverseSortwithDll(list);
        time1 = System.nanoTime();
        MergeSortWithDll.sort(list);
        time2 = System.nanoTime();
        System.out.println("Worst-case Time for Size 10000 : " + (time2-time1));
    }

}
