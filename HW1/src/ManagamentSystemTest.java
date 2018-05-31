import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test class to test ManagamentSystem class methods
 *
 * @author Efkan Durakli
 */
class ManagamentSystemTest {

    /**
     * test method to test addUser method of ManagamentSystem class
     */
    @Test
    void addUser() {

        ManagamentSystem system = new ManagamentSystem();
        assertTrue(system.addUser(new HotelGuest("harun","sifre")));
        assertFalse(system.addUser(new HotelGuest("harun","sifre")));
    }

    /**
     * test method to test chekUser method of ManagamentSystem class
     */
    @Test
    void checkUser() {

        ManagamentSystem system = new ManagamentSystem();
        assertTrue(system.checkUser("Receptionist1",UserType.RECEPTIONIST));
        assertFalse(system.checkUser("yahya",UserType.GUEST));

    }

    /**
     * test method to test checkUserPassword method of ManagamentSystem class
     */
    @Test
    void checkUserPasWord() {
        ManagamentSystem system = new ManagamentSystem();
        assertTrue(system.checkUserPasWord("Receptionist1", "789"));
        assertFalse(system.checkUserPasWord("Receptionist1", "789efed"));
    }
}