package duraklefkan.cse222.hw06.part1;

public class Main {

    public static void main(String[] args) {



        System.out.println("WORST RED BLACK TREE WITH HEIGT 6");
        System.out.println("-----------------------------------------");
        System.out.println("TEST 1 : ");
        System.out.println("After Adding 14 element to tree in ascending order");
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.add(11);
        redBlackTree.add(27);
        redBlackTree.add(38);
        redBlackTree.add(46);
        redBlackTree.add(52);
        redBlackTree.add(63);
        redBlackTree.add(79);
        redBlackTree.add(83);
        redBlackTree.add(90);
        redBlackTree.add(107);
        redBlackTree.add(119);
        redBlackTree.add(121);
        redBlackTree.add(132);
        redBlackTree.add(143);
        System.out.println(redBlackTree);
        System.out.println("TEST 2 : ");
        System.out.println("After Adding 14 element to tree in descending order");
        RedBlackTree<Integer> redBlackTree2 = new RedBlackTree<>();
        redBlackTree2.add(965);
        redBlackTree2.add(862);
        redBlackTree2.add(718);
        redBlackTree2.add(639);
        redBlackTree2.add(546);
        redBlackTree2.add(427);
        redBlackTree2.add(350);
        redBlackTree2.add(222);
        redBlackTree2.add(198);
        redBlackTree2.add(83);
        redBlackTree2.add(63);
        redBlackTree2.add(52);
        redBlackTree2.add(46);
        redBlackTree2.add(38);
        System.out.println(redBlackTree2);




    }

}
