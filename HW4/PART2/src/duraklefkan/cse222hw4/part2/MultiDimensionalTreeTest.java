package duraklefkan.cse222hw4.part2;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test methods of MultiDimensionalTree class.
 */
class MultiDimensionalTreeTest {

    /**
     * tests add method of MultiDimensionalTree class
     */
    @org.junit.jupiter.api.Test
    void add() {
        MultiDimensionalTree tree = new MultiDimensionalTree(3);
        assertTrue(tree.add(new Point(78,86,95)));
        assertTrue(tree.add(new Point(52,45,97)));
        assertTrue(tree.add(new Point(100,98,96)));
        assertTrue(tree.add(new Point(30,57,28)));
        assertTrue(tree.add(new Point(10,20,15)));
        assertFalse(tree.add(new Point(78,86,95)));
    }

    /**
     * tests contains method of MultiDimensionalTree class
     */
    @org.junit.jupiter.api.Test
    void contains() {
        MultiDimensionalTree tree = new MultiDimensionalTree(3);
        tree.add(new Point(78,86,95));
        tree.add(new Point(52,45,97));
        tree.add(new Point(100,98,96));
        tree.add(new Point(30,57,28));
        tree.add(new Point(10,20,15));
        assertTrue(tree.contains(new Point(10,20,15)));
        assertFalse(tree.contains(new Point(78,96,52)));

    }

    /**
     * tests find method of MultiDimensionalTree class
     */
    @org.junit.jupiter.api.Test
    void find() {
        MultiDimensionalTree tree = new MultiDimensionalTree(3);
        tree.add(new Point(78,86,95));
        tree.add(new Point(52,45,97));
        tree.add(new Point(100,98,96));
        tree.add(new Point(30,57,28));
        tree.add(new Point(10,20,15));
        assertEquals(new Point(10,20,15), tree.find(new Point(10,20,15)));
        assertEquals(null, tree.find(new Point(10,20,30)));
    }

    /**
     * tests delete method of MultiDimensionalTree class
     */
    @org.junit.jupiter.api.Test
    void delete() {
        MultiDimensionalTree tree = new MultiDimensionalTree(3);
        tree.add(new Point(78,86,95));
        tree.add(new Point(52,45,97));
        tree.add(new Point(100,98,96));
        tree.add(new Point(30,57,28));
        tree.add(new Point(10,20,15));
        assertEquals(new Point(10,20,15), tree.delete(new Point(10,20,15)));
        assertEquals(null, tree.delete(new Point(11,20,15)));
    }

    /**
     * tests remove method of MultiDimensionalTree class
     */
    @org.junit.jupiter.api.Test
    void remove() {
        MultiDimensionalTree tree = new MultiDimensionalTree(3);
        tree.add(new Point(78,86,95));
        tree.add(new Point(52,45,97));
        tree.add(new Point(100,98,96));
        tree.add(new Point(30,57,28));
        tree.add(new Point(10,20,15));
        assertTrue(tree.remove(new Point(10,20,15)));
        assertFalse(tree.remove(new Point(11,20,15)));
    }
}