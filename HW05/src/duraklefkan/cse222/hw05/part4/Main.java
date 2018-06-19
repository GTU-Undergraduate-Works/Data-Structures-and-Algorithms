package duraklefkan.cse222.hw05.part4;

import duraklefkan.cse222.hw05.part3.MergeSortWithDll;

import java.util.LinkedList;
import java.util.Random;

import static duraklefkan.cse222.hw05.part3.MergeSortWithDll.sort;

public class Main {

    /**
     * Generates random integer array.
     * @param size size of array
     * @param range range of generated integers
     * @return random generated array
     */
    public static Integer[] genrateRandomIntegerArray(int size, int range) {
        if (size < 0)
            throw new IllegalArgumentException("Size can not be less than zero");
        if (range <= 0)
            throw new IllegalArgumentException("Range must be positive");
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++)
            array[i] = random.nextInt(range);
        return array;
    }



    /**
     * Generates random integer list.
     * @param size size of list
     * @param range range of generated integers
     * @return random generated list
     */
    public static LinkedList<Integer> genrateRandomIntegerList(int size, int range) {

        if (size < 0)
            throw new IllegalArgumentException("Size can not be less than zero");
        if (range <= 0)
            throw new IllegalArgumentException("Range must be positive");
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++)
            list.add(random.nextInt(range));
        return list;
    }

    /**
     * main function to test sort algorithms.
     * @param args argument list
     */
    public static void main(String[] args) {

        heapSortTest();
        insertionSortTest();
        quickSortTest();
        mergeSortTest();
        mergeSortWithDllTest();
    }

    /**
     * test for heap sort
     */
    public static void heapSortTest() {
        System.out.println("---HEAP SORT TEST---");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("For Size " + (i+1)*1000);
            //System.out.println("---------------------------------------------");
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                Integer[] array = genrateRandomIntegerArray((i+1)*1000, (i+1)*100000);
                long time1 = System.nanoTime();
                HeapSort.sort(array);
                long time2 = System.nanoTime();
                System.out.println("Elapsed Time for " + (j+1) + ". test : " + (time2 - time1));
                sum += (time2 - time1);

            }
            System.out.println("Avarage : " + sum/10);
            System.out.println("---------------------------------------------");
        }
    }

    /**
     * test for insertion sort
     */
    public static void insertionSortTest() {
        System.out.println("---INSERTION SORT TEST---");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("For Size " + (i+1)*1000);
            //System.out.println("---------------------------------------------");
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                Integer[] array = genrateRandomIntegerArray((i+1)*1000, (i+1)*100000);
                long time1 = System.nanoTime();
                InsertionSort.sort(array);
                long time2 = System.nanoTime();
                System.out.println("Elapsed Time for " + (j+1) + ". test : " + (time2 - time1));
                sum += (time2 - time1);

            }
            System.out.println("Avarage : " + sum/10);
            System.out.println("---------------------------------------------");
        }
    }

    /**
     * test for quick sort
     */
    public static void quickSortTest() {
        System.out.println("---QUICK SORT TEST---");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("For Size " + (i+1)*1000);
            //System.out.println("---------------------------------------------");
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                Integer[] array = genrateRandomIntegerArray((i+1)*1000, (i+1)*100000);
                long time1 = System.nanoTime();
                QuickSort.sort(array);
                long time2 = System.nanoTime();
                System.out.println("Elapsed Time for " + (j+1) + ". test : " + (time2 - time1));
                sum += (time2 - time1);

            }
            System.out.println("Avarage : " + sum/10);
            System.out.println("---------------------------------------------");
        }
    }

    /**
     * test for mergesort
     */
    public static void mergeSortTest() {
        System.out.println("---MERGE SORT TEST---");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("For Size " + (i+1)*1000);
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                Integer[] array = genrateRandomIntegerArray((i+1)*1000, (i+1)*100000);
                long time1 = System.nanoTime();
                MergeSort.sort(array);
                long time2 = System.nanoTime();
                System.out.println("Elapsed Time for " + (j+1) + ". test : " + (time2 - time1));
                sum += (time2 - time1);

            }
            System.out.println("Avarage : " + sum/10);
            System.out.println("---------------------------------------------");
        }
    }

    /**
     * test for merge sort with double linked list
     */
    public static void mergeSortWithDllTest() {
        System.out.println("---MERGE SORT WITH DOUBLE LINKED LIST TEST---");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println("For Size " + (i+1)*1000);
            //System.out.println("---------------------------------------------");
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                LinkedList<Integer> list = genrateRandomIntegerList((i+1)*1000, (i+1)*100000);
                long time1 = System.nanoTime();
                MergeSortWithDll.sort(list);
                long time2 = System.nanoTime();
                System.out.println("Elapsed Time for " + (j+1) + ". test : " + (time2 - time1));
                sum += (time2 - time1);

            }
            System.out.println("Avarage : " + sum/10);
            System.out.println("---------------------------------------------");
        }
    }
}
