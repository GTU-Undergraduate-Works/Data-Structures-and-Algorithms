package duraklefkan.cse222.hw05.part2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * RecursiveHashSet class.
 * @param <E> type parameter
 * @author Efkan Durakli
 */
public class RecursiveHashingSet<E> implements Set<E> {

    private MyEntry<E>[] table;
    private static final int START_CAPACITY = 53;
    private int nextTableLength = 47;
    private int size;
    //private final E DELETED = null;

    /**
     * Entry class for HashSet.
     * @param <E> type parameter
     */
    private static class MyEntry<E> {

        private E element;
        private MyEntry<E>[] nextTable;
        private int numElements;


        /**
         * Creates MyEntry object.
         */
        private MyEntry() {
            element = null;
            nextTable = null;
        }

        /**
         * This is getter which gets elememt
         * @return The element
         */
        private E getElement() {
            return element;
        }

        /**
         * This is the setter which sets the element of this object.
         * @param element The element to set.
         */
        private void setElement(E element) {
            this.element = element;
        }
    }

    /**
     * Creates empty RecursiveHashingSet object.
     */
    public RecursiveHashingSet() {

        table = new MyEntry[START_CAPACITY];
        for (int i = 0; i < START_CAPACITY; i++)
            table[i] = new MyEntry<>();
        size = 0;
    }

    /**
     * Creates empty set with given capacity.
     * @param capacity The capacity
     */
    public RecursiveHashingSet(int capacity) {
        table = new MyEntry[capacity];
        for (int i = 0; i < capacity; i++)
            table[i] = new MyEntry<>();
        size = 0;
    }

    /** {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        int index = o.hashCode() % table.length;
        while (index < 0)
            index += table.length;
        MyEntry<E> current = table[index];
        while (current != null) {
            if (current.getElement() != null && current.getElement().equals(o))
                return true;
            if (current.nextTable != null) {
                index = o.hashCode() % current.nextTable.length;
                while (index < 0)
                    index += current.nextTable.length;
                current = current.nextTable[index];
            }
            else break;
        }
        return false;
    }

    /** {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Iterator method is not supported for this map.");
    }

    /** {@inheritDoc}
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("toArray method is not supported for this map.");
    }

    /** {@inheritDoc}
     */
    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("toArray method is not supported for this map.");
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        return add(table, e);
    }

    /**
     * Adds elemet to set.
     * @param table hash table of RecursiveHashSet
     * @param e The element to add
     * @return if element is exist in set, return false, if not return true
     */
    private boolean add(MyEntry<E>[] table, E e) {

        int index = e.hashCode() % table.length;
        while (index < 0)
            index += table.length;
        if (table[index].getElement() == null ) {
            table[index].setElement(e);
            size++;
            table[index].numElements++;
            return true;
        }
        if (table[index].getElement().equals(e))
            return false;
        else  {
            for (int i = table.length-1; i >= 2; i--) {
                if (isPrime(i)) {
                    nextTableLength = i;
                    break;
                }
            }
            if (table[index].nextTable == null) {
                table[index].nextTable = new MyEntry[nextTableLength];
                for (int i = 0; i < nextTableLength; i++)
                    table[index].nextTable[i] = new MyEntry<>();
            }
            return add(table[index].nextTable, e);
        }
    }



    /** {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {

        int index = o.hashCode() % table.length;
        while (index < 0)
            index += table.length;
        MyEntry<E> current = table[index];
        while (current != null) {
            if (current.getElement() != null && current.getElement().equals(o)) {
                current.setElement(null);
                size--;
                current.numElements++;
                if (current.numElements == 0)
                    current = null;
                return true;
            }
            if (current.nextTable != null) {
                index = o.hashCode() % current.nextTable.length;
                while (index < 0)
                    index += current.nextTable.length;
                current = current.nextTable[index];
            }
            else break;
        }
        return false;
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException("containsAll method is not supported for this map.");
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("addAll method is not supported for this map.");
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("retainAll method is not supported for this map.");
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("removeAll method is not supported for this map.");
    }

    /** {@inheritDoc}
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("clear method is not supported for this map.");
    }

    /**
     * Checks given number is prime or not.
     * @param number The number to check primity
     * @return true if number is prime, if not return false
     */
    private boolean isPrime(int number) {
        for (int i = 2; i < number; i++)
            if (number % i == 0)
                return false;
        return true;
    }

    /**
     * Returns string representation of this object.
     * @return a string representation of object
     */
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        traverseSet(table, stringBuilder);
        stringBuilder.append("]");
        int spaceIndex = stringBuilder.lastIndexOf(" ");
        int commaIndex = stringBuilder.lastIndexOf(",");
        if (spaceIndex != -1)
            stringBuilder.deleteCharAt(spaceIndex);
        if (commaIndex != -1)
            stringBuilder.deleteCharAt(commaIndex);
        return  stringBuilder.toString();
    }

    /**
     * Traverse set and appends elements to string builder.
     * @param table The hash table of this set
     * @param sb The string bıilder to append elements
     */
    private void traverseSet(MyEntry<E>[] table, StringBuilder sb) {

        for (int i = 0; i < table.length; i++) {
            if (/*table[i].getElement() != DELETED && */table[i].getElement() != null)
                sb.append(table[i].getElement() + ", ");
            if (table[i].nextTable != null)
                traverseSet(table[i].nextTable, sb);
        }
    }
}
