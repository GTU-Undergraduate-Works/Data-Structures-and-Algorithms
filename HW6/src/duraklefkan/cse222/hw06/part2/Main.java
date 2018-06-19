package duraklefkan.cse222.hw06.part2;

public class Main {

    public static void main(String[] args) {


        System.out.println("BTree TEST");
        System.out.println("TEST 1");
        BTree<Integer> tree = new BTree<>(5);
        System.out.println("After element to BTree");
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(10);
        tree.add(5);
        tree.add(10);
        tree.add(25);
        tree.add(38);
        tree.add(25);
        tree.add(45);
        tree.add(57);
        tree.add(68);
        tree.add(79);
        tree.add(91);
        tree.add(68);
        tree.add(91);
        tree.add(79);
        System.out.println(tree);
        System.out.println("-------------------------------------");
        System.out.println("TEST 2");
        BTree<Integer> tree2 = new BTree<>(7);
        System.out.println("After element to BTree");
        tree2.add(987);
        tree2.add(789);
        tree2.add(843);
        tree2.add(116);
        tree2.add(345);
        tree2.add(999);
        tree2.add(347);
        tree2.add(567);
        tree2.add(210);
        tree2.add(304);
        tree2.add(678);
        tree2.add(916);
        tree2.add(592);
        tree2.add(454);
        tree2.add(41);
        tree2.add(1024);
        tree2.add(1071);
        tree2.add(571);
        tree2.add(632);
        tree2.add(1000);
        System.out.println(tree2);




    }
}
