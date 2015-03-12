import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class AbstractListNodeTest {

	@Test
	public void test() {
		AbstractListNode list = new NonemptyListNode(3,new NonemptyListNode(2,new NonemptyListNode(1)));
		AbstractListNode newList = list.reverse();
		assertEquals("1 2 3", newList.toString());

	}
	
	@Test
	public void testMerge() {
		AbstractListNode list1 = new NonemptyListNode(1,new NonemptyListNode(3,new NonemptyListNode(5, new NonemptyListNode(7))));

		AbstractListNode list2 = new NonemptyListNode(2,new NonemptyListNode(4,new NonemptyListNode(6)));
		AbstractListNode list3 = list1.merge(list2, list1);

//		assertEquals("1 2 3 4 5 6 7" , list3.toString());
//		System.out.println(list1.toString());
////		System.out.println(list2.toString());
//		
//		AbstractListNode list4 = new NonemptyListNode(7,new NonemptyListNode(8,new NonemptyListNode(9)));
//		System.out.println(list1.toString());
//		list3 = list1.merge(list1, list4);
//		System.out.println("After");
//		System.out.println("List1 = " + list1.toString());
//		
//		System.out.println(list3.toString());
	}
	
	@Test
	public void testMergeAll(){
		ArrayList<AbstractListNode> thai = new ArrayList<AbstractListNode>();
		AbstractListNode list1 = new NonemptyListNode(1,new NonemptyListNode(3,new NonemptyListNode(5, new NonemptyListNode(7))));

		AbstractListNode list2 = new NonemptyListNode(2,new NonemptyListNode(4,new NonemptyListNode(6)));
		AbstractListNode list3 = new NonemptyListNode(20,new NonemptyListNode(22,new NonemptyListNode(99)));
		thai.add(list1);
		thai.add(list3);
		thai.add(list2);
		
		System.out.println(list1.toString());
		System.out.println(list3.toString());
		System.out.println(list2.toString());
		
		System.out.println("After");
		AbstractListNode list4 = list1.mergeAll(thai);
		System.out.println(list4.toString());
		System.out.println(list1.toString());
		
	}

}
