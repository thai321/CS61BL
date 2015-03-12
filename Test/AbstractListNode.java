import java.util.NoSuchElementException;
import java.util.*;

abstract public class AbstractListNode {
	abstract public Comparable item ( );
	abstract public AbstractListNode next ( );
	abstract public boolean isEmpty ( );
	abstract public int size ( );
	abstract public Object get (int index);
	abstract public String toString ( );
	abstract public boolean equals (Object obj1);
	// Every other list-processing method goes here.

	public Comparable smallest ( ) {
		if(this.isEmpty()) {
			throw new NoSuchElementException ("Can't find smalles in empty List");
		}
		return smallestHelper(this.item());
	}
	
	public Comparable smallestHelper (Comparable smallestSoFar) {
		AbstractListNode currNode = this;
		while (!currNode.isEmpty()) {
			smallestSoFar = min(currNode.item(), smallestSoFar);
			currNode = currNode.next();
		}
		return smallestSoFar;
	}
	
	public static Comparable min (Comparable c1, Comparable c2) {
		if (c1.compareTo(c2) < 0) {
			return c1;
		} else {
			return  c2;
		}
	}

	public AbstractListNode add (Comparable Node) {
		if (this.isEmpty()) {
			return new NonemptyListNode(Node);
		}
		NonemptyListNode rtnList = new NonemptyListNode (this.item());
		AbstractListNode currNode = this;
		while (!currNode.next().isEmpty()) {
			rtnList.setNext(currNode.next());
			currNode = currNode.next();
		}	
		rtnList.setNext(new NonemptyListNode(Node));
		return rtnList;
	}
	
	public AbstractListNode append (AbstractListNode toAppend) {
		
		if (this.isEmpty()) {
			return toAppend;
		} else if (toAppend.isEmpty()) {
			return this;
		}
		NonemptyListNode next = new NonemptyListNode (this.item());
		AbstractListNode curr = this;
		NonemptyListNode rtnList = next;
		while (!curr.next().isEmpty()) {
			NonemptyListNode Node = new NonemptyListNode (curr.next().item());
			next.setNext(Node);
			next = (NonemptyListNode) next.next();
			curr = curr.next();
		}
		next.setNext(toAppend);
		return rtnList;
	}

	public AbstractListNode reverse ( ) {
		if (this.isEmpty()) {
			return this;
		}
		AbstractListNode rtnList = new NonemptyListNode (this.item());
		AbstractListNode next = this.next();
		while (!next.isEmpty()) {
			AbstractListNode temp = new NonemptyListNode (next.item());
			((NonemptyListNode) temp).setNext(rtnList);
			rtnList = temp;
			next = next.next();
		}
		return rtnList;
	}

	public static AbstractListNode merge (AbstractListNode a, AbstractListNode b) {
		if (a.isEmpty()) {
			return b;
		} else if (b.isEmpty()) {
			return a;
		}
		AbstractListNode head = a;
		AbstractListNode previous = a;
		if (a.item().compareTo(b.item()) > 0) {
			head = b;
			previous = b;
		}
		while (!a.isEmpty() && !b.isEmpty()) {
			if (a.item().compareTo(b.item()) <= 0) {
				previous = a;
				if (a.next() instanceof EmptyListNode) {
					((NonemptyListNode) a).setNext(b);
					break;
				}
				a = a.next();
			} else if (a.item().compareTo(b.item()) > 0) {
				AbstractListNode temp = b.next();
				((NonemptyListNode) previous).setNext(b);
				if (temp instanceof EmptyListNode) {
					((NonemptyListNode) b).setNext(a);
					break;
				}
				((NonemptyListNode) b).setNext(a);
				previous = b;
				b = temp;
			}
		}
		return head;
	}

	public static AbstractListNode mergeAll (ArrayList<AbstractListNode> allLinkedLists) {
    	int size = allLinkedLists.size();
    	if (size == 1) {
        		return allLinkedLists.get(0);
    	}
		int offset = 1;
		if (size % 2 == 1) {
			offset = 2;
		}
		while (size > 2) {
			ArrayList<AbstractListNode> smallerLinkedLists  = new ArrayList<AbstractListNode>();
			for(int i = 0; i < allLinkedLists.size()- offset; i += 2) {
				smallerLinkedLists.add(merge(allLinkedLists.get(i), allLinkedLists.get(i+1)));
			}
			if (offset == 2){
				smallerLinkedLists.add(allLinkedLists.get(size - 1));
				offset = 1;
		    	} else {
				offset = 2;
		    	}
		    	allLinkedLists = smallerLinkedLists;
		    	size = allLinkedLists.size();
		}
		AbstractListNode head = merge(allLinkedLists.get(0), allLinkedLists.get(1));
		return head;
    	}


	public static void main (String[] args) {
		// AbstractListNode l1= makeSortedList(5);
		// System.out.println("orginal List1  = " + l1.toString());
		// AbstractListNode l2= makeSortedList(5);
		// System.out.println("orginal List2  = " + l2.toString());
		// AbstractListNode l3= makeSortedList(6);
		// System.out.println("orginal List3  = " + l3.toString());

		// ArrayList<AbstractListNode> thai = new ArrayList<AbstractListNode>();
		// thai.add(l1);
		// thai.add(l2);
		// thai.add(l3);
		// AbstractListNode p1 =  mergeAll(thai);
		// System.out.println("\nAfter:\nList1  = " + l1.toString());
		// System.out.println("\nAfter:\nList2  = " + l2.toString());
		// System.out.println("\nAfter:\nList3  = " + l3.toString());
		// System.out.println("p1   =   " + p1.toString());
		// ArrayList<AbstractListNode> allLists = new ArrayList<AbstractListNode>();
		// for(int i = 1; i <= 5000/5; i++) {
		// 	allLists.add(makeSortedList(1000));
		// 	allLists.add(makeSortedList(1000));
		// 	allLists.add(makeSortedList(1000));
		// 	allLists.add(makeSortedList(1000));
		// 	allLists.add(makeSortedList(1000));
		// }
		// AbstractListNode result = mergeAll(allLists);
	}
	
	private static AbstractListNode makeSortedList (int listSize) {
		double[] nums = new double[listSize];
		for (int i = 0; i < listSize; i++) {
			Double k = Math.random()*10;
			nums[i] = (int) (k.intValue());
		}
		Arrays.sort(nums);
		AbstractListNode sortedList = new EmptyListNode();
		for (int i = nums.length - 1; i >= 0; i--) {
			sortedList = new NonemptyListNode (new Double(nums[i]), sortedList);
		}
		return sortedList;
	}
}

class NonemptyListNode extends AbstractListNode {
	private Comparable myItem;
	private AbstractListNode myNext;

	public NonemptyListNode (Comparable item, AbstractListNode next) {
		myItem = item;
		if (next == null) {
			myNext = new EmptyListNode ();
		} else {
			myNext = next;
		}
	}
	
	public NonemptyListNode (Comparable item) {
		this (item, new EmptyListNode ());
	}
	
	public Comparable item ( ) {
		return myItem;
	}

	public AbstractListNode next ( ) {
		return myNext;
	}
	
	public void setNext (AbstractListNode node) {
		this.myNext = node;
	}

	public boolean isEmpty ( ) {
		return false;
	}
	
	public int size ( ) {
		if (myNext.isEmpty()) {
			return 0;
		} else {
			return 1 + myNext.size();
		}
	}
	
	public Object get (int index) {
		if (index > this.size()) {
			throw new IllegalArgumentException ("Index out of bound");
		} else if (index == 0) {
			return this.myItem;
		} else {
			return this.next().get(index - 1);
		}
	}
	
	public String toString ( ) {
		String repr = new String();
		for (int i = 0; i <= this.size(); i++) {
			repr += " " + this.get(i).toString();
		}
		return "(" + repr + " )";
	}
	
	public boolean equals (Object obj1) {
		if (obj1 instanceof AbstractListNode) {
			AbstractListNode obj1List = (AbstractListNode)obj1;
			return this.item().equals(obj1List.item()) && this.next().equals(obj1List.next());
		}
		return false;
	}
		
}

class EmptyListNode extends AbstractListNode {
	
	public void EmptyListNode ( ) {
	}

	public Comparable item ( ) {
		throw new IllegalArgumentException ("There is no 'item' value stored in an EmptyListNode.");
	}
	
	public AbstractListNode next ( ) {
		throw new IllegalArgumentException ("There's no next element in an EmptyListNode.");
	}

	public boolean isEmpty ( ) {
		return true;
	}
	
	public int size ( ) {
		throw new IllegalArgumentException ("An EmptyListNode has no size.");
	}
	
	public Object get (int index) {
		throw new IllegalArgumentException ("An EmptyListNode has no item.");
	}
	
	public String toString ( ) {
		throw new IllegalArgumentException ("An EmptyListNode had no string representation");
	}
	
	public boolean equals (Object obj1) {
		AbstractListNode obj1List = (AbstractListNode)obj1;
		return obj1List.isEmpty();
	}
}