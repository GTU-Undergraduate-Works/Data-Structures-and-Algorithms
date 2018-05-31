import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test class to test SytemUser class methods
 *
 * @author Efkan Durakli
 */
class SystemUserTest {

    /**
     * test method to test logInToSystem method of SytemUser class
     */
    @Test
    void logInToSystem() {

        Receptionist receptionist1 = new Receptionist("Receptionist1", "789");
        Receptionist receptionist2 = new Receptionist("Receptionist1", "78ev9");
        ManagamentSystem system = new ManagamentSystem();
        assertTrue(receptionist1.logInToSystem(system));
        assertFalse(receptionist2.logInToSystem(system));
    }

    /**
     * test method to test logOutFromSystem method of SytemUser class
     */
    @Test
    void logOutFromSystem() {

        Receptionist receptionist1 = new Receptionist("Receptionist1", "789");
        Receptionist receptionist2 = new Receptionist("Receptionist1", "78ev9");
        ManagamentSystem system = new ManagamentSystem();
        receptionist1.logInToSystem(system);
        assertTrue(receptionist1.logOutFromSystem(system));
    }
    /**
     * test method to test bookRoom method of SytemUser class
     */
    @Test
    void bookRoom() {
        Receptionist receptionist = new Receptionist("Receptionist1", "789");
        ManagamentSystem system = new ManagamentSystem();
        receptionist.logInToSystem(system);
        assertTrue(receptionist.bookRoom(system, 15,"veli"));
    }

    /**
     * test method to test cancelReservation method of SytemUser class
     */
    @Test
    void cancelReservation() {
        Receptionist receptionist = new Receptionist("Receptionist1", "789");
        ManagamentSystem system = new ManagamentSystem();
        receptionist.logInToSystem(system);
        receptionist.bookRoom(system, 3,"sinan");
        assertTrue(receptionist.cancelReservation(system,3));
    }
}