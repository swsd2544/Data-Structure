
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		if(q.isFull()){
			return;
		}
		if(q.isEmpty() || q.size() == 1){
			q.insertLast(x);
			return;
		}
		int min = (q.front() < x)?q.front():x, size = q.size() + 1;
		while(q.front() != min || q.size() != size){
			int temp = q.removeFirst();
			if (temp > x && q.size() + 1 < size) q.insertLast(x);
			q.insertLast(temp);
		}
	}

	// implement this.
	public void pop() throws Exception {
		q.removeFirst();
	}

	// implement this
	public int top() throws Exception {
		return q.front();
	}

}
