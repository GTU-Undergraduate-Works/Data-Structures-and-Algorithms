import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class to test MyLinkedList class methods
 */
public class Main {

    private static final String COURSES_FILE_NAME = "Resources/courses.csv";
    private static MyLinkedList courses;


    public static void main(String[] args) {

        courses = new MyLinkedList();
        System.out.println("Test For MyLinkedList");
        System.out.println("------------------------------");
        System.out.println("Size of list = " + courses.size());
        System.out.println("After adding GTU CSE Couses to list");
        readFromFileToList();
        courses.print();
        System.out.println("Size of list = " + courses.size());
        System.out.println("-----------------------------------------");
        System.out.println("After removing first 4 element of list");
        courses.remove();
        courses.remove();
        courses.remove();
        courses.remove();
        courses.print();
        System.out.println("Size of list = " + courses.size());
        System.out.println("Next 3 Element");
        System.out.println(courses.next());
        System.out.println(courses.next());
        System.out.println(courses.next());
        System.out.println("NexInSemester 3 element");
        System.out.println(courses.nextInSemester());
        System.out.println(courses.nextInSemester());
        System.out.println(courses.nextInSemester());
    }

    /**
     * reads data from csv file to list.
     */
    private static void readFromFileToList() {
        File file = new File(COURSES_FILE_NAME);
        try {
            Scanner input = new Scanner(file);
            String data = input.nextLine();
            while (input.hasNext()) {
                data = input.nextLine();
                String[] values = data.split(";");
                courses.add(new Course(Integer.parseInt(values[0]), values[1], values[2],
                        Integer.parseInt(values[3]), Integer.parseInt(values[4])));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
