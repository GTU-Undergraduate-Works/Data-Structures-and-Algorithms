package duraklefkan.cse222.hw05.part1;

import java.util.*;

/**
 * HashMap using open adressing hash table.
 * Collisions are resolved by double hashing.
 * @author Efkan Durakli
 * @param <K> the type of keys maintained by this map
 * @param <V>  the type of mapped values
 */
public class DoubleHashingMap<K,V> implements Map<K,V> {



    private MyEntry<K,V>[] table;
    private static final int START_CAPACITY = 11;
    private int PRIME = 7;
    private double LOAD_THRESHOLD = 0.75;
    private final MyEntry<K,V> DELETED = new MyEntry<>(null,null);
    private int numKeys;
    private int numDeletes;

    /**
     * Inner class for map entries.
     * @param <K> type parameter of keys
     * @param <V> type parameter of values
     */
    private static class MyEntry<K,V> implements Entry<K,V> {

        private final K key;
        private V value;

        /**
         * Creates new key-value pair.
         * @param key The key
         * @param value The value
         */
        private MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** {@inheritDoc}
         */
        @Override
        public K getKey() {
            return key;
        }

        /** {@inheritDoc}
         */
        @Override
        public V getValue() {
            return value;
        }

        /** {@inheritDoc}
         */
        @Override
        public V setValue(V v) {
            V oldValue = value;
            value = v;
            return oldValue;
        }
    }

    /**
     * Creates empty hash map.
     */
    public DoubleHashingMap() {
        numKeys = 0;
        numDeletes = 0;
        table = new MyEntry[START_CAPACITY];
    }

    /**
     * Creates empty map with given capacity.
     * @param capacity The capacity
     */
    public DoubleHashingMap(int capacity) {

        if (capacity <= 2)
            throw new IllegalArgumentException("Capacity must be greater than 2!");
        numKeys = 0;
        numDeletes = 0;
        table = new MyEntry[capacity];
        for (int i = table.length-1; i > 1; i++) {
            if (isPrime(i)) {
                PRIME = i;
                break;
            }
        }
    }

    /** {@inheritDoc}
     */
    @Override
    public int size() {
        return numKeys;
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return (numKeys == 0);
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean containsKey(Object o) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != DELETED && table[i].getKey().equals(o))
                return true;
        }
        return false;
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean containsValue(Object o) {

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != DELETED && table[i].getValue().equals(o))
                return true;
        }
        return false;
    }

    /** {@inheritDoc}
     */
    @Override
    public V get(Object o) {
        int index = find(o);
        if (table[index] != null)
            return table[index].getValue();
        return null;
    }

    /** {@inheritDoc}
     */
    @Override
    public V put(K k, V v) {

        int index = find(k);
        if (table[index] == null) {
            table[index] = new MyEntry<>(k,v);
            numKeys++;
            double loadFactor = (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
            return null;
        }
        V oldValue = table[index].getValue();
        table[index].setValue(v);
        return oldValue;
    }

    /** {@inheritDoc}
     */
    @Override
    public V remove(Object o) {

        int index = find(o);
        if (table[index] == null)
            return null;
        V value = table[index].getValue();
        table[index] = DELETED;
        numDeletes++;
        numKeys--;
        return value;
    }

    /** {@inheritDoc}
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("putAll method is not supported for this map.");
    }

    /** {@inheritDoc}
     */
    @Override
    public void clear() {
        table = new MyEntry[START_CAPACITY];
        PRIME = 7;
        numKeys = 0;
        numDeletes = 0;
    }

    /** {@inheritDoc}
     */
    @Override
    public Set<K> keySet() {
        HashSet<K> keys = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != DELETED)
                keys.add(table[i].getKey());
        }
        return keys;
    }

    /** {@inheritDoc}
     */
    @Override
    public Collection<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != DELETED)
                values.add(table[i].getValue());
        }
        return values;
    }

    /** {@inheritDoc}
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K,V>> entries = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != DELETED)
                entries.add(table[i]);
        }
        return entries;
    }

    /**
     * Finds either the target key or the first empty slot in the
     * search chain using double hashing.
     * @param key The key of the target object
     * @return The position of the target or the first empty slot if
     *          the taget is not in the table.
     */
    private int find(Object key) {

        int index = hashCode1(key);
        while (index < 0)
            index += table.length;
        int i = 1;
        while ((table[index] != null)
                && (!key.equals(table[index].getKey()))) {
            index = (hashCode1(key) + i*hashCode2(key)) % table.length;
            while (index < 0)
                index += table.length;
            i++;
        }
        return index;
    }

    /**
     * Returns first hash code for given key.
     * @param key The key
     * @return first hash code for given key.
     */
    private int hashCode1(Object key) {
        return key.hashCode() % table.length;
    }


    /**
     * Returns second hash code for given key.
     * @param key The key
     * @return second hash code for given key.
     */
    private int hashCode2(Object key) {
        return PRIME - (key.hashCode() % PRIME);
    }

    private void rehash() {
        Entry<K,V>[] oldTable = table;
        table = new MyEntry[2*oldTable.length + 1];
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null) &&oldTable[i] != DELETED)
                put(oldTable[i].getKey(), oldTable[i].getValue());
        }
        for (int i = table.length-1; i > 1; i++) {
            if (isPrime(i)) {
                PRIME = i;
                break;
            }
        }
    }

    /**
     * Returns string representation of this object.
     * @return a string representation of object
     */
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i] != DELETED)  {
                String str = table[i].getKey() + "=" + table[i].getValue() + ", ";
                stringBuilder.append(str);
            }
        }
        int spaceIndex = stringBuilder.lastIndexOf(" ");
        int commaIndex = stringBuilder.lastIndexOf(",");
        if (spaceIndex != -1)
            stringBuilder.deleteCharAt(spaceIndex);
        if (commaIndex != -1)
            stringBuilder.deleteCharAt(commaIndex);
        stringBuilder.append("}");
        return stringBuilder.toString();
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
}
