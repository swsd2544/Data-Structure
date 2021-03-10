
public interface MyStack {
	public boolean isEmpty(); 
	public boolean isFull();
	public void makeEmpty();
	
	//Return data on top of stack.
	//Throw exception if the stack is empty.
	public int top() throws Exception;
	
	//Remove data on top of stack.
	//Throw exception if the stack is empty. 
	public void pop() throws Exception;
	
	//Add new data on top of stack.
	//Throw exception if the operation is somehow 
	//unsuccessful.
	public void push(int data) throws Exception;
	
	//number of data currently stored in the stack
	public int size() throws Exception;
}
