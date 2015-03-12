import java.util.NoSuchElementException; 

abstract public class AbstractListNode {
 abstract public Comparable item ();
 abstract public AbstractListNode next ();
 abstract public boolean isEmpty ();
 // Every other list-processing method goes here.
 abstract public int size();
 abstract public Comparable get(int pos);
 abstract public String toString();
 abstract public boolean equals(Object o);

 //Lab12
 public Comparable smallest() {
     if (isEmpty()) {
         throw new NoSuchElementException ("can't find smallest in empty list");
     }
     return smallestHelper(this.item()) ;
 }
 //Lab12
 public Comparable smallestHelper (Comparable smallestSoFar) {
     AbstractListNode currNode = this;
     while (!currNode.isEmpty()) {
             smallestSoFar = min(currNode.item(), smallestSoFar);
         currNode = currNode.next();
     }
     return smallestSoFar;
 }
 //Lab12
 public static Comparable min (Comparable c1, Comparable c2) {
     if (c1.compareTo (c2) < 0) {
         return c1;
     } else {
         return c2;
     }
 }
 
 //Lab12
 public AbstractListNode add(Comparable x) {
     AbstractListNode currNode = this;
     if (currNode.isEmpty()) {
         return new NonemptyListNode(x);
     }
     NonemptyListNode newList = new NonemptyListNode(currNode.item());
     while (!currNode.next().isEmpty()) {
         newList.setNext(currNode.next());
         currNode = currNode.next();
     }
     newList.setNext(new NonemptyListNode(x));
     return newList;
 }
 
 //Lab12
 public AbstractListNode append(AbstractListNode list) {
     AbstractListNode myList = this;
     if (myList.isEmpty()) {
         return list;
     }
     if (list.isEmpty()) {
         return myList;
     }
     NonemptyListNode newList = new NonemptyListNode(myList.item());
     NonemptyListNode head = newList;
     while (!myList.next().isEmpty()) {
         NonemptyListNode localNode = new NonemptyListNode(myList.next().item());
         newList.setNext(localNode);
         newList = (NonemptyListNode)newList.next();
         myList = myList.next();
     }
     newList.setNext(list);
     return head;
 }
 
 //Lab12
 public AbstractListNode reverse() {
//     AbstractListNode currNode = this;
     if (this.isEmpty()) {
         return this;
     }
     AbstractListNode current = this;
     AbstractListNode head = new NonemptyListNode(this.item());
     AbstractListNode next= current.next();
     while (!next.isEmpty()) {
         AbstractListNode temp = new NonemptyListNode(next.item());
        ((NonemptyListNode) temp).setNext(head);
         head = temp;
         next = next.next();
     }
//     NonemptyListNode newList = new NonemptyListNode(currNode.item());
     return head;
     
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
 public Comparable item () {
     return myItem;
 }
 public void setItem(Comparable o) {
     this.myItem = o;
 }
 //Lab12
 public AbstractListNode next () {
     return myNext;
 }
 //Lab12
 public void setNext(AbstractListNode node) {
     this.myNext = node;
 }
 public boolean isEmpty () {
     return false;
 }
 //iterative size() method
 public int size() {
     AbstractListNode nonEmpty = this;
     int counter = 0;
     while (!nonEmpty.isEmpty()) {
         counter++;
         nonEmpty = nonEmpty.next();
     }
     return counter;
 }

 public Comparable get(int position) {
     AbstractListNode node = this;
     int pos = 0;
     while (!node.isEmpty()) {
         if (pos == position) {
             return node.item();
         }
         pos++;
         node = node.next();
     }
     throw new IllegalArgumentException("Position is out of range");
 }

 
 public String toString() {
     AbstractListNode lst = this;
     String toRtn = "(";
     for (; !lst.isEmpty(); lst = lst.next()) {
         toRtn = toRtn + " " + lst.item().toString();
     }
     return toRtn + " " + ")";
 }

 //equals() method
 public boolean equals(Object o) {
     AbstractListNode lnode = null;
     try {
         lnode = (AbstractListNode) o;
     }
     catch (ClassCastException e) {
         return false;
     }
     if (this.size() != lnode.size()) {
         return false;
     }
     if (this.isEmpty()) {
         return true;
     }
     else {
         return this.item().equals(lnode.item()) && this.next().equals(lnode.next());
     }
 }
}

class EmptyListNode extends AbstractListNode {
 public EmptyListNode () {
 }
 public Comparable item () {
     throw new IllegalArgumentException ("There is no 'item' value stored in an EmptyListNode.");
 }
 public AbstractListNode next () {
     throw new IllegalArgumentException ("No elements follow an EmptyListNode.");
 }
 public boolean isEmpty () {
     return true;
 }
 //size() method
 public int size() {
     return 0;
 }
 //get() method
 public Comparable get(int position) {
     return null;
 }
 //toString() method
 public String toString() {
     return "( )";
 }
 //equals() method
 public boolean equals(Object o) {
     AbstractListNode lnode = null;
     try {
         lnode = (AbstractListNode) o;
     }
     catch (ClassCastException e) {
         return false;
     }
     if (!lnode.isEmpty()) {
         return false;
     }
     return true;
 }
}

