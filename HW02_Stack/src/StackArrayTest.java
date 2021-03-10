import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackArrayTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSize01() {
		StackArray s = new StackArray();
		assertEquals(0,s.size());
	}
	
	@Test
	void testSize02() throws Exception {
		StackArray s = new StackArray();
		s.push(1);
		s.push(2);
		assertEquals(2,s.size());
	}
	
	@Test
	void testSize03() throws Exception {
		StackArray s = new StackArray();
		s.push(1);
		s.push(2);
		s.pop();
		assertEquals(1,s.size());		
		s.push(3);
		assertEquals(2,s.size());
		s.pop();
		assertEquals(1,s.size());
		s.pop();
		assertEquals(0,s.size());
	}
	
	

}
