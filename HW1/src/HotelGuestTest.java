import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test class to test HotelGuest class methods
 *
 * @author Efkan Durakli
 */
class HotelGuestTest {

    /**
     * test for regirToSystem method of HotelGuest class
     */
    @Test
    void registerToSystem() {
        ManagamentSystem system = new ManagamentSystem();
        HotelGuest guest1 = new HotelGuest("kamil", "456");
        assertTrue(guest1.registerToSystem(system));
        HotelGuest guest2 = new HotelGuest("kamil", "456d");
        assertFalse(guest2.registerToSystem(system));
    }
}