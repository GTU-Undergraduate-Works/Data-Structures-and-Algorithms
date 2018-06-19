package duraklefkan.cse222hw4.part2;

/**
 * Main test class to test MultiDimensionalTree class.
 */
public class MainTest {

    /**
     * main function
     * @param args main argument lists
     */
    public static void main(String[] args) {
        System.out.println("MULTIDIMENSIONAL TREE TEST");
        System.out.println("----------------------------------------------------------");
        MultiDimensionalTree tree = new MultiDimensionalTree(3);
        tree.add(new Point(36,98,107));
        tree.add(new Point(35,99,106));
        tree.add(new Point(40,90,100));
        tree.add(new Point(35,98,107));
        tree.add(new Point(34,102,106));
        tree.add(new Point(45,58,90));
        tree.add(new Point(42,95,128));
        tree.add(new Point(5,10,106));
        tree.add(new Point(100,105,108));
        tree.add(new Point(110,120,105));
        tree.add(new Point(125,130,107));
        tree.add(new Point(140,145,89));
        tree.add(new Point(135,150,129));
        System.out.println(tree);
        System.out.println("----------------------------------------------------------");
        if (tree.contains(new Point(125,130,107)))
            System.out.println("Tree contains point " + new Point(125,130,107));
        if (!tree.contains(new Point(100,200,300)))
            System.out.println("Tree does not contain point " + new Point(100,200,300));

        if (tree.find(new Point(110,120,105)) != null)
            System.out.println("Point " + new Point(110,120,105) + "is found in tree.");
        if (tree.find(new Point(50,100,150)) == null)
            System.out.println("Point " + new Point(50,100,150) + "is not found in tree.");

        if (tree.remove(new Point(135,150,129)))
            System.out.println("Removing Point " + new Point(135,150,129) + "is successful.");
        System.out.println("After removing Point " + new Point(135,150,129) + "tree.");
        System.out.println(tree);
        System.out.println("----------------------------------------------------------");
        if (tree.delete(new Point(140,145,89)) != null)
            System.out.println("Deleting Point " + new Point(140,145,89) + "is successful.");
        System.out.println("After deleting Point " + new Point(140,145,89) + "tree.");
        System.out.println(tree);
        System.out.println("----------------------------------------------------------");
    }
}
