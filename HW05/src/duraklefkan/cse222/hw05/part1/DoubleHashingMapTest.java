package duraklefkan.cse222.hw05.part1;

import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test DoubleHashingMap methods.
 * @author Efkan Durakli
 */
class DoubleHashingMapTest {


    /**
     * methods to test size method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void size() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        assertEquals(0, map.size());
        map.put("131044045", "Burak");
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        map.put("141044013", "Fatih");
        map.put("131044072", "Kevser");
        assertEquals(5, map.size());
    }

    /**
     * methods to test isEmpty method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void isEmpty() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        assertTrue(map.isEmpty());
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        assertFalse(map.isEmpty());
    }

    /**
     * methods to test containsKey method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void containsKey() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        map.put("131044045", "Burak");
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        map.put("141044013", "Fatih");
        map.put("131044072", "Kevser");
        assertTrue(map.containsKey("141044013"));
        assertFalse(map.containsKey("161044086"));

    }

    /**
     * methods to test containsValue method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void containsValue() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        map.put("131044045", "Burak");
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        map.put("141044013", "Fatih");
        map.put("131044072", "Kevser");
        assertTrue(map.containsValue("Burak"));
        assertFalse(map.containsValue("Efkan"));
    }

    /**
     * methods to test get method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void get() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        map.put("131044045", "Burak");
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        map.put("141044013", "Fatih");
        map.put("131044072", "Kevser");
        assertNull(map.get("161044086"));
        assertEquals("Kevser", map.get("131044072"));
    }

    /**
     * methods to test put method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void put() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        assertNull(map.put("131044045", "Burak"));
        assertEquals("Burak", map.put("131044045", "Kamil"));
    }

    /**
     * methods to test remove method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void remove() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        map.put("131044045", "Burak");
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        map.put("141044013", "Fatih");
        map.put("131044072", "Kevser");
        assertNull(map.remove("161044086"));
        assertEquals("Fatih", map.remove("141044013"));
    }

    /**
     * methods to test putAll method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void putAll() {
        DoubleHashingMap<String, String> map1 = new DoubleHashingMap<>();
        DoubleHashingMap<String, String> map2 = new DoubleHashingMap<>();
        map2.put("131044045", "Burak");
        map2.put("141044091", "Burak");
        map2.put("161044087", "Cengiz");
        map2.put("141044013", "Fatih");
        map2.put("131044072", "Kevser");
        try {
            map1.putAll(map2);
            fail("Excepted UnsupportedOperationException");
        }
        catch (UnsupportedOperationException exc) {
            assertEquals(exc.getMessage(), "putAll method is not supported for this map.");
        }
    }

    /**
     * methods to test clear method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void clear() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        map.put("131044045", "Burak");
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        map.put("141044013", "Fatih");
        map.put("131044072", "Kevser");
        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    /**
     * methods to test keySet method of DoubleHashingMap
     */
    @org.junit.jupiter.api.Test
    void keySet() {
        DoubleHashingMap<String, String> map = new DoubleHashingMap<>();
        map.put("131044045", "Burak");
        map.put("141044091", "Burak");
        map.put("161044087", "Cengiz");
        map.put("141044013", "Fatih");
        map.put("131044072", "Kevser");
        HashSet<String> set = new HashSet<>();
        set.add("131044045");
        set.add("141044091");
        set.add("161044087");
        set.add("141044013");
        set.add("131044072");
        assertEquals(set, map.keySet());
    }
}