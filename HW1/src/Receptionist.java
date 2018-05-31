/**
 * class for recepsionists of hotel
 *
 * @author Efkan Durakli
 */
public class Receptionist extends SystemUser {



    /**
     * two parameter constructor to create Recepcionist object
     * @param userName
     * @param password
     */
    public Receptionist(String userName, String password) {
        super(userName, password);
        this.userType = UserType.RECEPTIONIST;
    }

    /**
     * check in for given room number and guestname
     * @param system system to chek in
     * @param roomNumber room number to check in
     * @param guestName guest name to check in
     * @return if check in operation is successfull return true, if not return false
     */
    public boolean chekIn(ManagamentSystem system, Integer roomNumber, String guestName) {

        boolean flag = false;
        boolean flag2 = false;
        for (int i = 0; i < system.getNumberOfRoom(); i++) {
            if (system.getRoom(i).getRoomNumber() == roomNumber) {
                flag2 = true;
                if (system.getRoom(i).getRoomState() == RoomStateType.EMPTY) {
                    system.getRoom(i).setRoomState(RoomStateType.FULL);
                    system.getRoom(i).setGuestName(guestName);
                    System.out.println("Chek-in is done successfully for " + guestName);
                    flag = true;
                }
                else if (system.getRoom(i).getRoomState() == RoomStateType.RESERVED) {
                    if (system.getRoom(i).getGuestName().equals(guestName)) {
                        system.getRoom(i).setRoomState(RoomStateType.FULL);
                        system.getRoom(i).setGuestName(guestName);
                        System.out.println("Chek-in is done successfully for " + guestName);
                        flag = true;
                    }
                    else {
                        System.out.println("Room " + roomNumber + " is reserved for " + system.getRoom(i).getGuestName());
                        flag = false;
                    }
                }
                else {
                    System.out.println("Room " + roomNumber + " is Full.");
                    flag = false;
                }
            }
        }
        if (!flag2)
            System.out.println("Room " + roomNumber + " is not exist.");
        system.updateRoomsRecordFile();
        return flag;
    }

    /**
     * check out for given room number
     * @param system system to chek out
     * @param roomNumber room number to check out
     * @return if check out operation is successfull return true, if not return false
     */
    public boolean checkOut(ManagamentSystem system, Integer roomNumber) {

        boolean flag = false;
        for (int i = 0; i < system.getNumberOfRoom(); i++) {
            if (system.getRoom(i).getRoomNumber() == roomNumber) {
                flag = true;
                if (system.getRoom(i).getRoomState() == RoomStateType.FULL) {
                    system.getRoom(i).setRoomState(RoomStateType.EMPTY);
                    System.out.println("Check-out is done sucessfully for " + system.getRoom(i).getGuestName());
                    system.getRoom(i).setGuestName("NoGuest");
                    system.updateRoomsRecordFile();
                    return true;
                }
                else {
                    System.out.println("No check-out for Room " + roomNumber);
                    return false;
                }
            }
        }
        if (!flag)
            System.out.println("Room " + roomNumber + "is not exist");
        return false;
    }
}
