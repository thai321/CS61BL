import java.util.ArrayList;

public class kAryHeap {

    private ArrayList<Node> contents = new ArrayList<Node>();
    private int numChildren = 0; 

    // more instance variables would go here

    public kAryHeap(int k) {
        contents.add(null);
        numChildren = k;
    }

    public void insert(int value) {
        Node newNode = new Node(value, this, contents.size());
        contents.add(newNode);
        newNode.bubbleUp();
    }

    public Node removeMax() {
        Node rtnNode = this.getNode(1);
        if (this.contents.size() == 1) {
            return null;
        }
        if (this.contents.size() == 2) {
            this.contents.remove(1);
            return rtnNode;
        }
        swap(getNode(1), getNode(contents.size() - 1));
        contents.remove(contents.size() - 1);
        getNode(1).bubbleDown();
        return rtnNode;
    }

    private Node getNode(int index) {
        if (index >= contents.size()) {
            return null;
        } else {
            return contents.get(index);
        }
    }

    public int getSize() {
        return contents.size();
    }

    public ArrayList<Integer> getContents(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i < contents.size(); i++) {
            list.add(contents.get(i).myValue);
        }
        return list;
    }

    public int removeMaxItem() {
        return removeMax().myValue;
    }

    private void swap(Node node1, Node node2) {
        int index1 = node1.myIndex;
        int index2 = node2.myIndex;
        node1.myIndex = index2;
        node2.myIndex = index1;
        this.contents.set(index1, node2);
        this.contents.set(index2, node1);
    }

    private void print ( ) {
        for (int i = 1; i < contents.size(); i++) {
            System.out.println (contents.get(i).myValue);
        }
    }


    private class Node {

        private int myValue;
        private int myIndex;
        private kAryHeap myTree;

        private Node(int value, kAryHeap tree, int index) {
            this.myValue = value;
            this.myTree = tree;
            this.myIndex = index;
        }

        private Node ( ) {
        }

        // Return the ith child of this node (i ranges from 1 to n)
        private Node getChild(int i) {
            int beforeFirstChild = numChildren * this.myIndex - (numChildren - 1);
            return myTree.getNode(beforeFirstChild + i);
        }

        // Get the parent of this node
        private Node getParent() {
            if(myTree.contents.size() == 2) {
                return null;
            }
            if(this.myIndex % myTree.numChildren == 1) {
                return myTree.contents.get(this.myIndex/myTree.numChildren);
            }
            else {
                int index = ((this.myIndex + myTree.numChildren - 1)/ myTree.numChildren);
                return myTree.contents.get(index);
            }
        }

        // Bubble up a recently added node.
        private void bubbleUp() {
            if (this.myIndex > 1) {
                while (this.getParent() != null
                        && this.myValue > this.getParent().myValue) {
                    swap(this, this.getParent());
                        }
            }
        }

        // Bubble down a swapped element after a call to removeMax
        private void bubbleDown() {
            Node maxNode = new Node(); 
            ArrayList<Node> list = new  ArrayList<Node>();
            for (int i = 1; i <= numChildren; i++) {
                if(this.getChild(i) != null) {
                    list.add(this.getChild(i));
                }
            }
            if (list.size() >= 1) {
                for (int i = 0; i < list.size(); i++) {
                    maxNode = max(maxNode, list.get(i));
                }
                if(maxNode.myValue > this.myValue) {    
                    swap(maxNode, this);
                    this.bubbleDown();
                }
            }
            return;
        }

        // Determine the maximum of the two children
        // Invariant: Only one of node1 and node2 can be null.
        private Node max(Node node1, Node node2) {
            if (node1 == null) {
                return node2;
            } else if (node2 == null) {
                return node1;
            } else if (node1.myValue > node2.myValue) {
                return node1;
            } else {
                return node2;
            }
        }

        public String toString() {
            return Integer.toString(myValue);
        }

    }

    private boolean isEmpty() {
        return contents.size() <= 1;
    }

    public String toString() {
        String toReturn = "";
        for (Node c : contents) {
            if (c != null) {
                toReturn += c.toString() + " ";
            }
        }
        return toReturn.trim();
    }

    public static void main(String[] args) {
        kAryHeap heap = new kAryHeap(3);
        heap.insert(3);
        heap.insert(9);
        heap.insert(7);
        heap.insert(4);
        heap.insert(1);
        heap.insert(8);
        heap.insert(5);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.print();

        // Should print in decreasing order
        while (!heap.isEmpty()) {
            System.out.println(heap.removeMax().myValue);
        }
    }
}
