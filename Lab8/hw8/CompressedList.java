import java.util.ArrayList;
import java.util.Iterator;

public class CompressedList<T> implements Iterable<T>{

    private ArrayList<CompressedObject> myValues;

    private int count = 0;
    private int size = 0;
    private int index = 0;
    private int begin = 0;

    public CompressedList() {
        myValues = new ArrayList<CompressedObject>();
    }

    public Iterator<T> iterator() {

        return new myClassIterator();
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


    private class myClassIterator implements Iterator<T> {

        public void remove(){
            CompressedObject p = myValues.get(index);
            if(p.getCount() <= 1) {
                myValues.remove(index);
            }
            p.setCount(p.getCount() - 1);
        }

        public T next(){
            CompressedObject p = myValues.get(index);
            T value;

            if(count < p.getCount()) {
                value = p.getItem();
                count++;
            }
            else {
                index++;
                p = myValues.get(index);
                value = p.getItem();
                count = 1;
            }
            begin++;
            return value;
        }
        public boolean hasNext(){
            size = 0;
            for(CompressedObject temp: myValues) {
                size += temp.getCount();
            }
            return begin < size;
        }

    }
    public static void main(String[] args) {
        CompressedList<String> list = new CompressedList<String>();
        list.addItem("a");
        list.addItem("b");
        list.addItem("b");
        list.addItem("b");
        list.addItem("c");

        
        // for(String s: list) {
        //     System.out.print(s + " ");
        // }
        // System.out.println();

        Iterator a = list.iterator();
        // while(a.hasNext()) {
        //     System.out.print(a.next() + " ");
        // }
        // System.out.println();
        // a.remove();
        // a.remove();
        // a.remove();
        // a.remove();
        // a.remove();

        while(a.hasNext()) {
            System.out.print(a.next() + " ");
        }
        System.out.println();
        

    }
}

