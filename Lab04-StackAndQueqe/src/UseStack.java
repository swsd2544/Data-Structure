
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {
		if(s.isEmpty()){
			return s;
		}
		Stack temp = new ArrayListStack();
		while(!s.isEmpty()){
			if(temp.isEmpty()){
				temp.push(s.top());
				s.pop();
			} else {
				Stack temp2 = new ArrayListStack();
				while(!s.isEmpty() && !temp.isEmpty() && s.top() > temp.top()){
					temp2.push(temp.top());
					temp.pop();
				}
				temp.push(s.top());
				s.pop();
				while(!temp2.isEmpty()){
					temp.push(temp2.top());
					temp2.pop();
				}
			}
		}
		return temp;
	}

}
