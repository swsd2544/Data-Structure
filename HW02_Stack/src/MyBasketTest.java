import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBasketTest {
	MyStack sArray = new StackArray();
	MyStack sList = new StackLinkedList();

	MyBasket b1 = new MyBasket(sArray);
	MyBasket b2 = new MyBasket(sList);

	@BeforeEach
	void setUp() throws Exception {
		sArray = new StackArray();
		sList = new StackLinkedList();

		b1 = new MyBasket(sArray);
		b2 = new MyBasket(sList);
	}

	@Test
	void testRemoveKthFromTop_EmptyStack() throws Exception {
		b1.removeKthFromTop(0);
		assertEquals(0, b1.s.size());

		b2.removeKthFromTop(0);
		assertEquals(0, b2.s.size());
	}

	@Test
	void testRemoveKthFromTop_KIllegal() throws Exception {
		b1.s.push(1);
		b1.s.push(0);
		b2.s.push(1);
		b2.s.push(0);

		b1.removeKthFromTop(-1);
		assertEquals(2, b1.s.size());
		assertEquals(0, b1.s.top());

		b2.removeKthFromTop(-1);
		assertEquals(2, b2.s.size());
		assertEquals(0, b2.s.top());

		b1.removeKthFromTop(2);
		assertEquals(2, b1.s.size());
		assertEquals(0, b1.s.top());

		b2.removeKthFromTop(2);
		assertEquals(2, b2.s.size());
		assertEquals(0, b2.s.top());

	}

	@Test
	void testRemoveKthFromTop_RemoveTop() throws Exception {
		b1.s.push(10);
		b1.s.push(20);
		b1.s.push(30);
		b1.s.push(40);
		b1.s.push(50);

		b2.s.push(10);
		b2.s.push(20);
		b2.s.push(30);
		b2.s.push(40);
		b2.s.push(50);

		b1.removeKthFromTop(0);
		assertEquals(4, b1.s.size());
		assertEquals(40, b1.s.top());

		b2.removeKthFromTop(0);
		assertEquals(4, b2.s.size());
		assertEquals(40, b2.s.top());

	}
	
	@Test
	void testRemoveKthFromTop_RemoveBottom() throws Exception {
		b1.s.push(10);
		b1.s.push(20);
		b1.s.push(30);
		b1.s.push(40);
		b1.s.push(50);

		b2.s.push(10);
		b2.s.push(20);
		b2.s.push(30);
		b2.s.push(40);
		b2.s.push(50);

		b1.removeKthFromTop(4);
		assertEquals(4, b1.s.size());
		assertEquals(50, b1.s.top());
		b1.s.pop();
		assertEquals(40, b1.s.top());
		b1.s.pop();
		assertEquals(30, b1.s.top());
		b1.s.pop();
		assertEquals(20, b1.s.top());
		
		b2.removeKthFromTop(4);
		assertEquals(4, b2.s.size());
		assertEquals(50, b2.s.top());
		b2.s.pop();
		assertEquals(40, b2.s.top());
		b2.s.pop();
		assertEquals(30, b2.s.top());
		b2.s.pop();
		assertEquals(20, b2.s.top());
	}
	
	@Test
	void testRemoveKthFromTop_RemoveMiddle() throws Exception {
		b1.s.push(10);
		b1.s.push(20);
		b1.s.push(30);
		b1.s.push(40);
		b1.s.push(50);

		b2.s.push(10);
		b2.s.push(20);
		b2.s.push(30);
		b2.s.push(40);
		b2.s.push(50);

		b1.removeKthFromTop(2);
		assertEquals(4, b1.s.size());
		assertEquals(50, b1.s.top());
		b1.s.pop();
		assertEquals(40, b1.s.top());
		b1.s.pop();
		assertEquals(20, b1.s.top());
		b1.s.pop();
		assertEquals(10, b1.s.top());
		
		b2.removeKthFromTop(2);
		assertEquals(4, b2.s.size());
		assertEquals(50, b2.s.top());
		b2.s.pop();
		assertEquals(40, b2.s.top());
		b2.s.pop();
		assertEquals(20, b2.s.top());
		b2.s.pop();
		assertEquals(10, b2.s.top());
	}

	@Test
	void testInsertKthFromTopFirstData() throws Exception {
		b1.insertKthFromTop(55, 0);
		assertEquals(1, b1.s.size());
		assertEquals(55, b1.s.top());
		
		b2.insertKthFromTop(35, 0);
		assertEquals(1, b2.s.size());
		assertEquals(35, b2.s.top());
	}
	
	@Test
	void testInsertKthFromTopIllegalPosition() throws Exception {
		// negative position on empty stack
		b1.insertKthFromTop(55, -1);
		assertEquals(0, b1.s.size());
		b2.insertKthFromTop(35, -1);
		assertEquals(0, b2.s.size());
		
		//position too large on and empty stack
		b1.insertKthFromTop(55, 1);
		assertEquals(0, b1.s.size());
		b2.insertKthFromTop(35, 1);
		assertEquals(0, b2.s.size());
		
		//negative position on non empty stack
		b1.s.push(10);
		b1.s.push(20);
		b1.s.push(30);
		
		b2.s.push(10);
		b2.s.push(20);
		b2.s.push(30);
		
		b1.insertKthFromTop(55, -1);
		assertEquals(3, b1.s.size());
		assertEquals(30, b1.s.top());
		
		b2.insertKthFromTop(55, -1);
		assertEquals(3, b2.s.size());
		assertEquals(30, b2.s.top());
		
		//too large position on non empty stack
		b1.insertKthFromTop(55, 4);
		assertEquals(3, b1.s.size());
		assertEquals(30, b1.s.top());
		
		b2.insertKthFromTop(55, 4);
		assertEquals(3, b2.s.size());
		assertEquals(30, b2.s.top());
		
	}
	
	@Test
	void testInsertKthFromTopNewFirstData() throws Exception {
		b1.s.push(10);
		b1.s.push(20);
		b1.s.push(30);
		
		b2.s.push(10);
		b2.s.push(20);
		b2.s.push(30);
		
		b1.insertKthFromTop(55, 0);
		assertEquals(4, b1.s.size());
		assertEquals(55, b1.s.top());
		b1.s.pop();
		assertEquals(30, b1.s.top());
		b1.s.pop();
		assertEquals(20, b1.s.top());
		b1.s.pop();
		assertEquals(10, b1.s.top());
		
		b2.insertKthFromTop(35, 0);
		assertEquals(4, b2.s.size());
		assertEquals(35, b2.s.top());
		b2.s.pop();
		assertEquals(30, b2.s.top());
		b2.s.pop();
		assertEquals(20, b2.s.top());
		b2.s.pop();
		assertEquals(10, b2.s.top());
	}
	
	@Test
	void testInsertKthFromTopNewLastData() throws Exception {
		b1.s.push(10);
		b1.s.push(20);
		b1.s.push(30);
		
		b2.s.push(10);
		b2.s.push(20);
		b2.s.push(30);
		
		b1.insertKthFromTop(55, 3);
		assertEquals(4, b1.s.size());
		assertEquals(30, b1.s.top());
		b1.s.pop();
		assertEquals(20, b1.s.top());
		b1.s.pop();
		assertEquals(10, b1.s.top());
		b1.s.pop();
		assertEquals(55, b1.s.top());
		
		b2.insertKthFromTop(35, 3);
		assertEquals(4, b2.s.size());
		assertEquals(30, b2.s.top());
		b2.s.pop();
		assertEquals(20, b2.s.top());
		b2.s.pop();
		assertEquals(10, b2.s.top());
		b2.s.pop();
		assertEquals(35, b2.s.top());
		
	}
	
	@Test
	void testInsertKthFromTopNewMiddleData() throws Exception {
		b1.s.push(10);
		b1.s.push(20);
		b1.s.push(30);
		
		b2.s.push(10);
		b2.s.push(20);
		b2.s.push(30);
		
		b1.insertKthFromTop(55, 1);
		assertEquals(4, b1.s.size());
		assertEquals(30, b1.s.top());
		b1.s.pop();
		assertEquals(55, b1.s.top());
		b1.s.pop();
		assertEquals(20, b1.s.top());
		b1.s.pop();
		assertEquals(10, b1.s.top());
		
		b2.insertKthFromTop(35, 1);
		assertEquals(4, b2.s.size());
		assertEquals(30, b2.s.top());
		b2.s.pop();
		assertEquals(35, b2.s.top());
		b2.s.pop();
		assertEquals(20, b2.s.top());
		b2.s.pop();
		assertEquals(10, b2.s.top());
	}

}
