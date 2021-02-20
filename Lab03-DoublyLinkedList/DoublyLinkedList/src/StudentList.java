
public class StudentList extends CDLinkedList {
    // you can write additional methods.

	// implement this method
	public void swapNode(DListIterator i1, DListIterator i2) {
		Object data = i1.currentNode.data;
		i1.currentNode.data = i2.currentNode.data;
		i2.currentNode.data = data;
	}
	
	// implement this method
	public void insertList(DListIterator i1, CDLinkedList lst) {
		if(i1 == null || i1.currentNode == null || lst.size == 0){
			return;
		}
		DListNode temp = i1.currentNode.nextNode;

		i1.currentNode.nextNode = lst.header.nextNode;
		lst.header.nextNode.previousNode = i1.currentNode;

		temp.previousNode = lst.header.previousNode;
		lst.header.previousNode.nextNode = temp;
	}

	// implement this method
	public void gender(String g) throws Exception {
		StudentList stu = new StudentList();
		DListIterator stuIterator = new DListIterator(stu.header);
		DListIterator iterator = new DListIterator(header);
		while(iterator.hasNext() && iterator.currentNode.nextNode != header){
			Student student = (Student) iterator.next();
			if(student.getSex().equals(g)){
				stu.insert(student,stuIterator);
				stuIterator.next();
				remove(student);
			}
		}
		insertList(new DListIterator(header), stu);
	}

}
