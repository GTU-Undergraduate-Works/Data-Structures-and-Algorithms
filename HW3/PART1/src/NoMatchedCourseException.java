/**
 * Exception class to handle GtuCseCourses class methos
 *
 * @author Efkan Durakli
 */
public class NoMatchedCourseException extends Exception {

    public NoMatchedCourseException(String message) {
        super(message);
    }

    /**
     * construct new exception with specified cause
     * @param cause cause of exception
     */
    public NoMatchedCourseException(Throwable cause) {
        super(cause);
    }

    /**
     * construct new exception with specified message and cause
     * @param message message of exception
     * @param cause cause of exception
     */
    public NoMatchedCourseException(String message, Throwable cause) {
        super(message, cause);
    }



}
