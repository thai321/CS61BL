public class ModNCounter {

    private int myCount;
    private int n;
    
    public ModNCounter(int n) {
    	this.n = n;
    	myCount = 0;
    }

    public ModNCounter ( ) {
        myCount = 0;
    }

    public void increment ( ) {
    	myCount++;
        if(myCount == this.n)
        	myCount = 0;        
    }

    public void reset ( ) {
        myCount = 0;
    }
    
    public int value ( ) {
        return myCount;
    }
}