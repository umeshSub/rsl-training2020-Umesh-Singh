class DoublyLinkedList{
	class Node{
		int item;
		Node prev;
		Node next;
	public Node(int item){
		this.item = item;
	}
}
	Node head, tail = null;
	public void addElement(int item){
		Node newNode = new Node(item);
		if(head == null){
			head = tail = newNode;
			head.prev = null;
			tail.next = null;
		}
		else{
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = null;
		}
	}
	public void delElement(Node del){
		//Base Case
		if(head == null || del == null){
			return;
		}
		// If node to be deleted is first node
		if(head == del){
			head = del.next;
		}
		if(del.next != null){
			del.next.prev = del.prev;
		}
		if(del.prev != null){
			del.prev.next = del.next;
		}
		return;
	}
	public void findElement(int value){
		int i = 1;
		boolean flag = false;
		Node current = head;
		if(head == null){
			System.out.println("List is Empty");
			return;
		}
		while(current != null){
			if(current.item == value){
				flag = true;
				break;
			}
			current = current.next;
			i++;
		}
		if(flag){
			System.out.println("Node is present in the list at the position: "+i);
		}else{
			System.out.println("No match is found");
		}
	}
	public static void main(String[] args){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addElement(2);
		dll.addElement(3);
		dll.addElement(5);
		dll.addElement(4);
		dll.addElement(6);
		dll.delElement(dll.head);
		dll.findElement(4);
		dll.findElement	(2);
	}

}