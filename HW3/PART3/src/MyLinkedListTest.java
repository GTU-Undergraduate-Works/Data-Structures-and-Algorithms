import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test MyLinkedList functions
 */
class MyLinkedListTest {

    /**
     * test method to test add method
     */
    @org.junit.jupiter.api.Test
    void add() {

        MyLinkedList list = new MyLinkedList();
        assertTrue(list.add(new Course(8, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3)));
    }

    /**
     * test method to test remove method
     */
    @org.junit.jupiter.api.Test
    void remove() {
        MyLinkedList list = new MyLinkedList();
        Course course = new Course(8, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3);
        list.add(course);
        assertTrue(list.remove());
        assertFalse(list.remove());
    }

    /**
     * test method to test size method
     */
    @org.junit.jupiter.api.Test
    void size() {
        MyLinkedList list = new MyLinkedList();
        assertEquals(0, list.size());
        list.add(new Course(8, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3));
        assertEquals(1, list.size());
    }

    /**
     * test method to test next method
     */
    @org.junit.jupiter.api.Test
    void next() {
        MyLinkedList list = new MyLinkedList();
        Course course1 = new Course(8, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3);
        Course course2 = new Course(7, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3);
        list.add(course1);
        list.add(course2);
        assertEquals(course1, list.next());
        assertEquals(course2, list.next());
    }

    /**
     * test method to test nextInSemester
     */
    @org.junit.jupiter.api.Test
    void nextInSemester() {
        MyLinkedList list = new MyLinkedList();
        Course course1 = new Course(1, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3);
        Course course2 = new Course(2, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3);
        Course course3 = new Course(1, "CSE 4XX", "Bölüm Seçmeli (Temel Alan) Seçmeli II", 6, 3);
        list.add(course1);
        list.add(course2);
        list.add(course3);
        assertEquals(course1, list.nextInSemester());
        assertEquals(course3, list.nextInSemester());
    }
}