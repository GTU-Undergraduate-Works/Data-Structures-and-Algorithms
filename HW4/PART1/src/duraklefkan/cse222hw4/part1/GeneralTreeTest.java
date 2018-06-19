package duraklefkan.cse222hw4.part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class to test methods of GeneralTree class.
 */
class GeneralTreeTest {

    /**
     * tests add method of GeneralTree class
     */
    @Test
    void add() {
        GeneralTree<Integer> tree = new GeneralTree<>();
        assertTrue(tree.add(15,20));
        assertTrue(tree.add(15,25));
        assertTrue(tree.add(20, 30));
        assertTrue(tree.add(25,40));
        assertFalse(tree.add(45, 80));
    }

    /**
     * tests levelOrderSearch method of GeneralTree class
     */
    @Test
    void levelOrderSearch() {
        GeneralTree<String> tree = new GeneralTree<>();
        tree.add("William1", "Robert");
        tree.add("William1", "William2");
        tree.add("William1", "Adela");
        tree.add("William1", "Henry1");
        tree.add("Robert", "William");
        tree.add("Adela", "Stephen");
        tree.add("Henry1", "William");
        tree.add("Henry1", "Matilda");
        tree.add("Matilda", "Henry2");
        tree.add("Henry2", "Henry");
        assertEquals(new BinaryTree.Node<String>("Matilda"), tree.levelOrderSearch("Matilda", false));
        assertEquals(null, tree.levelOrderSearch("efkan", false));
    }

    /**
     * tests postOrderSearch method of GeneralTree class
     */
    @Test
    void postOrderSearch() {
        GeneralTree<String> tree = new GeneralTree<>();
        tree.add("William1", "Robert");
        tree.add("William1", "William2");
        tree.add("William1", "Adela");
        tree.add("William1", "Henry1");
        tree.add("Robert", "William");
        tree.add("Adela", "Stephen");
        tree.add("Henry1", "William");
        tree.add("Henry1", "Matilda");
        tree.add("Matilda", "Henry2");
        tree.add("Henry2", "Henry");
        assertEquals(new BinaryTree.Node<String>("Matilda"), tree.postOrderSearch("Matilda", false));
        assertEquals(null, tree.postOrderSearch("efkan", false));
    }
}