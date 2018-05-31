/**
 * Enumarations to keep user type of Hotel Management System.
 *
 * @author Efkan Durakli
 */
public enum UserType {

    // Eumerations

    /**
     * represents admin of hotel managament system
     */
    ADMIN,

    /**
     * represents Guest of hotel managament system
     */
    GUEST,

    /**
     * represents Recepcionist of hotel managament system
     */
    RECEPTIONIST;

    // string representation of enumarations
    private static final String ADMIN_TO_STR = "Admin";
    private static final String GUEST_TO_STR = "Guest";
    private static final String RECEPTIONIST_TO_STR = "Receptionist";

    /**
     * parses given string to UserType, by looking string
     * representation
     * @param userType user type in string format
     * @return parsed user type
     * @throws Exception when given user type is invalid
     */
    public static UserType parse(String userType) throws Exception {

        if (userType.equals(ADMIN_TO_STR))
            return ADMIN;
        if (userType.equals(GUEST_TO_STR))
            return GUEST;
        if (userType.equals(RECEPTIONIST_TO_STR))
            return RECEPTIONIST;

        throw new Exception("Invalid user type " + userType);
    }

    /**
     * returns string representation of this enumaration
     *
     * @return string representation of this enumaration
     */
    @Override
    public String toString() {

        switch (this) {
            case ADMIN:
                return ADMIN_TO_STR;
            case GUEST:
                return GUEST_TO_STR;
            case RECEPTIONIST:
                return RECEPTIONIST_TO_STR;
        }
        return null;
    }
}
