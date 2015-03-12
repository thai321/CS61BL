import junit.framework.TestCase;


public class IntSequenceTest extends TestCase {
	public void testConstructor() {
		IntSequence arr = new IntSequence(10);
		assertTrue(arr.size() == 0);
//		assertTrue(arr.toString().equals("0 0 0 0 0 0 0 0 0 0"));
		assertEquals(arr.toString(),"0 0 0 0 0 0 0 0 0 0");
		for(int n: arr.myValues)
			assertTrue(n == 0);
	}

	public void testToString() {
		IntSequence arr = new IntSequence(7);
		assertEquals(arr.toString(),"0 0 0 0 0 0 0");
		arr.add(1);
		assertEquals(arr.toString(),"1 0 0 0 0 0 0");
		arr.add(2);
		assertEquals(arr.toString(),"1 2 0 0 0 0 0");
		arr.add(3);
		assertEquals(arr.toString(),"1 2 3 0 0 0 0");
		arr.add(4);
		assertEquals(arr.toString(),"1 2 3 4 0 0 0");
		arr.add(5);
		assertEquals(arr.toString(),"1 2 3 4 5 0 0");
		arr.add(6);
		assertEquals(arr.toString(),"1 2 3 4 5 6 0");
		arr.add(7);
		assertEquals(arr.toString(),"1 2 3 4 5 6 7");

	}

	public void testIsEmpty() {
		IntSequence arr = new IntSequence(5);
		assertTrue(arr.isEmpty());
		arr.add(1);
		assertFalse(arr.isEmpty());
		arr.remove(0);
		assertTrue(arr.isEmpty());
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		assertFalse(arr.isEmpty());

		arr.remove(4);
		arr.remove(3);
		arr.remove(2);
		arr.remove(1);
		arr.remove(0);
		assertTrue(arr.isEmpty());

	}

	public void testElementAt(){
		IntSequence arr = new IntSequence(5);
		assertTrue(arr.isEmpty());
		arr.add(1);
		assertEquals(arr.elementAt(0), 1);
		assertFalse(arr.isEmpty());
		arr.add(2);
		assertEquals(arr.elementAt(1), 2);
		arr.add(3);
		assertEquals(arr.elementAt(2), 3);
		arr.add(4);
		assertEquals(arr.elementAt(3), 4);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString().substring(0,arr.size()*2-1),"1 2 3 4");

		arr.add(5);
		assertEquals(arr.elementAt(4), 5);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString(), "1 2 3 4 5");

		assertEquals(arr.elementAt(0), 1);
		assertEquals(arr.elementAt(1), 2);
		assertEquals(arr.elementAt(2), 3);
		assertEquals(arr.elementAt(3), 4);
		assertEquals(arr.elementAt(4), 5);
		assertTrue(arr.size() == 5);

	}

	public void testSize() {
		IntSequence arr = new IntSequence(10);
		assertTrue(arr.isEmpty());
		arr.add(1);
		assertEquals(arr.elementAt(0), 1);
		assertFalse(arr.isEmpty());
		arr.add(2);
		assertEquals(arr.elementAt(1), 2);
		arr.add(5);
		assertEquals(arr.elementAt(2), 5);
		arr.add(6);
		assertEquals(arr.elementAt(3), 6);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString().substring(0,arr.size()*2-1),"1 2 5 6");
		arr.add(7);
		assertEquals(arr.elementAt(4), 7);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString().substring(0,arr.size()*2-1),"1 2 5 6 7");

		assertEquals(arr.elementAt(0), 1);
		assertEquals(arr.elementAt(1), 2);
		assertEquals(arr.elementAt(2), 5);
		assertEquals(arr.elementAt(3), 6);
		assertEquals(arr.elementAt(4), 7);
		assertTrue(arr.size() == 5);

		arr.insert(3,2);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(3));
		assertFalse (arr.contains(4));

		arr.insert(4,3);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(3));
		assertFalse (arr.contains(8));

		assertEquals(arr.size() , 7);

		arr.insert(8,7);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(1));
		assertFalse (arr.contains(9));
		assertEquals(arr.size() , 8);

		arr.insert(9,8);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(8));
		assertFalse (arr.contains(10));
		assertEquals(arr.size() , 9);

		arr.insert(10,9);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(10));
		assertFalse (arr.contains(0));
		assertEquals(arr.size() , 10);

	}

	public void testAdd(){
		IntSequence arr = new IntSequence(5);
		assertTrue(arr.isEmpty());
		arr.add(1);
		assertFalse(arr.isEmpty());
		arr.add(2);
		arr.add(3);
		arr.add(4);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString().substring(0,arr.size()*2-1),"1 2 3 4");
		arr.add(5);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString(), "1 2 3 4 5");
		
	}

	public void testRemove() {
		IntSequence arr = new IntSequence(5);
		assertTrue(arr.isEmpty());
		arr.add(1);
		assertFalse(arr.isEmpty());
		arr.remove(0);
		assertTrue(arr.isEmpty());
		assertFalse(arr.contains(1));
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		
		arr.remove(4);
		assertFalse(arr.contains(5));
		arr.remove(3);
		assertFalse(arr.contains(4));
		arr.remove(2);
		assertFalse(arr.contains(3));
		arr.remove(1);
		assertFalse(arr.contains(2));
		arr.remove(0);
		assertFalse(arr.contains(1));
		assertTrue(arr.isEmpty());

	}

	public void testInsert(){
		IntSequence arr = new IntSequence(10);
		assertTrue(arr.isEmpty());
		arr.add(1);
		assertEquals(arr.elementAt(0), 1);
		assertFalse(arr.isEmpty());
		arr.add(2);
		assertEquals(arr.elementAt(1), 2);
		arr.add(5);
		assertEquals(arr.elementAt(2), 5);
		arr.add(6);
		assertEquals(arr.elementAt(3), 6);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString().substring(0,arr.size()*2-1),"1 2 5 6");
		arr.add(7);
		assertEquals(arr.elementAt(4), 7);
		assertFalse(arr.isEmpty());
		assertEquals(arr.toString().substring(0,arr.size()*2 -1 ),"1 2 5 6 7");

		assertEquals(arr.elementAt(0), 1);
		assertEquals(arr.elementAt(1), 2);
		assertEquals(arr.elementAt(2), 5);
		assertEquals(arr.elementAt(3), 6);
		assertEquals(arr.elementAt(4), 7);
		assertTrue(arr.size() == 5);

		arr.insert(3,2);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(3));
		assertFalse (arr.contains(4));
		assertEquals(arr.size(),6);

		arr.insert(4,3);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(3));
		assertFalse (arr.contains(8));
		assertEquals(arr.size(),7);

		arr.insert(8,7);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(1));
		assertFalse (arr.contains(9));
		assertEquals(arr.size(),8);

		arr.insert(9,8);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(8));
		assertFalse (arr.contains(10));
		assertEquals(arr.size(),9);

		arr.insert(10,9);
		assertFalse (arr.isEmpty());
		assertTrue (arr.contains(10));
		assertFalse (arr.contains(0));

	}
	public void testContains(){
		IntSequence arr = new IntSequence(10);
		arr.add(1);
		assertTrue(arr.contains(1));

		arr.add(3);
		assertTrue(arr.contains(3));
		arr.insert(2,1);
		assertTrue(arr.contains(2));
		arr.add(4);
		assertFalse(arr.contains(5));
		assertTrue(arr.contains(4));
		arr.add(5);
		assertTrue(arr.contains(5));
		arr.add(8);
		assertTrue(arr.contains(8));
		arr.insert(6,5);
		assertTrue(arr.contains(6));
		arr.insert(7,6);
		assertTrue(arr.contains(7));
		arr.add(9);
		assertTrue(arr.contains(9));
		arr.add(10);
		assertTrue(arr.contains(10));

		assertEquals(arr.toString(),"1 2 3 4 5 6 7 8 9 10");
		assertTrue(arr.contains(1));
		assertTrue(arr.contains(2));
		assertTrue(arr.contains(3));
		assertTrue(arr.contains(4));
		assertTrue(arr.contains(5));
		assertTrue(arr.contains(6));
		assertTrue(arr.contains(7));
		assertTrue(arr.contains(8));
		assertTrue(arr.contains(9));
		assertTrue(arr.contains(10));
		

	}	
}
