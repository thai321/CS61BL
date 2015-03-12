import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapTest { 
        
    @Test 
    public void testCoreFunctionalities ( ) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        assertFalse(map.hasKey("One"));
        Object value = map.put("One", 2);
        assertNull(value);
        value = map.put("One", 1);
        assertTrue(value.equals(2));
        assertTrue(map.hasKey("One"));
        int size = map.size();
        assertTrue (size == 1);
        assertFalse(map.hasValue(10));
        map.put("Ten", 10);
        assertTrue(map.hasValue(10));
        value = map.remove("Ten");
        assertTrue(value.equals(10));
        size = map.size();
        assertTrue(size == 1);
        value = map.get("One");
        assertTrue (value.equals(1));
    }

    @Test 
    public void testAboveLoad ( ) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(5);
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.put("Five", 5);
        assertTrue(map.aboveLoad());
        map.resize(10);
        assertTrue(map.hasKey("One"));
        System.out.println ("Aa".hashCode());
        System.out.println ("BB".hashCode());
        map.put("Aa", 1);
        map.put("BB", 2);
        assertTrue(map.hasKey("Aa"));
        assertTrue(map.hasKey("BB"));

    }

}
