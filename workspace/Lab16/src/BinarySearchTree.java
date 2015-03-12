public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	// private TreeNode myRoot;
	
	public BinarySearchTree ( ) {
		super();
		// myRoot = myRoot;
	}
		
	public BinarySearchTree (TreeNode myRoot) {
		super(myRoot);
	}
		
	public boolean contains (T key) {
		TreeNode t = myRoot;
		while (t != null) {
			if (key.compareTo(t.myItem) == 0) {
				return true;
			} else if (key.compareTo(t.myItem) < 0) {
				t = t.myLeft;
			} else {
				t = t.myRight;
			}
		}
		return false;
	}
		
	public void add (T key) {
		TreeNode t = myRoot;
		if (t == null) {
			t = new TreeNode(key);
			myRoot = t;
		} else if (!contains(key)) {
			while (t != null) {
				if (key.compareTo(t.myItem) < 0) {
					if (t.myLeft == null) {
						t.myLeft = new TreeNode(key);
						break;
					}
					t = t.myLeft;
				} else {
					if (t.myRight == null) {
						t.myRight = new TreeNode(key);
						break;
					}
					t = t.myRight;
				}
			
			}
		}
	}
	
	public void print ( ) {
		myRoot.printPreorder();
		myRoot.printInorder();
	}
				
	public static void main (String[] args) {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.add(4);
		t.add(2);
		t.add(6);
		t.add(1);
		t.add(7);
		// System.out.println (t.contains("B"));
		//t.print();
		t.print(t, "idk");
	}
} 
			