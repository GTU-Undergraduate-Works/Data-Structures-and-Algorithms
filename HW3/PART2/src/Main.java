/**
 * Class to test MyLİnkedList class methods
 *
 * @author Efkan Durakli
 */
public class Main {


    public static void main(String[] args) {
        MyLinkedList<String> myList = new MyLinkedList<>();

        myList.add("efkan");
        myList.add("özkan");
        myList.add("ibrahim");
        myList.add("ahmet");
        myList.add("kamil");
        myList.add("enes");
        myList.add("zafer");
        myList.add("selahattin");

        System.out.println("disable(), enable(), showDisabled() methods Test.");
        System.out.println("----------------------------------------------------");
        System.out.println("Size of list before disable operation = " + myList.size());
        myList.disable(1);
        myList.disable(3);
        myList.disable(5);
        myList.disable(7);
        System.out.println("Size of list before disable operation = " + myList.size());
        System.out.println("DISABLED ELEMETS");
        myList.showDisabled();
        if (myList.get(1) == null) {
            System.out.println("You can not call get method disabled elements.Element 1 is disabled.");
        }
        if (myList.set(3, "nar") == null) {
            System.out.println("You can not call set method disabled elements.Element 3 is disabled.");
        }
        if (myList.remove(5) == null) {
            System.out.println("You can not call remove method disabled elements.Element 5 is disabled.");
        }
        if (myList.listIterator(7) == null) {
            System.out.println("You can not call listiterator method disabled elements.Element 7 is disabled.");
        }
        myList.enable(3);
        myList.enable(5);
        System.out.println("----------------------------------------------------");
        System.out.println("After enable ahmet and enes DISABLED ELEMENTS");
        myList.showDisabled();
        System.out.println("----------------------------------------------------");



    }

}
