
public class IntegerList extends CDLinkedList {

	public IntegerList() {
		super();
		
	}

	public IntegerList(int[] a) throws Exception {
		super(a);
		
	}

	/////////////////////////////////////////////////////////
	public void removeOddValue() throws Exception {// remove all odd numbers
		DListIterator iterator = new DListIterator(header);
		while(iterator.hasNext() && iterator.currentNode.nextNode != header){
			int data = (int) iterator.next();
			if(data%2 == 1){
				removeAt(iterator);
			}
		}
	}

	public void removeRange(DListIterator itr1, DListIterator itr2, int rangeSize) throws Exception {
		if(rangeSize == 1){
			removeAt(itr1);
			return;
		}
		itr1.currentNode.previousNode.nextNode = itr2.currentNode.nextNode;
		itr2.currentNode.nextNode.previousNode = itr1.currentNode.previousNode;
		size -= rangeSize;
	}

	public void evenToFront() throws Exception { // move even data to the front (must preserve order)
		IntegerList iList = new IntegerList();
		DListIterator iterator = new DListIterator(header);
		DListIterator iListIterator = new DListIterator(iList.header);
		while(iterator.hasNext() && iterator.currentNode.nextNode != header){
			int data = (int) iterator.next();
			if(data%2 == 1){
				iList.insert(data, iListIterator);
				iListIterator.next();
				removeAt(iterator);
			}
		}
		insertList(new DListIterator(header.previousNode), iList);
	}

	public int sum() throws Exception {// add the value of all data
		if(size == 0){
			return 0;
		}
		int sum = 0;
		DListIterator iterator = new DListIterator(header);
		while(iterator.hasNext() && iterator.currentNode.nextNode != header){
			sum += (int) iterator.next();
		}
		return sum;
	}

	public void appendToBack(IntegerList l) throws Exception { // append list l to the back of this list
		// must be done in constant time. l will not be used again in the future.
		insertList(new DListIterator(header.previousNode), l);
	}

	public void insertList(DListIterator itr, IntegerList l) throws Exception {
		if(l.size == 0){
			return;
		}
		else if(l.size == 1){
			printList();
			if(itr.currentNode == header){
				insert(l.header.nextNode.data, new DListIterator(header));
				return;
			} else {
				l.header.nextNode.nextNode = itr.currentNode.nextNode;
				itr.currentNode.nextNode.previousNode = l.header.nextNode;
				itr.currentNode.nextNode = l.header.nextNode;
				l.header.nextNode.previousNode = itr.currentNode;
			}
		}
		else {
			l.header.previousNode.nextNode = itr.currentNode.nextNode;
			itr.currentNode.nextNode.previousNode = l.header.previousNode;
			itr.currentNode.nextNode = l.header.nextNode;
			l.header.nextNode.previousNode = itr.currentNode;
		}
		size += l.size;
	}



}
