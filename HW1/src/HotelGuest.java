/**
 * class for guests of hotel
 *
 * @author Efkan Durakli
 */
public class HotelGuest extends SystemUser {


    /**
     * two parameter constructor to create HotelGuest object
     * @param userName username of HotelGuest
     * @param password password of HotelGuest
     */
    public HotelGuest(String userName, String password) {
        super(userName, password);
        this.userType = UserType.GUEST;
    }

    /**
     * regiters this HotelGuest to given system
     * @param system ManagamentSystem object to register
     * @return if register operation is sucessful return true, if not return false
     */
    public boolean registerToSystem(ManagamentSystem system) {
        if (system.addUser(this)) {
            System.out.println("You registered succesfully.");
            return true;
        }
        return false;
    }
}
