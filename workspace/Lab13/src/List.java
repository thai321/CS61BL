import java.util.*;
public class List implements Iterable{

	private ListNode myHead;
	private int mySize;
	private ListNode myTail;

	public List() {
		myHead = null;
		mySize = 0;
		myTail = null;
	}

	public boolean isEmpty() {
		return myHead == null;
	}

	private static class ListNode {

		private Object myItem;
		private ListNode myNext;

		private ListNode (Object first, ListNode rest) {
			myItem = first;
			myNext = rest;
		}

		private ListNode (Object first) {
			myItem = first;
			myNext = null;
		}

	}

	// public boolean isOK() {

	// }

	public Iterator iterator() {
		return new SequenceIterator();
	}
	public class SequenceIterator implements Iterator {
		private int i;
		private ListNode p;
		private int size;
		private ListNode current;
		public SequenceIterator() {
		// YOUR CODE HERE
			i = 0;
			size = size();
			current = myHead;
			p = myHead;
		}
		public boolean hasNext() {
		// YOUR CODE HERE
			return current != null;
		}
		public Object next() {
		// YOUR CODE HERE
			p = current;
			current = current.myNext;
			return p.myItem;
		}
		public void remove() {
		// YOUR CODE HERE
			ListNode temp = current;
			current = current.myNext;
			p.myNext = current;
			temp.myNext = null;
		}
	} 

	public String toString() {
		String rtn = "( ";
		for (ListNode p = myHead; p != null; p = p.myNext) {
			rtn = rtn + p.myItem + " ";
		}
		return rtn + ")";
	}

	// Return the number of items in this list ("length" in Scheme).
	public int size() {
		// int rtn = 0;
		// ListNode p = myHead;
		// while(p.myNext != null) {
		// 	p = p.myNext;
		// 	mySize++;
		// }
		// myTail = p;
		return mySize;
	}

	// Return true if the list contains the object 
	public boolean contains (Object obj) {
		for (ListNode p = myHead; p != null; p = p.myNext) {
			if (obj.equals (p.myItem)) {
				return true;
			}
		}
		return false;
	}

	// Returns the element at the given position in this list.
	public Object get (int pos) {
		if (pos < 0) {
			throw new IllegalArgumentException (
					"Argument to get must be at least 0.");
		}
		if (pos >= size()) {
			throw new IllegalArgumentException ("Argument to get is too large.");
		}
		int k = 0;
		for (ListNode p = myHead; p != null; p = p.myNext) {
			if (k == pos) {
				return p.myItem;
			}
			k++;
		}
		return null;
	}
	
	public void addToFront (Object obj) {
		myHead = new ListNode (obj, myHead);
		myTail = myHead;
		mySize++;
	}

	public boolean equals (Object obj) {
		// YOUR CODE HERE
		if (this == null) {
			return obj == null;
		}
		ListNode p = this.myHead;
		ListNode k = ((List) obj).myHead;
		while (p != null && k != null) {
			if (p.myItem != k.myItem) {
				return false;
			}
			p = p.myNext;
			k = k.myNext;
		}
		return p == null && k == null;
	}

	public void add (Object x) {
		ListNode temp = new ListNode(x);
		if(mySize == 0) {
			myHead = temp;
		}
		else if (this.myHead == null && this.myTail == null) {
			this.myHead = temp;
		}
		else{
			this.myTail.myNext= temp;
		}
		this.myTail = temp;
		mySize++;
	}
	public void appendInPlace (List l) {
		if (this.myHead == null) {
			this.myHead = l.myHead;
			this.myTail = l.myTail;
			this.mySize += l.mySize;
		}
		else if(l.mySize == 1) {
			this.myTail.myNext = l.myHead;
			this.myTail = l.myHead;
			this.mySize++;
		}
		else {
			this.myTail.myNext = l.myHead;
			this.myTail = l.myTail;
			this.mySize += l.mySize;
		}	
	}
	public void remove(Object n) {
		int count = 0;
		ListNode temp = null;
		ListNode h = this.myHead;
		ListNode p = h;
		while(this.myHead.myItem.equals(n) && myHead != myTail){
			temp = myHead;
			myHead = myHead.myNext;
			temp.myNext = null;
			count++;
			h = myHead;
		}
		
		h = this.myHead;
		p = h;
		while(h != myTail && h != null) {
			if(h.myItem.equals(n)) {
				temp = h;
				p.myNext = h.myNext;
				h = h.myNext;
				temp.myNext = null;
				count++;
			}
			else {
				p = h;
				h = h.myNext;
			}
		}
		if(h == myTail && h.myItem.equals(n) || myHead == myTail&& h.myItem.equals(n)) {
			temp = myTail;
			p.myNext = null;
			myTail = p;
			temp.myNext = null;
			count++;
		}
		mySize -= count;
	} 

	public void doubleInPlace() {
		for (ListNode p = myHead; p != null; p = p.myNext) {
			p.myNext = new ListNode(p.myItem, p.myNext);
			p = p.myNext;
		}
	} 

	public void reverse() {
		myHead = myTail;
		reverseHelper(this.myHead, myTail);
	}
	
	public static void reverseHelper(ListNode L, ListNode soFar) {
//		if(L == null) {
//			return;
//		}
//		ListNode  p = new ListNode(L.myItem, new reverseHelper(L.myNext, soFar));

	} 

}