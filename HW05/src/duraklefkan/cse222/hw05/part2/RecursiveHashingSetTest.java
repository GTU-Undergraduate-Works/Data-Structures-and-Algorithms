package duraklefkan.cse222.hw05.part2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test RecursiveHashingSet methods
 * @author Efkan Durakli
 */
class RecursiveHashingSetTest {

    /**
     * test method to test size method of RecursiveHashingSet class
     */
    @Test
    void size() {
        RecursiveHashingSet<Integer> set = new RecursiveHashingSet<>();
        assertEquals(0,set.size());
        set.add(0);
        set.add(53);
        set.add(1);
        set.add(54);
        set.add(48);
        assertEquals(5,set.size());
        set.add(54);
        set.add(48);
        set.add(2);
        set.add(55);
        set.add(49);
        assertEquals(8,set.size());
    }

    /**
     * test method to test isEmpty method of RecursiveHashingSet class
     */
    @Test
    void isEmpty() {
        RecursiveHashingSet<Integer> set = new RecursiveHashingSet<>();
        assertTrue(set.isEmpty());
        set.add(0);
        set.add(53);
        set.add(1);
        set.add(54);
        set.add(48);
        assertFalse(set.isEmpty());
    }

    /**
     * test method to test contains method of RecursiveHashingSet class
     */
    @Test
    void contains() {
        RecursiveHashingSet<Integer> set = new RecursiveHashingSet<>();
        set.add(0);
        set.add(53);
        set.add(1);
        set.add(54);
        set.add(48);
        set.add(2);
        set.add(55);
        set.add(49);
        assertTrue(set.contains(0));
        assertTrue(set.contains(53));
        assertTrue(set.contains(1));
        assertTrue(set.contains(54));
        assertTrue(set.contains(48));
        assertTrue(set.contains(2));
        assertTrue(set.contains(55));
        assertTrue(set.contains(49));
        assertFalse(set.contains(12));
        assertFalse(set.contains(24));
        assertFalse(set.contains(47));
        assertFalse(set.contains(789));
    }

    /**
     * test method to test add method of RecursiveHashingSet class
     */
    @Test
    void add() {
        RecursiveHashingSet<Integer> set = new RecursiveHashingSet<>();
        assertTrue(set.add(0));
        assertTrue(set.add(53));
        assertTrue(set.add(1));
        assertTrue(set.add(54));
        assertTrue(set.add(48));
        assertTrue(set.add(2));
        assertTrue(set.add(55));
        assertTrue(set.add(49));
        assertFalse(set.add(0));
        assertFalse(set.add(53));
        assertFalse(set.add(1));
        assertFalse(set.add(54));
        assertFalse(set.add(48));
        assertFalse(set.add(2));
        assertFalse(set.add(55));
        assertFalse(set.add(49));
    }

    /**
     * test method to test remove method of RecursiveHashingSet class
     */
    @Test
    void remove() {
        RecursiveHashingSet<Integer> set = new RecursiveHashingSet<>();
        set.add(0);
        set.add(53);
        set.add(1);
        set.add(54);
        set.add(48);
        set.add(2);
        set.add(55);
        set.add(49);
        assertTrue(set.remove(0));
        assertTrue(set.remove(53));
        assertTrue(set.remove(1));
        assertTrue(set.remove(54));
        assertTrue(set.remove(48));
        assertTrue(set.remove(2));
        assertTrue(set.remove(55));
        assertTrue(set.remove(49));
        set.add(0);
        set.add(53);
        set.add(1);
        set.add(54);
        set.add(48);
        set.add(2);
        set.add(55);
        set.add(49);
        assertFalse(set.remove(233));
        assertFalse(set.remove(423));
        assertFalse(set.remove(852));
        assertFalse(set.remove(1456));
        assertFalse(set.remove(1453));
        assertFalse(set.remove(1923));
        assertFalse(set.remove(1041));
        assertFalse(set.remove(7532));
    }
}