import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.*;

public class BinaryTree<T> implements Iterable<T> {

	protected TreeNode myRoot;

	public BinaryTree() {
		myRoot = null;
	
}
	public BinaryTree(TreeNode t) {
		myRoot = t;
	}

	public BinaryTree(ArrayList<T> pre, ArrayList<T> in) {
		myRoot = oneForAll(pre,in);
	}

	public TreeNode oneForAll(ArrayList<T> pre, ArrayList<T> in) {
		TreeNode root = null;
		ArrayList<T> preLeft = new ArrayList<T>();
		ArrayList<T> preRight = new ArrayList<T>();
		ArrayList<T> inLeft = new ArrayList<T>();
		ArrayList<T> inRight = new ArrayList<T>();

		int pre_index = 0;
		int in_index = 0;

		if((pre.size() != 0) && (in.size() != 0)) {
			root = new TreeNode(pre.get(0));

			in_index = in.indexOf(pre.get(0));
			inLeft = subList(in,0, in_index);
			inRight = subList(in,in_index + 1, in.size());

			pre_index = inLeft.size();
			preLeft = subList(pre,1, pre_index + 1);
			preRight = subList(pre,pre_index + 1, pre.size());

			root.myLeft = oneForAll(preLeft, inLeft);
			root.myRight = oneForAll(preRight, inRight);
		}
		return root;
	}
	
	public void add (T key) {
			myRoot = add(myRoot, key);
	}
	public TreeNode add(TreeNode t, T key) {
		if (t == null) {
			return new TreeNode(key);
		} else if (((Comparable) key).compareTo(t.myItem) < 0) {
			t.myLeft = add(t.myLeft, key);
		} else {
			t.myRight = add(t.myRight, key);
		}
		return t;
	} 

	public void printArrayList(ArrayList<T> temp) {
		System.out.print("[ ");
		for(T a: temp) {
			System.out.print(a + " ");
		}
		System.out.print(" ]");
		System.out.println();
	}

	public ArrayList<T> subList(ArrayList<T> list, int begin, int end) {
		ArrayList<T> result = new ArrayList<T>();
		for(int i = begin; i < end; i++) {
			result.add(list.get(i));
		}
		return result;
	}


	// Print the values in the tree in preorder: root value first,
	// then values in the left subtree (in preorder), then values
	// in the right subtree (in preorder).
	public void printPreorder() {
		if (myRoot == null) {
			System.out.println("(empty tree)");
		} else {
			myRoot.printPreorder();
			System.out.println();
		}
	}

	// Print the values in the tree in inorder: values in the left
	// subtree first (in inorder), then the root value, then values
	// in the right subtree (in inorder).
	public void printInorder() {
		if (myRoot == null) {
			System.out.println("(empty tree)");
		} else {
			myRoot.printInorder();
			System.out.println();
		}
	}

	public static BinaryTree<String> fillSampleTree1() {
		BinaryTree<String> t = new BinaryTree<String>();
		t.myRoot = t.new TreeNode("a", t.new TreeNode("b"), t.new TreeNode("c"));
		return t;
	}

	public static BinaryTree<String> fillSampleTree2() {
		BinaryTree<String> t = new BinaryTree<String>();
		t.myRoot = t.new TreeNode("a", t.new TreeNode("b", t.new TreeNode("d", t.new TreeNode("e"), t.new TreeNode("f")), null), t.new TreeNode("c"));
		return t;
	}

	public static void main(String[] args) {
		

//		ArrayList<String> pre = new ArrayList<String>();
//		pre.add("A");
//		pre.add("B");
//		pre.add("C");
//		pre.add("D");
//		pre.add("E");
//		pre.add("F");
//
//		ArrayList<String> in = new ArrayList<String>();
//		in.add("B");
//		in.add("A");
//		in.add("E");
//		in.add("D");
//		in.add("F");
//		in.add("C");
//		
//		System.out.println ("Two ArrayList constructor: ");
//		BinaryTree myTree = new BinaryTree(pre, in);
//		print(myTree,"myTree");
	}

	protected static void print(BinaryTree<?> t, String description) {
		System.out.println(description + " in preorder");
		t.printPreorder();
		System.out.println(description + " in inorder");
		t.printInorder();
		System.out.println();
	}

	// Method for the BinaryTree class
	public Iterator<T> iterator(){
		return new InorderIterator();
	}

	// Inner class inside of the BinaryTree class.
	// Also, it uses java.util.Iterator and java.util.Stack.
	private class InorderIterator implements Iterator<T> {
		private Stack<TreeNode> nodeStack;

		public InorderIterator() {
			if(myRoot != null) {
				nodeStack = new Stack<TreeNode>();
				stackLeft(myRoot);
			}
		}

		public boolean hasNext() {
			return !nodeStack.isEmpty();

		}

		public T next() {
			TreeNode nextNode = null;
			if(!hasNext()) {
				throw new NoSuchElementException("ran out of children");
			}

			if(!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				if(nextNode.myRight != null) {
					stackLeft(nextNode.myRight);
				}
			}

			return nextNode.myItem; 
		}
	
		public void stackLeft (TreeNode node) {
			if (node != null) {
				nodeStack.push(node);
				stackLeft (node.myLeft);
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	protected class TreeNode {

		public T myItem;
		public TreeNode myLeft;
		public TreeNode myRight;

		public TreeNode(T item) {
			myItem = item;
			myLeft = myRight = null;
		}

		public TreeNode(T item, TreeNode left, TreeNode right) {
			myItem = item;
			myLeft = left;
			myRight = right;
		}

		public void printPreorder() {
			System.out.print(myItem + " ");
			if (myLeft != null) {
				myLeft.printPreorder();
			}
			if (myRight != null) {
				myRight.printPreorder();
			}
		}

		public void printInorder() {
			if (myLeft != null) {
				myLeft.printInorder();
			}
			System.out.print(myItem + " ");
			if (myRight != null) {
				myRight.printInorder();
			}
		}
	}
}