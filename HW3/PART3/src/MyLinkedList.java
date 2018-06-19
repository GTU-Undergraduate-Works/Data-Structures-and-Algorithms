import java.util.ArrayList;

/**
 * MyLinked List class
 *
 * @author Efkan Durakli
 */
public class MyLinkedList {

    private Node head;
    private ArrayList<Node> heads;
    private ArrayList<Node> tails;
    private ArrayList<Integer> semesters;
    private int size;
    private Node currentNode;
    private int counter;



    /**
     * creates new empty linked list
     */
    public MyLinkedList() {
        head = null;
        tails = new ArrayList<>();
        heads = new ArrayList<>();
        semesters = new ArrayList<>();
        size = 0;
        currentNode = head;
        counter = 0;
    }


    /**
     * static inner class to keep list nodes
     */
    private static class Node {

        private Course course;
        private Node next;
        private Node nextSemester;


        /**
         * creates a new node with a null next and nextSemester field
         * @param course the course
         */
        private Node(Course course) {
            this.course = course;
            next = null;
            nextSemester = null;
        }

        /**
         * creates a new node that references next and nextSemester Node
         * @param course the course
         * @param next the next node referenced by new node
         * @param nexSemester nextSemester node references by new node
         */
        private Node(Course course, Node next, Node nexSemester) {
            this.course = course;
            this.next = next;
            this.nextSemester = nexSemester;
        }
    }

    /**
     * Appends the specified course to the end of this list.
     * @param course course to be appended to this list
     * @return always true
     */
    public boolean add(Course course) {
        Node node = new Node(course);
        if (size == 0) {
            heads.add(null);
            tails.add(null);
            semesters.add(course.getSemester());
            head = node;
            heads.set(0, node);
            tails.set(0,node);
            node.nextSemester = heads.get(0);
        }  else {
            if (!searhSemesters(course.getSemester())) {
                heads.add(null);
                tails.add(null);
                semesters.add(course.getSemester());
                heads.set(heads.size()-1, node);
                tails.set(tails.size()-1, node);
            } else {
                for (int i = 0; i < heads.size(); i++) {
                    if (course.getSemester().equals(semesters.get(i))) {
                        tails.get(i).nextSemester = node;
                        tails.set(i, node);
                        tails.get(i).nextSemester = heads.get(i);
                    }
                }
            }
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = node;
        }
        size++;
        return true;
    }

    /**
     * prints elements of list on screen.
     */
    public void print() {

        Node current = head;
        while (current != null) {

            System.out.println(current.course);
            current = current.next;
        }
    }


    /**
     * Removes first element of this list.
     * @return if list is empty return false, if not return true
     */
    public boolean remove() {
        if (size == 0)
            return false;
        if (size == 1) {
            head = null;
            heads.clear();
            tails.clear();
            semesters.clear();
            size--;
            return true;
        }
        if (size == 2) {
            Node current = head.next;
            if (!current.course.getSemester().equals(head.course.getSemester()))
                semesters.remove(0);
            head = head.next;
            tails.remove(0);
            heads.remove(0);
            heads.set(0, head);
            tails.set(0, head);
            tails.get(0).nextSemester = heads.get(0);
            size--;
            return true;
        }
        Node current = head.next;
        int temp = 0;
        boolean flag = false;
        while (current != null) {
            if (current.course.getSemester().equals(head.course.getSemester())) {
                temp = current.course.getSemester();
                flag = true;
            }
            current = current.next;
        }
        if (!flag) {
            semesters.remove(0);
            heads.remove(0);
            tails.remove(0);
        }
        head = head.next;
        heads.set(0, head);
        tails.get(tails.size()-1).nextSemester = heads.get(0);
        size--;
        return true;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * if is called first, returns course of head node.
     * After first call, return course of current node and
     * move current node on every call
     * @return course of next of cuurentNode
     */
    public Course next() {

        if (size == 0)
            return null;
        if (counter == 0) {
            counter++;
            currentNode = head;
            if (currentNode == null)
                return null;
            return currentNode.course;
        }
        counter++;
        if (currentNode == null)
            return null;
        currentNode = currentNode.next;
        if (currentNode == null)
            return null;
        return currentNode.course;
    }

    /**
     *
     * move course of current node to next Semerter course
     * @return course of next semester of cuurentNode
     */
    public Course nextInSemester() {
        if (size == 0)
            return null;
        if (counter == 0) {
            return next();
        }
        /*if (counter1 >= size)
            return null;*/
        counter++;
        if (currentNode == null)
            return null;
        currentNode = currentNode.nextSemester;
        if (currentNode == null)
            return null;
        return currentNode.course;
    }

    /**
     * gets current Node
     * @return current node
     */
    public Course getCurrentCourse() {
        if (currentNode == null)
            return null;
        return currentNode.course;
    }

    /**
     * reset current node
     */
    public void resetCurrent() {
        counter = 0;
        currentNode = head;
    }

    /**
     * Searches a semester in semesters ArrayList.
     * @param semester semester to search
     * @return if semester is found retur true, if not return false
     */
    private boolean searhSemesters(int semester) {
        for (Integer iter : semesters) {
            if (iter.equals(semester))
                return true;
        }
        return false;
    }

}
