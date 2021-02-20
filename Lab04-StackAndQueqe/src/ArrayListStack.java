import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;
	private int currentSize;
	private final int maximumCapacity = 10000;

	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		a = new ArrayList<Integer>();
		currentSize = 0;
	}

	public ArrayList<Integer> getA() {
		return a;
	}

	@Override
	public boolean isEmpty() {
		return a.isEmpty();
	}

	@Override
	public boolean isFull() {
		return (currentSize == maximumCapacity);
	}

	@Override
	public void makeEmpty() {
		a.clear();
		currentSize = 0;
	}

	@Override
	public int top() throws Exception {
		if(isEmpty()){
			throw new Exception();
		}
		return a.get(currentSize - 1);
	}

	@Override
	public void pop() throws Exception {
		if(isEmpty()){
			throw new Exception();
		}
		a.remove(currentSize - 1);
		currentSize--;
	}

	@Override
	public void push(int data) throws Exception {
		if(!isFull()){
			a.add(data);
			currentSize++;
		}
	}

}
