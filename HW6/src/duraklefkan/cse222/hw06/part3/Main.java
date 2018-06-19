package duraklefkan.cse222.hw06.part3;

import duraklefkan.cse222.hw06.part1.BinarySearchTree;


/**
 * Main class to test AVLTree class
 */
public class Main {

    /**
     * main method
     * @param args argument list
     */
    public static void main(String[] args) {

        System.out.println("AVL TREE TEST");
        AVLTree<Integer> tree = new AVLTree<>();
        System.out.println("After adding element to AVL Tree.");
        tree.add(152);
        tree.add(135);
        tree.add(102);
        tree.add(86);
        tree.add(98);
        tree.add(218);
        tree.add(324);
        tree.add(534);
        tree.add(453);
        tree.add(218);
        tree.add(86);
        tree.add(135);
        tree.add(645);
        tree.add(791);
        tree.add(807);
        tree.add(900);
        tree.add(1041);
        tree.add(951);
        tree.add(873);
        tree.add(614);
        tree.add(502);
        tree.add(347);
        System.out.println(tree);
        System.out.println("After deleting element 453, 502, and 791 from AVL Tree.");
        tree.delete(453);
        tree.delete(502);
        tree.delete(791);
        tree.delete(86);
        tree.delete(1002);
        System.out.println(tree);

        System.out.println("CONSTRUCTOR TEST");

        try {

            BinarySearchTree<Integer> binaryTree = new BinarySearchTree<>();
            binaryTree.add(86);
            binaryTree.add(98);
            binaryTree.add(73);
            binaryTree.add(61);
            binaryTree.add(79);
            binaryTree.add(105);
            binaryTree.add(90);
            AVLTree<Integer> avlTree = new AVLTree<>(binaryTree);
            System.out.println("After creating new AVL tree from binaryTree");
            System.out.println(avlTree);
            binaryTree.add(158);
            binaryTree.add(786);
            binaryTree.add(1000);
            System.out.println("EXCEPTION TEST");
            AVLTree<Integer> avlTree2 = new AVLTree<>(binaryTree);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }






    }
}
