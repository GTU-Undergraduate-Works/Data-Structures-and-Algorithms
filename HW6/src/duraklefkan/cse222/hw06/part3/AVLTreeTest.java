package duraklefkan.cse222.hw06.part3;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class to test AVLTree class methods
 */
class AVLTreeTest {

    @org.junit.jupiter.api.Test

    /**
     * method to test delete method of AVLTre class
     */
    void delete() {

        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.add(15);
        avlTree.add(20);
        avlTree.add(25);
        avlTree.add(30);
        avlTree.add(35);
        avlTree.add(40);
        avlTree.add(45);
        avlTree.add(50);
        assertEquals(new Integer(15), avlTree.delete(15));
        assertEquals(new Integer(50), avlTree.delete(50));
        assertEquals(null, avlTree.delete(58));
        assertEquals(null, avlTree.delete(85));

    }
}