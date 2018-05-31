import java.util.ArrayList;

/**
 * class to keep information of hotel
 *
 * @author Efkan Durakli
 */
public class Hotel {

    private ArrayList<Room> rooms;

    /**
     * no parameter constructor to create Hotel object
     */
    public Hotel() {
        rooms = new ArrayList<Room>();
    }

    /**
     * adds room thas has given fields to Hotel
     * @param roomNumber room number of room
     * @param state state of room
     * @param guestName guest name of room
     */
    public void addRoom(Integer roomNumber, RoomStateType state, String guestName) {
        rooms.add(new Room(roomNumber, state, guestName));
    }

    /**
     * gets given index of rooms array list
     * @param index index of Room in arraylist to get
     * @return Room object in given index
     */
    public Room getRoom(int index) {
        return rooms.get(index);
    }

    /**
     *
     * @return
     */
    public int getNumberOfRoom() {
        return rooms.size();
    }

    /**
     * prints rooms of hotel on screen
     */
    void printRooms() {
        System.out.println("RoomNumber  RoomState");
        for (int i = 0; i < rooms.size(); i++)
            System.out.printf("%03d  %15s%n", rooms.get(i).getRoomNumber(), rooms.get(i).getRoomState().toString());
    }
}
