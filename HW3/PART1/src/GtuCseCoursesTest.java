import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class to test GtuCseCourses class methods.
 */
class GtuCseCoursesTest {

    /**
     * unit test for GtuCseCourses class getByCode method
     */
    @org.junit.jupiter.api.Test
    void getByCode() {

        GtuCseCourses courses = new GtuCseCourses();
        Course course = new Course(5, "CSE 341", "Programming Languages", 6, 3);
        try {

            assertEquals(course, courses.getByCode("CSE 341"));
            assertNotEquals(course, courses.getByCode("TUR 101"));
        } catch (NoMatchedCourseException e) {
            System.out.println(e.getMessage());
        }


    }

    /**
     * unit test for GtuCseCourses class listSemesterCourses method
     */
    @org.junit.jupiter.api.Test
    void listSemesterCourses() {

        GtuCseCourses courses = new GtuCseCourses();
        LinkedList<Course> list = new LinkedList<>();
        list.add(new Course(3, "CSE 241", "Object Oriented Programming", 9, 5));
        list.add(new Course(3, "CSE 211", "Discrete Mathematics", 6, 3));
        list.add(new Course(3, "CSE 231", "Circuits And Electronics", 8, 4));
        list.add(new Course(3, "CSE 233", "Circuits And Electronics Laboratory", 2, 1));
        list.add(new Course(3, "XXX XXX", "Teknik Olmayan Seçmeli (SSB)", 3, 2));
        list.add(new Course(3, "EN 111", "English For Business Life", 2, 2));
        try {
            assertEquals(list, courses.listSemesterCourses(3));
        } catch (NoMatchedCourseException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * unit test for GtuCseCourses class getByRange method
     */
    @org.junit.jupiter.api.Test
    void getByRange() {

        GtuCseCourses courses = new GtuCseCourses();
        LinkedList<Course> list = new LinkedList<>();
        list.add(new Course(3, "CSE 241", "Object Oriented Programming", 9, 5));
        list.add(new Course(3, "CSE 211", "Discrete Mathematics", 6, 3));
        list.add(new Course(3, "CSE 231", "Circuits And Electronics", 8, 4));
        list.add(new Course(3, "CSE 233", "Circuits And Electronics Laboratory", 2, 1));
        list.add(new Course(3, "XXX XXX", "Teknik Olmayan Seçmeli (SSB)", 3, 2));
        list.add(new Course(3, "EN 111", "English For Business Life", 2, 2));
        try {
            assertEquals(list, courses.getByRange(16, 21));
        } catch (NoMatchedCourseException e) {
            System.out.println(e.getMessage());
        }
    }
}