import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test MyLinkedList class methods.
 */
class MyLinkedListTest {

    /**
     * unit test for MyLinkedList class disable method
     */
    @org.junit.jupiter.api.Test
    void disable() {

        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("elma");
        list.add("armut");
        list.add("kiraz");
        list.add("kivi");
        list.add("muz");
        assertTrue(list.disable(2));
        assertEquals(null, list.get(2));
        assertEquals(null, list.remove(2));
        assertEquals(null, list.set(2, "ayva"));
        assertEquals(4, list.size());
        assertEquals(null, list.listIterator(2));
        assertFalse(list.disable(2));

    }

    /**
     * unit test for MyLinkedList class enable method
     */
    @org.junit.jupiter.api.Test
    void enable() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("elma");
        list.add("armut");
        list.add("kiraz");
        list.add("kivi");
        list.add("muz");
        assertFalse(list.enable(1));
        list.disable(4);
        assertTrue(list.enable(4));
    }

}