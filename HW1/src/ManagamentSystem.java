import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to keep data of Hotel Managament System
 *
 * @author Efkan Durakli
 */
public class ManagamentSystem {

    private static final String ROOMS_FILE_NAME = "Resources/rooms.csv";
    private static final String USERS_FILE_NAME = "Resources/users.csv";
    private SystemUser loggedUser;
    private boolean loginState;
    private Hotel hotel;
    private ArrayList<SystemUser> users;

    /**
     * no parameter to create ManagamentSystem object
     */
    public ManagamentSystem() {
        hotel = new Hotel();
        users = new ArrayList<SystemUser>();
        readRoomsRecordFile(ROOMS_FILE_NAME);
        readUsersRecordFile(USERS_FILE_NAME);
        loginState = false;
        loggedUser = null;
    }

    /**
     * reads room's records from room's record file
     * updates hotel object according to records
     * @param recordFileName the name of file to read records
     */
    void readRoomsRecordFile(String recordFileName) {
        File file = new File(recordFileName);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String data = input.next();
                String[] values = data.split(";");
                hotel.addRoom(Integer.parseInt(values[0]), RoomStateType.parse(values[1]), values[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * reads users's records froms users record file
     * update users list according to records
     * @param recordFileName the name of file to read records
     */
    void readUsersRecordFile(String recordFileName) {
        File file = new File(recordFileName);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String data = input.next();
                String[] values = data.split(";");
                    if (values[2].equals("Guest"))
                    users.add(new HotelGuest(values[0], values[1]));
                else if (values[2].equals("Receptionist"))
                    users.add(new Receptionist(values[0], values[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * updates users record file
     * write users records to users record file
     */
    public void updateUsersRecordFile() {
        try {
            FileWriter writer = new FileWriter(USERS_FILE_NAME);
            for (int i = 0; i < users.size(); i++) {
                writer.append(users.get(i).getUserName() + ";" + users.get(i).getPassword());
                if (users.get(i).getUserType().toString().equals("Guest"))
                    writer.append(";Guest\n");
                else if (users.get(i).getUserType().toString().equals("Receptionist"))
                    writer.append(";Receptionist\n");
                else if (users.get(i).getUserType().toString().equals("Admin"))
                    writer.append(";Admin\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * updates rooms record file
     * write rooms records to rooms record file
     */
    public void updateRoomsRecordFile() {

        try {
            FileWriter writer = new FileWriter(ROOMS_FILE_NAME);
            for (int i = 0; i < hotel.getNumberOfRoom(); i++) {
                writer.append(hotel.getRoom(i).getRoomNumber().toString() + ";");
                writer.append(hotel.getRoom(i).getRoomState().toString() + ";");
                writer.append(hotel.getRoom(i).getGuestName() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * add new user to system
     * if user is added to syccusfully return true, if user is exiist return false
     * @param user
     */
    public boolean addUser(SystemUser user) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(user.getUserName())) {
                System.err.println(user.getUserName() + " is exist!");
                return false;
            }
        }
        // check whether user object is Receptionist object
        if (user instanceof Receptionist) {
            // downcasting
            Receptionist receptionist = (Receptionist) user;
            try {
                FileWriter writer = new FileWriter(USERS_FILE_NAME, true);
                writer.append(receptionist.getUserName() + ";");
                writer.append(receptionist.getPassword() + ";");
                writer.append(user.getUserType().toString() + "\n");
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // check whether user object is HotelGuest object
        else if (user instanceof  HotelGuest) {
            // downcasting
            HotelGuest guest = (HotelGuest) user;
            try {
                FileWriter writer = new FileWriter(USERS_FILE_NAME, true);
                writer.append(guest.getUserName() + ";");
                writer.append(guest.getPassword() + ";");
                writer.append(user.getUserType().toString());
                writer.append("\n");
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        users.add(user);
        return true;
    }

    /**
     * checks whether given user name id registered
     * @param userName user name of system user
     * @return if user name is registered return true, if not return false
     */
    public boolean checkUser(String userName, UserType userType) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName) &&
                    users.get(i).getUserType() == userType)
                return true;
        }
        return false;
    }

    /**
     * checks the given password belongs to the given user
     * @param userName user name of system user
     * @param password password of system user
     * @return if password belongs to user name return true, if not return false
     */
    public boolean checkUserPasWord(String userName, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(userName))
                if (users.get(i).getPassword().equals(password))
                    return true;
                else
                    return false;
        }
        return false;
    }

    /**
     * This the getter which gets the login state of sytem
     * @return current login state of system
     */
    public boolean getLoginState() {
        return loginState;
    }

    /**
     * This the setter which sets the login state of sytem
     * @param loginState login state to set
     */
    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
    }

    /**
     * This is the getter which gets the logged user of system
     * @return logged user of system
     */
    public SystemUser getLoggedUser() {
        return loggedUser;
    }

    /**
     * This is the setter which sets the logged user of system
     * @param user logged to set
     */
    public void setLoggedUser(SystemUser user) {
        this.loggedUser = user;
    }

    /**
     *
     * @return
     */
    public int getNumberOfRoom() {
        return hotel.getNumberOfRoom();
    }

    /**
     * @param index index of Room object
     * @return Room which is found in the given index
     */
    public Room getRoom(int index) {
        return hotel.getRoom(index);
    }

    /**
     * print rooms of hotel in the system
     */
    public void printHotelRooms() {
        hotel.printRooms();
    }

    /**
     * prints reservations of given user
     * @param user user to prints reservation
     */
    public boolean printReservations(SystemUser user) {

        System.out.print("Your Reserverd Rooms : ");
        boolean flag = false;
        for (int i = 0; i < hotel.getNumberOfRoom(); i++) {
            if (user.getUserName().equals(hotel.getRoom(i).getGuestName()) &&
                    hotel.getRoom(i).getRoomState().toString().equals("Reserved")) {
                System.out.print("Room " + hotel.getRoom(i).getRoomNumber() + " ");
                flag = true;
            }
        }
        if (!flag)
            System.out.println("You don't have any reservations");
        else
            System.out.println("");
        return flag;
    }
}
