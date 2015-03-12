import java.util.NoSuchElementException; 
import java.util.*;
abstract public class AbstractListNode {
    
    abstract public Comparable item();
    abstract public AbstractListNode next();
    abstract public boolean isEmpty();
    abstract public int size();
    // Every other list-processing method goes here.
    public Comparable smallest() {
        if (isEmpty()) {
            throw new NoSuchElementException ("can't find smallest in empty list");
        }
        return smallestHelper(this.item()) ;
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

    public AbstractListNode reverse() {
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
        return head;
    }

    public static AbstractListNode merge( AbstractListNode a, AbstractListNode b ) {
        if(a.isEmpty()) {
            return b;
        }
        if(b.isEmpty()) {
            return a;
        }
        AbstractListNode head = a;
        AbstractListNode previous = a;
        if (a.item().compareTo(b.item()) > 0 ) {
            head = b;
            previous = b;
        }
        
        while(!a.isEmpty() && !b.isEmpty()) {

            if( a.item().compareTo(b.item()) <= 0 ) { 
                previous = a;
                if(a.next() instanceof EmptyListNode) {
                    ((NonemptyListNode) a).setNext(b);
                    break;
                }
                a = a.next();
            }
            else if(a.item().compareTo(b.item()) > 0) {
                AbstractListNode temp = b.next();

                ((NonemptyListNode) previous).setNext(b);
                if(temp instanceof EmptyListNode) {
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

    public static AbstractListNode mergeAll( ArrayList<AbstractListNode> allLinkedLists ) {
        int size = allLinkedLists.size();
        if(size == 1) {
            return allLinkedLists.get(0);
        }
        int offset = 1;
        if(size%2 == 1) {
            offset = 2;
        }

        while(size > 2) {
            ArrayList<AbstractListNode> smallerLinkedLists  = new ArrayList<AbstractListNode>();
            for(int i = 0; i < allLinkedLists.size()- offset; i += 2) {
                smallerLinkedLists.add(merge(allLinkedLists.get(i), allLinkedLists.get(i+1)));
                // smallerLinkedLists.add(merge(allLinkedLists.get(i+2), allLinkedLists.get(i+3)));
            }
            if(offset == 2){
                smallerLinkedLists.add(allLinkedLists.get(size - 1));
                offset = 1;
            }
            else {
                offset = 2;
            }
            allLinkedLists = smallerLinkedLists;
            size = allLinkedLists.size();
        }
        AbstractListNode head = merge(allLinkedLists.get(0), allLinkedLists.get(1));
        return head;
    } 

    private static AbstractListNode makeSortedList(int listSize) {
        double[] nums = new double[listSize];
        for (int i = 0; i < listSize; i++) {
            Double k = Math.random()*10;
            nums[i] = (int)(k.intValue());
            }
        Arrays.sort(nums);
        AbstractListNode sortedList = new EmptyListNode();
        for (int i = nums.length - 1; i >= 0; i--) {
            sortedList = new NonemptyListNode(new Double(nums[i]), sortedList);
            }
        return sortedList;
    } 
    public static void main(String[] args) {
        // AbstractListNode list1 = new NonemptyListNode(2.0,new NonemptyListNode(3.0,new NonemptyListNode(6.0, new NonemptyListNode(7.0, new NonemptyListNode(9.0)))));
        // System.out.println("orginal List1  = " + list1.toString());

        // AbstractListNode list2 = new NonemptyListNode(2.0,new NonemptyListNode(2.0,new NonemptyListNode(3.0, new NonemptyListNode(4.0, new NonemptyListNode(9.0)))));
        // System.out.println("orginal List2  = " + list2.toString());
        // AbstractListNode list3 = list1.merge(list1, list2);

       
        // System.out.println("List1  = " + list1.toString());
        // System.out.println("List3  = " +list3.toString());
        // AbstractListNode list6 = new NonemptyListNode(11.0,new NonemptyListNode(14.0,new NonemptyListNode(29.0, new NonemptyListNode(30.0))));
        // AbstractListNode list4 = new NonemptyListNode(2.0,new NonemptyListNode(3.0,new NonemptyListNode(4.0, new NonemptyListNode(7.0))));
        // // System.out.println("List4  = " +list4.toString());
        // // System.out.println(list1.toString());

        // AbstractListNode list5 = list1.merge(list1, list6);
        // // System.out.println("After");

        // // AbstractListNod list6 = new NonemptyListNode(11.0,new NonemptyListNode(14.0,new NonemptyListNode(29.0, new NonemptyListNode(30.0))));
        // System.out.println("List1 = " + list1.toString());
        
        // // System.out.println("List4   = " +list4.toString());
        //  System.out.println("List5  = " +list5.toString());

        //  list5 = list1.merge(list1, list4);
        //  System.out.println("List1 = " + list1.toString());
        //   System.out.println("List5  = " +list5.toString());


        // AbstractListNode l1 =new NonemptyListNode(2.0,new NonemptyListNode(4.0,new NonemptyListNode(6.0, new NonemptyListNode(8.0, new NonemptyListNode(9.0)))));
        // AbstractListNode l1 = makeSortedList(5);
        // System.out.println("orginal List1  = " + l1.toString());
        // // AbstractListNode l2 = new NonemptyListNode(3.0,new NonemptyListNode(6.0,new NonemptyListNode(9.0, new NonemptyListNode(9.0, new NonemptyListNode(9.0)))));
        // AbstractListNode l2 = makeSortedList(5);
        // System.out.println("orginal List2  = " + l2.toString());
        // // AbstractListNode p1 = AbstractListNode.merge(l1, l2);
        // l1 = AbstractListNode.merge(l1,l2);
        // System.out.println("After 1st merge");
        // System.out.println("new List1  = " + l1.toString());
        // // System.out.println("p1  = " + p1.toString());

        // System.out.println("\n\n");
        // AbstractListNode l3 = makeSortedList(6);
        // System.out.println("orginal List3  = " + l3.toString());
        // // System.out.println("new List1  = " + l1.toString());
        // l1 = AbstractListNode.merge(l3, l1);
        // // System.out.println("After 1st merge");
        // System.out.println("new List1  = " + l1.toString());
        // // System.out.println("p1  =        " + p1.toString());



        /// TEst MergeAll
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
//         // System.out.println("thai.get()               = " + l1.toString());
            ArrayList<AbstractListNode> thai = new ArrayList<AbstractListNode>();
            for(int i = 1; i <= 5000/5; i++) {
                thai.add(makeSortedList(1000));
                thai.add(makeSortedList(1000));
                thai.add(makeSortedList(1000));
                thai.add(makeSortedList(1000));
                thai.add(makeSortedList(1000));
            }
            AbstractListNode result = mergeAll(thai);
            // System.out.println(result.toString());
    }

}

class NonemptyListNode extends AbstractListNode {

    private Comparable myItem;
    private AbstractListNode myNext;

    public NonemptyListNode (Comparable item, AbstractListNode next) {
        myItem = item;
        if (next == null) {
            myNext = new EmptyListNode();
        } else {
            myNext = next;
        }
    }

    public NonemptyListNode (Comparable item) {
        this (item, new EmptyListNode());
    }

    public Comparable item() {
        return myItem;
    }

    public AbstractListNode next() {
        return myNext;
    }

    public void setNext(AbstractListNode node) {
        this.myNext = node;
    }
    
    public boolean isEmpty() {
        return false;
    }
    public String toString() {
        AbstractListNode temp = this;
        String myString = "";
        while(!temp.isEmpty()) {
            myString +=temp.item() + " ";
            temp = temp.next();
        }
        return myString.substring(0,myString.length()-1);
    }
    public int size(){
        if(myNext.isEmpty()) {
            return 0;
        }
        return 1 + myNext.size();
    }
}

class EmptyListNode extends AbstractListNode {
    
    public EmptyListNode() {
        
    }
    
    public Comparable item() {
        throw new IllegalArgumentException ("There is no 'item' value stored in an EmptyListNode.");
    }
    
    public AbstractListNode next() {
        throw new IllegalArgumentException ("No elements follow an EmptyListNode.");
    }
    
    public boolean isEmpty() {
        return true;
    }
    public int size() {
        throw new IllegalArgumentException ("EmptyListNode has no size");
    }
}