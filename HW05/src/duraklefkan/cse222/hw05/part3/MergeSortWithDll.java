package duraklefkan.cse222.hw05.part3;

import java.util.LinkedList;
import java.util.Random;

/**
 * Merge Sort Algorithm with Java Doble Lnked List
 * @author Efkan Durakli
 */
public class MergeSortWithDll {

    /**
     * Sorts given list acsending order.
     * @param list linked list to sort
     * @param <E> type parameter
     */
    public static <E extends Comparable<E>> void sort(LinkedList<E> list) {

        if (list.size() > 1) {
            int leftListSize = list.size()/2;
            int rightListSize = list.size() - leftListSize;
            LinkedList<E> leftList = new LinkedList<>();
            LinkedList<E> rightList = new LinkedList<>();
            for (int i = 0; i < leftListSize; i++)
                leftList.add(list.get(i));
            for (int i = 0; i < rightListSize; i++)
                rightList.add(list.get(leftListSize+i));
            sort(leftList);
            sort(rightList);
            merge(list, leftList, rightList);
        }
    }

    /**
     * Merge leftList and rightList to destinationList.
     * @param destinationList The destination list
     * @param leftList The left list
     * @param rightList The right list
     * @param <E> type parameter
     */
    private static <E extends Comparable<E>> void merge(LinkedList<E> destinationList,
                                                        LinkedList<E> leftList,
                                                        LinkedList<E> rightList) {
        int i = 0, j = 0, k = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) < 0)
                destinationList.set(k++, leftList.get(i++));
            else
                destinationList.set(k++, rightList.get(j++));
        }
        if (i >= leftList.size()) {
            while (j < rightList.size())
                destinationList.set(k++, rightList.get(j++));
        }
        else {
            while (i < leftList.size())
                destinationList.set(k++, leftList.get(i++));
        }
    }

    /**
     * Generates random integer list.
     * @param size size of liste
     * @param range range of generated integers
     * @return random generated list
     */
    public static LinkedList<Integer> genrateRandomIntegerList(int size, int range) {

        if (range <= 0)
            throw new IllegalArgumentException("Range must be positive");
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++)
            list.add(random.nextInt(range));
        return list;
    }

    /**
     * Main class to test merge sort.
     * @param args argument list
     */
    public static void main(String[] args) {

        LinkedList<Integer> list = genrateRandomIntegerList(50,1000);
        System.out.println("Random Generated List");
        System.out.println(list);
        sort(list);
        System.out.println("Sorted List");
        System.out.println(list);
    }
}


