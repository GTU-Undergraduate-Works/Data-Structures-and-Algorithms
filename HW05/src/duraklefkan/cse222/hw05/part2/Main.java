package duraklefkan.cse222.hw05.part2;

/**
 * Main class to test RecursiveHashingSet class.
 * @author Efkan Durakli
 */
public class    Main {

    public static void main(String[] args) {

        RecursiveHashingSet<Integer> set = new RecursiveHashingSet<>();
        System.out.println("----- RECURSIVE HASH SET TEST 1 -----");
        if (set.isEmpty())
            System.out.println("Set is empty");
        else
            System.out.println("Set is not empty");
        System.out.println("After adding element to set");
        set.add(0);
        set.add(53);
        set.add(126);
        set.add(1);
        set.add(106);
        set.add(212);
        set.add(178);
        set.add(632);
        set.add(108);
        set.add(202);
        set.add(2);
        set.add(55);
        set.add(50);
        set.add(100);
        set.add(150);
        set.add(200);
        set.add(250);
        set.add(300);
        set.add(350);
        set.add(400);
        System.out.println(set);
        System.out.println("Size of set = " + set.size());
        if (set.isEmpty())
            System.out.println("Set is empty");
        else
            System.out.println("Set is not empty");
        System.out.println("After removing element 53 and 100");
        set.remove(53);
        set.remove(100);
        System.out.println(set);
        System.out.println("Size of set = " + set.size());

        if (set.contains(106))
            System.out.println("Set contains element 106");
        else
            System.out.println("Set does not contain element 106");

        if (set.contains(12356))
            System.out.println("Set contains element 12356");
        else
            System.out.println("Set does not contain element 12356");

        RecursiveHashingSet<String> set2 = new RecursiveHashingSet<>(13);
        System.out.println("\n\n----- RECURSIVE HASH SET TEST 2 -----");
        if (set2.isEmpty())
            System.out.println("Set is empty");
        else
            System.out.println("Set is not empty");
        System.out.println("After adding element to set");
        set2.add("Apple");
        set2.add("Apricots");
        set2.add("Cherries");
        set2.add("Grapes");
        set2.add("Kiwifruit");
        set2.add("Lemon");
        set2.add("Mandarin");
        set2.add("Nectarine");
        set2.add("Papaya");
        set2.add("Pear");
        set2.add("Watermelon");
        set2.add("Strawberries");
        set2.add("Orange");
        set2.add("Grapefruit");
        set2.add("Mushrooms");
        set2.add("Banana");
        set2.add("Pomegranate");
        set2.add("Tomato");
        set2.add("Carrots");
        set2.add("Onions");
        System.out.println(set2);
        System.out.println("Size of set = " + set2.size());
        if (set2.isEmpty())
            System.out.println("Set is empty");
        else
            System.out.println("Set is not empty");
        System.out.println("After removing element Apple, Onions, Watermelon");
        set2.remove("Apple");
        set2.remove("Onions");
        set2.remove("Watermelon");
        System.out.println(set2);
        System.out.println("Size of set = " + set2.size());
        if (set2.contains("Orange"))
            System.out.println("Set contains element Orange");
        else
            System.out.println("Set does not contain element Orange");

        if (set2.contains("Salad greens"))
            System.out.println("Set contains element Salad greens");
        else
            System.out.println("Set does not contain element Salad greens");


    }
}
