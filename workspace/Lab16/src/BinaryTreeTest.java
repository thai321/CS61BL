import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class BinaryTreeTest {

	@Test
	public void testIterator(){
		BinaryTree<Integer> binTree = new BinaryTree<Integer>();
		binTree.add(4);
		binTree.add(2);
		binTree.add(6);
		binTree.add(1);
		binTree.add(3);
		binTree.add(5);
		binTree.add(7);
		
		Iterator<Integer> iter = binTree.iterator();
		int i = 1;
		while(iter.hasNext()) {
			int t = iter.next();
			assertEquals(t,i++);
		}
	}
	
	@Test
	public void testConstructor() {

		ArrayList<String> pre = new ArrayList<String>();
		pre.add("A");
		pre.add("B");
		pre.add("C");
		pre.add("D");
		pre.add("E");
		pre.add("F");

		ArrayList<String> in = new ArrayList<String>();
		in.add("B");
		in.add("A");
		in.add("E");
		in.add("D");
		in.add("F");
		in.add("C");
		
		System.out.println ("Two ArrayList constructor: ");
		BinaryTree myTree = new BinaryTree(pre, in);
		Iterator<String> iter = myTree.iterator();
		
		ArrayList<String> check = new ArrayList<String>();
		check.add("B");
		check.add("A");
		check.add("E");
		check.add("D");
		check.add("F");
		check.add("C");
		
		int i = 0;
		while(iter.hasNext()) {
			assertTrue(iter.next().equals(check.get(i++)));
		}
	}
}
