public class IntSequence {

    // instance variables
    protected int[] myValues;   // sequence elements
    int myCount;                // number of array cells used by sequence

    // constructor
    // capacity: actual size of the array or the (temporary) maximum
    // number of elements it can hold
    public IntSequence(int capacity) {
        this.myValues = new int[capacity];
        myCount = 0;
    }


	// Add the argument to the sequence by placing it in the first
    // unused spot in the array and incrementing the count.
    // Assume that the sequence isn't full.
    public void add(int toBeAdded) {
        if (myCount > myValues.length - 1) {
            System.err.println("No more spots in the array");
            System.exit(1);
        }
        myValues[myCount++] = toBeAdded;
    }

    // Insert toInsert into the sequence at position insertPos,
    // shifting the later elements in the sequence over to make room
    // for the new element.
    // Assumptions: The array isn't full, i.e. myCount < myValues.length
    // Also, insertPos is between 0 and myCount, inclusive.
    public void insert(int toInsert, int insertPos) {
        if (insertPos < 0 || insertPos > myCount || insertPos >= myValues.length){
            System.err.println("Invalid position");
            System.exit(1);
        }
        if(insertPos < myCount) {
            for (int k = myCount + 1; k > insertPos ; k--)
                myValues[k] = myValues[k-1];
        }
        myValues[insertPos] = toInsert;
        myCount++;
    }

    // other methods go here

    //Development for Remove
    public void remove(int pos) {
        if (pos < 0 || pos >= myCount || pos >= myValues.length){
            System.err.println("Invalid position");
            System.exit(1);
        }
        else if(isEmpty()) {
            System.err.println("There is no element to remove");
            System.exit(1);
        }

         while(pos < myCount - 1)
             myValues[pos++] = myValues[pos];
         myCount--;
    }

    //----Simple IntSequence methods-------
    public boolean isEmpty() {
        return myCount == 0 ;
    }

    public int size() {
        return myCount;
    }

    public int elementAt(int pos) {
        if (pos < 0 || pos >= myCount || pos >= myValues.length){
            System.err.println("Invalid position");
            System.exit(1);
        }
        return myValues[pos];
    }
    //--------------------------------------
    
    public boolean contains(int k) {
        if(!isEmpty()) {
            for(int i=0; i< myCount; i++) {
                if(myValues[i] == k)
                    return true;
            }
        }
        return false;
    }

    //IntSequence toString method
    public String toString() {
        String myString = "";
        for(int n: myValues)
            myString += n + " ";
        return myString.substring(0,myString.length() - 1);
    }
}
