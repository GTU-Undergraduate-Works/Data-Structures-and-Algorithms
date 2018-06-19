package duraklefkan.cse222hw4.part1;

/**
 * main test class to test GeneralTree class
 */
public class MainTest {

    /**
     * main function
     * @param args main arguments
     */
    public static void main(String[] args) {

        System.out.println("TEST1 - BRITISH ROYAL FAMILY TREE");
        System.out.println("------------------------------------");
        GeneralTree<String> familyTree = new GeneralTree<>();
        familyTree.add("William1", "Robert");
        familyTree.add("William1", "William2");
        familyTree.add("William1", "Adela");
        familyTree.add("William1", "Henry1");
        familyTree.add("Robert", "William");
        familyTree.add("Adela", "Stephen");
        familyTree.add("Henry1", "William");
        familyTree.add("Henry1", "Matilda");
        familyTree.add("Matilda", "Henry2");
        familyTree.add("Henry2", "Henry");
        familyTree.add("Henry2", "Richard1");
        familyTree.add("Henry2", "Geoffrey");
        familyTree.add("Henry2", "John");
        familyTree.add("John", "Henry3");
        familyTree.add("John", "Richard");
        familyTree.add("Henry3", "Edward1");
        familyTree.add("Henry3", "Edmund");
        familyTree.add("Edward1", "Edward2");
        familyTree.add("Edward1", "Thomas");
        familyTree.add("Edward1", "Edmund");
        familyTree.add("Edward2", "Edward3");
        familyTree.add("Geoffrey", "Arthur");
        System.out.println(familyTree);
        System.out.println("POST ORDER TRAVERSAL");
        System.out.println(familyTree.postOrderSearch("efkan", true));
        System.out.println("LEVEL ORDER TRAVERSAL");
        System.out.println(familyTree.levelOrderSearch("efkan", true));
        System.out.println("----------------------------------------------");
        System.out.println("TEST2 - GENERAL TREE THAT STORE INTEGER VALUES");
        System.out.println("----------------------------------------------");
        GeneralTree<Integer> integerTree = new GeneralTree<>();
        integerTree.add(5, 10);
        integerTree.add(5, 15);
        integerTree.add(5, 20);
        integerTree.add(20, 25);
        integerTree.add(20, 30);
        integerTree.add(20, 35);
        integerTree.add(35, 40);
        integerTree.add(35, 45);
        integerTree.add(35, 50);
        integerTree.add(50, 55);
        integerTree.add(50, 50);
        integerTree.add(50, 55);
        System.out.println(integerTree);
        System.out.println("POST ORDER TRAVERSAL");
        System.out.println(integerTree.postOrderSearch(100,true));
        System.out.println("LEVEL ORDER TRAVERSAL");
        System.out.println(integerTree.levelOrderSearch(100, true));
    }
}
