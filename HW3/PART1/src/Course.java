/**
 * class to keep data of GTU CSE courses
 *
 * @author Efkan Duarkli
 */

public class Course {

    private Integer semester;
    private String courseCode;
    private String courseName;
    private Integer ectsCredit;
    private Integer gtuCredit;


    /**
     * Creates Course object with given initial values
     */
    public Course() {
        semester = 0;
        courseCode = null;
        courseName = null;
        ectsCredit = 0;
        gtuCredit = 0;
    }

    /**
     * Creates Course object with given values
     * @param semester semester of Course
     * @param courseCode course code of Course
     * @param courseName name of Course
     * @param ectsCredit ects credit of Course
     * @param gtuCredit gtu credit of Course
     */
    public Course(Integer semester, String courseCode, String courseName, Integer ectsCredit, Integer gtuCredit) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.ectsCredit = ectsCredit;
        this.gtuCredit = gtuCredit;
    }

    /**
     * This is the getter which gets name of course
     *@return name of course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This is the getter which gets semester of course
     * @return semester of course
     */
    public Integer getSemester() {
        return semester;
    }

    /**
     * This is the getter which gets the code of course
     * @return code of course
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * This is the getter which gets the GTU credit of course
     * @return GTU credit of course
     */
    public Integer getGtuCredit() {
        return gtuCredit;
    }

    /**
     * This is the getter which gets Ects credit of course
     * @return Ects credit of course
     */
    public Integer getEctsCredit() {
        return ectsCredit;
    }

    /**
     * This is the setter which sets semester of course
     * @param semester semester of course
     */
    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    /**
     * This the setter which sets the code of course
     * @param courseCode code of course
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * This the setter which sets the name of course
     * @param courseName name of course
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * This is the setter which sets the Ects credit of course
     * @param ectsCredit Ects credit of course
     */
    public void setEctsCredit(Integer ectsCredit) {
        this.ectsCredit = ectsCredit;
    }

    /**
     * This is the setter which sets GTU credit of corse
     * @param gtuCredit GTU credit of course
     */
    public void setGtuCredit(Integer gtuCredit) {
        this.gtuCredit = gtuCredit;
    }

    /**
     * compares given course object with this course
     * @param o course object to compare this course object
     * @return if courses are equal return true, if not return false
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Course)) {
            return false;
        }
        Course course = (Course) o;
        return (course.getSemester().equals(semester) && course.getCourseCode().equals(courseCode) &&
                course.getCourseName().equals(courseName) && course.getEctsCredit().equals(ectsCredit) &&
                course.getGtuCredit().equals(gtuCredit));
    }

    /**
     * Returns string representation of course.
     * @return string representation of course.
     */
    @Override
    public String toString() {
        return (semester + "  " + courseCode + "  " +
                courseName + " " + ectsCredit + " " + gtuCredit);
    }

}
