
/**
 * Class for room of hotel.
 *
 * @author Efkan Durakli
 */
public class Room {

    private final Integer roomNumber;
    private String guestName;
    private RoomStateType roomState;

    /**
     * one parameter constructor to create Room object
     * @param roomNumber number of room
     */
    public Room(Integer roomNumber) {
        this.roomNumber = roomNumber;
        this.roomState = RoomStateType.EMPTY;
        guestName = "NoGuest";
    }

    /**
     * two parameter constructor to create Room object
     * @param roomNumber room number
     * @param roomState state of room
     */
    public Room(Integer roomNumber, RoomStateType roomState) {
        this.roomNumber = roomNumber;
        this.roomState = roomState;
        guestName = "NoGuest";
    }

    /**
     * three parameter constructor to create Room object
     * @param roomNumber room number
     * @param roomState state of room
     * @param guestName guest name of room
     */
    public Room(Integer roomNumber, RoomStateType roomState, String guestName) {
        this.roomNumber = roomNumber;
        this.roomState = roomState;
        this.guestName = guestName;
    }


    /**
     * This is the getter which gets the roomNumber
     * @return number of room
     */
    public Integer getRoomNumber(){
        return roomNumber;
    }

    /**
     * This is the getter which gets state of room
     * @return state of room
     */
    public RoomStateType getRoomState() {
        return roomState;
    }

    /**
     * This is the getter which gets guest name of room
     * @return guest name of room
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * This is the setter which sets the state of room
     * @param roomState the roomState to set
     */
    public void setRoomState(RoomStateType roomState) {
        this.roomState = roomState;
    }

    /**
     * This is the setter which sets the guest name of room
     * @param guestName guest name of room
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    /**
     * Returns string representation of Room object
     *
     * @return string representation of Room object
     */
    @Override
    public String toString() {
        return "Room " + roomNumber + " = " + roomState.toString();
    }
}
