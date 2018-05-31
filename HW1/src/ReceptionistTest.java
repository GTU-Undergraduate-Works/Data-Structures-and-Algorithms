import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test class to test Receptionist class methods
 *
 * @author Efkan Durakli
 */
class ReceptionistTest {

    /**
     * test method to test chekIn method of Receptionist class
     */
    @Test
    void chekIn() {

        Receptionist receptionist = new Receptionist("Receptionist1", "789");
        ManagamentSystem system = new ManagamentSystem();
        receptionist.logInToSystem(system);
        assertTrue(receptionist.chekIn(system, 15, "sezer"));
        assertFalse(receptionist.chekIn(system, 15, "ahmet"));
    }

    /**
     * test method to test checkOut method of Receptionist class
     */
    @Test
    void checkOut() {
        Receptionist receptionist = new Receptionist("Receptionist1", "789");
        ManagamentSystem system = new ManagamentSystem();
        receptionist.logInToSystem(system);
        receptionist.chekIn(system, 10, "zeynep");
        assertTrue(receptionist.checkOut(system, 10));
        assertFalse(receptionist.checkOut(system,10));
    }
}