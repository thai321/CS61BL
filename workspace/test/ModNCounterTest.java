// JUnit test case
import junit.framework.TestCase;

public class ModNCounterTest extends TestCase {
    public void testConstructor ( ) {
        ModNCounter c = new ModNCounter ( );
        assertTrue (c.value () == 0);
    }

    public void testIncrement ( ) {
        ModNCounter c = new ModNCounter ( );
        c.increment ( );
        assertTrue (c.value()  == 1);
        c.increment ( );
        assertTrue (c.value() == 2);
        
        ModNCounter d = new ModNCounter(4);
    	assertTrue(d.value() == 0);
    	d.increment();
    	assertTrue (d.value()  == 1);
    	d.increment();
    	assertTrue (d.value()  == 2);
    	d.increment();
    	assertTrue (d.value()  == 3);
    	d.increment();
    	assertTrue (d.value()  == 0);
    }

    public void testReset ( ) {
        ModNCounter c = new ModNCounter ( );
        c.increment ( );
        c.reset ( );
        assertTrue (c.value () == 0);
    }
    ;
    
}