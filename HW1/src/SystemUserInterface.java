/**
 * interface for Hotel Managament System Users methods
 *
 * @author Efkan Durakli
 */
public interface SystemUserInterface {


    /**
     * login to given system as this user
     * @param system ManagamentSystem to be logged in
     * @return if login is sucessful, return true if not, return false
     */
    boolean logInToSystem(ManagamentSystem system);

    /**
     * logout from given system
     * @param system ManagamentSystem to be logged out
     * @return if logout is sucessful, return true if not, return false
     */
    boolean logOutFromSystem(ManagamentSystem system);
}
