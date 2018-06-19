import java.util.LinkedList;

/**
 * Part1Test class to test GtuCseCourses methods
 *
 * @author Efkan Durakli
 */

public class Part1Test {

    public static void main(String[] args) {
        GtuCseCourses gtuCourses = new GtuCseCourses();
        Course course = new Course();
        System.out.println("getByCode Method Test");
        System.out.println("-------------------------------");
        System.out.println("Parameter : CSE 231");
        try {
            course = gtuCourses.getByCode("CSE 231");
        } catch (NoMatchedCourseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Course Name : " + course.getCourseName());
        System.out.println("Course Code : " + course.getCourseCode());
        System.out.println("Semester : " + course.getSemester());
        System.out.println("Ects Credit : " + course.getEctsCredit());
        System.out.println("Gtu Credit : " + course.getGtuCredit());
        System.out.println("-------------------------------");
        System.out.println("listSemesterCourses Method Test");
        System.out.println("-------------------------------");
        System.out.println("Parameter : 6");
        LinkedList<Course> list = new LinkedList<>();
        try {
            list = gtuCourses.listSemesterCourses(6);
        } catch (NoMatchedCourseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("List of Courses in semester 6");
        for (Course iter : list)
            System.out.println(iter);
        System.out.println("-------------------------------");
        System.out.println("getByRange Method Test");
        System.out.println("-------------------------------");
        System.out.println("Pamaeter start_index : 4");
        System.out.println("Pameter last_index : 10");
        try {
            list = gtuCourses.getByRange(4,10);
        } catch (NoMatchedCourseException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Courses between index 4 and index 10");
        for (Course iter : list)
            System.out.println(iter);
    }
}

