import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntegerListTest {
	
	@Test
	void testRemoveOddValue01() throws Exception {
		IntegerList list = new IntegerList();
		list.removeOddValue();
		assertTrue(list.isEmpty());
		
	}
	
	@Test
	void testRemoveOddValue02() throws Exception {
		int[] x = {1,2,3,4};
		IntegerList list = new IntegerList(x);
		list.removeOddValue();  // result is {2,4}
		assertEquals(2, list.findKth(0));
		assertEquals(4, list.findKth(1));
		assertEquals(2, list.size());
	}
	
	@Test
	void testRemoveOddValue03() throws Exception {
		int[] a = {8,1,3,6,5,2};
		IntegerList list = new IntegerList(a);
		list.removeOddValue();  // result is {2,4}
		assertEquals(8, list.findKth(0));
		assertEquals(6, list.findKth(1));
		assertEquals(2, list.findKth(2));
		assertEquals(3, list.size());
	}
	
	@Test
	void testRemoveOddValue04() throws Exception {
		int[] b = {1};
		IntegerList list = new IntegerList(b);
		list.removeOddValue();  // result is {}
		assertTrue(list.isEmpty());
	}
	
	@Test
	void testRemoveOddValue05() throws Exception {
		int[] c = {2};
		IntegerList list = new IntegerList(c);
		list.removeOddValue();  // result is {2}
		assertEquals(2, list.findKth(0));
		assertEquals(1, list.size());
		
	}

	
	@Test
	void testRemoveRange01() throws Exception {
		int[] a = {1,2,3,4,5};
		IntegerList list = new IntegerList(a);
		DListIterator itr = new DListIterator(list.header);
		DListIterator itr2 = new DListIterator(list.header);
		itr.next();
		itr.next();
		
		itr2.next();
		itr2.next();
		itr2.next();
		itr2.next();
		list.removeRange(itr,itr2,3);
		assertEquals(1, list.findKth(0));
		assertEquals(5, list.findKth(1));
		assertEquals(2, list.size());	
	}
	

	@Test
	void testRemoveRange02() throws Exception {
		int[] a = {1,2,3,4};
		IntegerList list = new IntegerList(a);
		DListIterator itr = new DListIterator(list.header);
		DListIterator itr2 = new DListIterator(list.header);
		
		itr.next();
		itr.next();
		
		itr2.next();
		itr2.next();
		itr2.next();
		itr2.next();
		list.removeRange(itr,itr2,3);
		assertEquals(1, list.findKth(0));
		assertEquals(1, list.size());
	
	}
	
	@Test
	void testRemoveRange03() throws Exception {
		int[] a = {1,2,3,4};
		IntegerList list = new IntegerList(a);
		DListIterator itr = new DListIterator(list.header);
		DListIterator itr2 = new DListIterator(list.header);
		
		itr.next();
		
		itr2.next();
		itr2.next();
		itr2.next();
		list.removeRange(itr,itr2,3);
		assertEquals(4, list.findKth(0));
		assertEquals(1, list.size());
	}
	
	@Test
	void testRemoveRange04() throws Exception {
		int[] a = {1,2,3,4};
		IntegerList list = new IntegerList(a);
		DListIterator itr = new DListIterator(list.header);
		DListIterator itr2 = new DListIterator(list.header);
		
		itr.next();
		itr.next();
		itr.next();
		
		itr2.next();
		itr2.next();
		itr2.next();
		list.removeRange(itr,itr2,1);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(4, list.findKth(2));
		assertEquals(3, list.size());
	}
	
	@Test
	void testRemoveRange05() throws Exception {
		int[] a = {1,2,3};
		IntegerList list = new IntegerList(a);
		DListIterator itr = new DListIterator(list.header);
		DListIterator itr2 = new DListIterator(list.header);
		
		itr.next();
		
		itr2.next();
		itr2.next();
		itr2.next();
		list.removeRange(itr,itr2,3);
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	@Test
	void testEvenToFront01() throws Exception {
		IntegerList list = new IntegerList();
		list.evenToFront();
		assertTrue(list.isEmpty());
	}
	
	@Test
	void testEvenToFront02() throws Exception {
		int[] a = {1};
		IntegerList list = new IntegerList(a);
		list.evenToFront();
		assertEquals(1, list.size());
		assertEquals(1, list.findKth(0));
	}
	
	@Test
	void testEvenToFront03() throws Exception {
		int[] a = {2};
		IntegerList list = new IntegerList(a);
		list.evenToFront();
		assertEquals(1, list.size());
		assertEquals(2, list.findKth(0));
	}
	
	@Test
	void testEvenToFront04() throws Exception {
		int[] a = {2,1};
		IntegerList list = new IntegerList(a);
		list.evenToFront();
		assertEquals(2, list.size());
		assertEquals(2, list.findKth(0));
		assertEquals(1, list.findKth(1));
	}
	
	@Test
	void testEvenToFront05() throws Exception {
		int[] a = {2,9,6,8,1,3,4,7};
		IntegerList list = new IntegerList(a);
		list.evenToFront();
		assertEquals(8, list.size());
		assertEquals(2, list.findKth(0));
		assertEquals(6, list.findKth(1));
		assertEquals(8, list.findKth(2));
		assertEquals(4, list.findKth(3));
		assertEquals(9, list.findKth(4));
		assertEquals(1, list.findKth(5));
		assertEquals(3, list.findKth(6));
		assertEquals(7, list.findKth(7));
	}
	
	@Test
	void testEvenToFront06() throws Exception {
		int[] a = {1,6,3,10};
		IntegerList list = new IntegerList(a);
		list.evenToFront();
		assertEquals(4, list.size());
		assertEquals(6, list.findKth(0));
		assertEquals(10, list.findKth(1));
		assertEquals(1, list.findKth(2));
		assertEquals(3, list.findKth(3));
	}

	@Test
	void testSum01() throws Exception {
		IntegerList list = new IntegerList();
		assertEquals(0,list.sum());
	}
	
	@Test
	void testSum02() throws Exception {
		int[] a = {1,2,3};
		IntegerList list = new IntegerList(a);
		assertEquals(6,list.sum());
		
		int[] b = {17};
		IntegerList list2 = new IntegerList(b);
		assertEquals(17,list2.sum());
	}

	@Test
	void testAppendToBack01() throws Exception {
		int[] a = {1,2,3};
		IntegerList list = new IntegerList(a);
		IntegerList list2 = new IntegerList();
		
		list.appendToBack(list2);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(3, list.findKth(2));
		assertEquals(3, list.size());
	}
	
	@Test
	void testAppendToBack02() throws Exception {
		int[] a = {1,2,3};
		IntegerList list = new IntegerList();
		IntegerList list2 = new IntegerList(a);
		
		list.appendToBack(list2);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(3, list.findKth(2));
		assertEquals(3, list.size());
	}
	
	@Test
	void testAppendToBack03() throws Exception {
		int[] a = {1,2};
		int[] b = {4,5};
		IntegerList list = new IntegerList(a);
		IntegerList list2 = new IntegerList(b);
		
		list.appendToBack(list2);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(4, list.findKth(2));
		assertEquals(5, list.findKth(3));
		assertEquals(4, list.size());
	}
	
	

	@Test
	void testInsertList01() throws Exception {
		int[] a = {1,2};
		IntegerList list = new IntegerList(a);
		IntegerList list2 = new IntegerList();
		DListIterator itr = new DListIterator(list.header);
		list.insertList(itr,list2);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(2, list.size());
	}
	
	@Test
	void testInsertList02() throws Exception {
		int[] a = {1,2};
		IntegerList list = new IntegerList();
		IntegerList list2 = new IntegerList(a);
		DListIterator itr = new DListIterator(list.header);
		list.insertList(itr,list2);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(2, list.size());
	}
	
	@Test
	void testInsertList03() throws Exception {
		int[] a = {1,2};
		int[] b = {3,4};
		IntegerList list = new IntegerList(a);
		IntegerList list2 = new IntegerList(b);
		DListIterator itr = new DListIterator(list.header);
		list.insertList(itr,list2);
		assertEquals(3, list.findKth(0));
		assertEquals(4, list.findKth(1));
		assertEquals(1, list.findKth(2));
		assertEquals(2, list.findKth(3));
		assertEquals(4, list.size());
	}
	
	@Test
	void testInsertList04() throws Exception {
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		IntegerList list = new IntegerList(a);
		IntegerList list2 = new IntegerList(b);
		DListIterator itr = new DListIterator(list.header);
		itr.next();
		itr.next();
		
		list.insertList(itr,list2);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(4, list.findKth(2));
		assertEquals(5, list.findKth(3));
		assertEquals(6, list.findKth(4));
		assertEquals(3, list.findKth(5));
		assertEquals(6, list.size());
	}
	
	@Test
	void testInsertList05() throws Exception {
		int[] a = {1,2};
		int[] b = {3,4,5};
		IntegerList list = new IntegerList(a);
		IntegerList list2 = new IntegerList(b);
		DListIterator itr = new DListIterator(list.header);
		itr.next();
		itr.next();
		
		list.insertList(itr,list2);
		assertEquals(1, list.findKth(0));
		assertEquals(2, list.findKth(1));
		assertEquals(3, list.findKth(2));
		assertEquals(4, list.findKth(3));
		assertEquals(5, list.findKth(4));
		assertEquals(5, list.size());
	}
	

	
}
