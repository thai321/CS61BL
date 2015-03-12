import java.util.ArrayList;

public class CompressedList<T> {

    private ArrayList<CompressedObject> myValues;

    public CompressedList() {
        myValues = new ArrayList<CompressedObject>();
    }

    public void addItem(T item) {
        if (myValues.size() == 0) {
    		myValues.add(new CompressedObject(item, 1));
    		return;
    	}
        CompressedObject lastRun = myValues.get(myValues.size() - 1);
        if (lastRun.getItem().equals(item)) {
            lastRun.incrementCount();
        } else {
            myValues.add(new CompressedObject(item, 1));
        }
    }

    private class CompressedObject {

        private T myItem;
        private int myCount;

        public CompressedObject(T item, int count) {
            myItem = item;
            myCount = count;
        }

        public T getItem() {
            return myItem;
        }

        public void incrementCount() {
            myCount++;
        }

        public int getCount() {
            return myCount;
        }

        public void setCount(int count) {
            myCount = count;
        }

    }

}

