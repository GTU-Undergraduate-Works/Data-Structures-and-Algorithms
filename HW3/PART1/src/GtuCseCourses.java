import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Class to keep GTU Computer Engineering Courses structure
 */
public class GtuCseCourses {

    private static final String COURSES_FILE_NAME = "Resources/courses.csv";
    private LinkedList<Course> courses;

    /**
     * creates GtuCseCouses object
     */
    public GtuCseCourses() {
        courses = new LinkedList<>();
        readFromFileToList();
    }

    /**
     * read course information to list from csv file
     */
    private void readFromFileToList() {

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

    /**
     * gets Course with given code
     * @param code code of course
     * @return if there is a course in the given code, return that course
     * @throws NoMatchedCourseException if there is no course in the given code, throw this Exception
     */
    public Course getByCode(String code) throws NoMatchedCourseException {

        ListIterator<Course> iter = courses.listIterator();
        while (iter.hasNext()) {
            if (iter.next().getCourseCode().equals(code)) {
                iter.previous();
                return iter.next();
            }
        }
        throw new NoMatchedCourseException("Course with " + code + "is not found.");
    }

    /**
     * lists course in given semester
     * @param semester semester of course
     * @return list of given semester, if there is any course in given semester
     * @throws NoMatchedCourseException if there is no course in given semester, throw this exception
     */
    public LinkedList<Course> listSemesterCourses(int semester) throws NoMatchedCourseException {

        LinkedList<Course> tempList = new LinkedList<>();
        ListIterator<Course> iter = courses.listIterator();
        boolean flag = false;
        while (iter.hasNext()) {
            if (iter.next().getSemester().equals(semester)) {
                iter.previous();
                tempList.add(iter.next());
                flag = true;
            }
            else
                iter.next();
        }
        if (flag)
            return tempList;
        throw new NoMatchedCourseException("Course is not found in semester " + semester);
    }

    /**
     * list all course in given range
     * @param start_index start index of range
     * @param last_index last index of range
     * @return if there is any course in given range, return list of course in given range
     * @throws NoMatchedCourseException if there is no course in given course, throw this exception
     */
    public LinkedList<Course> getByRange(int start_index, int last_index) throws NoMatchedCourseException{

        if (start_index < 0)
            throw new NoMatchedCourseException("start_index can not less than zero.");
        if (last_index >= courses.size())
            throw new NoMatchedCourseException("last_index must be less than size of course list.");

        if (start_index >= last_index)
            throw new NoMatchedCourseException("start_index must be less than last index");
        int index = 0;
        LinkedList<Course> tempList = new LinkedList<>();
        ListIterator<Course> iter = courses.listIterator();
        while(iter.hasNext()) {

            if (index >= start_index && index <= last_index)
                tempList.add(iter.next());
            else
                iter.next();
            index++;
        }
        return tempList;
    }




}
