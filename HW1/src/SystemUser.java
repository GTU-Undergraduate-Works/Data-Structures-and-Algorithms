import java.util.ArrayList;

/**
 * class for Hotel Management System Users
 *
 * @author Efkan Durakli
 */
public abstract class SystemUser implements SystemUserInterface {

    private final String userName;
    private String password;
    protected UserType userType;
    protected ArrayList<Integer> reservedRoomNumbers;

    /**
     * two parameter construtor to create SytemUser Object
     * @param userName user name of system user
     * @param password password of system user
     */
    public SystemUser(String userName, String password) {
        reservedRoomNumbers = new ArrayList<Integer>();
        this.userName = userName;
        this.password = password;
        userType = null;
    }

    /**
     * This is the getter which gets password of SystemUser
     * @return currant password of this user
     */
    public String getPassword() {
        return password;
    }

    /**
     * This is the getter which gets username of SystemUser
     * @return currant username of this user
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This is the getter which gets userTyepe of System
     * @return currant username of this user
     */
    public UserType getUserType() {
        return userType;
    }


    /**
     * log in to given system
     * @param system system to log in
     * @return if sucessfull return true, if not return false
     */
    @Override
    public boolean logInToSystem(ManagamentSystem system) {

        if (!system.checkUser(userName, this.userType)) {
            System.err.println("Invalid user name!");
            return false;
        }
        if (!system.checkUserPasWord(userName,password)) {
            System.err.println("Invalid password!");
            return false;
        }
        System.out.println("You logged in as " + this.userType.toString() + " successfully.");
        system.setLoginState(true);
        system.setLoggedUser(this);
        return true;
    }

    /**
     * log out from given system
     * @param system system to log out
     * @return if sucessfull return true, if not return false
     */
    @Override
    public boolean logOutFromSystem(ManagamentSystem system) {

        if (!system.getLoggedUser().equals(this)) {
            System.err.println("You must login before you can log out!");
            return false;
        }
        system.setLoggedUser(null);
        system.setLoginState(false);
        return true;
    }

    /**
     * books Room for given room number and guest name
     * @param system system to book room
     * @param roomNumber number of room to book
     * @param guestName name of guest to book room
     * @return if sucessfull return true, if not return false
     */
    boolean bookRoom(ManagamentSystem system, Integer roomNumber, String guestName) {

        if (!system.getLoggedUser().equals(this)) {
            System.err.println("You have to log in to book room!");
            return false;
        }
        for (int i = 0; i < system.getNumberOfRoom(); i++) {
            if (system.getRoom(i).getRoomNumber() == roomNumber) {
                if (system.getRoom(i).getRoomState() == RoomStateType.EMPTY) {
                    system.getRoom(i).setRoomState(RoomStateType.RESERVED);
                    if (getUserType() == UserType.GUEST)
                        system.getRoom(i).setGuestName(this.getUserName());
                    else if (getUserType() == UserType.RECEPTIONIST)
                        system.getRoom(i).setGuestName(guestName);
                    reservedRoomNumbers.add(roomNumber);
                    system.updateRoomsRecordFile();
                    if (getUserType() == UserType.GUEST)
                        System.out.println("You have successfully booked for Room " + roomNumber);
                    else if (getUserType() == UserType.RECEPTIONIST)
                        System.out.println("You have succesfully booked Room " + roomNumber + " for " + guestName);
                    return true;
                }
                else if (system.getRoom(i).getRoomState() == RoomStateType.RESERVED &&
                        system.getRoom(i).getGuestName().equals(userName)) {
                    if (getUserType() == UserType.GUEST)
                        System.out.println("You already booked for Room " + roomNumber);
                    else if (getUserType() == UserType.RECEPTIONIST)
                        System.out.println("Room " + system.getRoom(i).getRoomNumber() + " is already booked for " + guestName);
                    return false;
                }
                else {
                    System.err.println("Room " + roomNumber + " is" + system.getRoom(i).getRoomState().toString());
                    return false;
                }
            }
        }
        System.err.println("There is no room with number " + roomNumber);
        return false;
    }

    /**
     * books Reservation for given room number
     * @param system system to cancel reservation
     * @param roomNumber number of room to cancel reservation
     * @return
     */
    boolean cancelReservation(ManagamentSystem system, Integer roomNumber) {

        for (int i = 0; i < system.getNumberOfRoom(); i++) {

            if (roomNumber == system.getRoom(i).getRoomNumber() &&
                    system.getRoom(i).getGuestName().equals(userName) &&
                    system.getRoom(i).getRoomState().toString().equals("Reserved") &&
                    userType == UserType.GUEST) {
                system.getRoom(i).setRoomState(RoomStateType.EMPTY);
                system.getRoom(i).setGuestName("NoGuest");
                system.updateRoomsRecordFile();
                reservedRoomNumbers.remove(roomNumber);
                System.out.println("Your reservation is canceled sucessfully for Room " + roomNumber);
                return true;
            }
            else if (userType == UserType.RECEPTIONIST &&
                    roomNumber == system.getRoom(i).getRoomNumber() &&
                    system.getRoom(i).getRoomState().toString().equals("Reserved")) {
                system.getRoom(i).setRoomState(RoomStateType.EMPTY);
                system.getRoom(i).setGuestName("NoGuest");
                system.updateRoomsRecordFile();
                System.out.println("Reservation is canceled sucessfully for Room " + roomNumber);
                return true;
            }
        }
        System.out.println("There is no reservation for Room " + roomNumber);
        return false;
    }

    /**
     * check whether two SystemUSer object is equal
     * @param o object to compare this object
     * @return if equal return true, if not return false
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SystemUser))
            return false;
        SystemUser user = (SystemUser) o;
        return (userName.equals(user.getUserName())
                && password.equals(user.getPassword())
                && userType == user.getUserType());
    }

    /**
     * sets reserved room os this user
     * @param system ManagamentSystem object
     */
    void setReservedRoomNumbers(ManagamentSystem system) {
        for (int i = 0; i < system.getNumberOfRoom(); i++) {
            if (userName.equals(system.getRoom(i).getGuestName()) &&
                    system.getRoom(i).getRoomState().toString().equals("Reserved"))
                reservedRoomNumbers.add(system.getRoom(i).getRoomNumber());
        }
    }
}
