import java.util.Iterator;

public class MyBasket {
	MyStack s;

	public MyBasket(MyStack s) {
		super();
		this.s = s;
	}

	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////

	public void removeKthFromTop(int k) throws Exception {
		if(k < 0 || k >= s.size()){
			return;
		}
		MyStack temp = new StackArray();
		for(int i = 0; i < k; i++){
			temp.push(s.top());
			s.pop();
		}
		s.pop();
		for(int i = 0; i < k; i++){
			s.push(temp.top());
			temp.pop();
		}
	}

	public void insertKthFromTop(int data, int k) throws Exception {
		if(k < 0 || k > s.size()){
			return;
		}
		MyStack temp = new StackArray();
		for(int i = 0; i < k; i++){
			temp.push(s.top());
			s.pop();
		}
		s.push(data);
		for(int i = 0; i < k; i++){
			s.push(temp.top());
			temp.pop();
		}
	}

}
