
/**
 * Enumarations to keep state of room.
 *
 * @author Efkan Durakli
 */
public enum RoomStateType {

    // Enumarations

    /**
     * represents state when room is full
     */
    FULL,

    /**
     * represents state when room is reserved
     */
    RESERVED,

    /**
     * represents state when room is empty
     */
    EMPTY;


    // string representation of enumarations
    private static final String FULL_TO_STR = "Full";
    private static final String RESERVED_TO_STR = "Reserved";
    private static final String EMPTY_TO_STR = "Empty";


    /**
     * Parses given string to RoomStateType, by looking string
     * representations.
     * @param roomStateType room state type in string format
     * @return parsed room state type
     * @throws Exception when given room state type is invalid
     */
    public static RoomStateType parse(String roomStateType) throws Exception {

        if (roomStateType.equals(FULL_TO_STR))
            return FULL;
        if (roomStateType.equals(RESERVED_TO_STR))
            return RESERVED;
        if (roomStateType.equals(EMPTY_TO_STR))
            return EMPTY;

        throw new Exception("Invalid room state type " + roomStateType);
    }

    /**
     * Returns with string representation of this enumaration.
     *
     * @return string representation of this enumaration
     */
    @Override
    public String toString() {

        switch(this) {

            case FULL:
                return  FULL_TO_STR;
            case RESERVED:
                return RESERVED_TO_STR;
            case EMPTY:
                return EMPTY_TO_STR ;
        }
        return null;
    }
}
