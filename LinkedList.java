public class LinkedList{

	Node head;
	static class Node {
		
		int data;
		Node next;
		Node(int d){
			data = d;
		}
	}


	public static LinkedList insert(LinkedList list, int data){
		Node newNode = new Node(data);
		newNode.next = null;
		if(list.head == null){
			list.head = newNode;
		} else {
			Node last = list.head;
			while(last.next != null){
				last = last.next;
			}
			
			last.next =  newNode;
		}
		
		return list;
	}


	public static void print(LinkedList list ){

		Node current = list.head;
		while(current.next != null){
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.print(current.data + " ");
	}


	public static void main(String r[]){
	
		System.out.println("Linked List main method");

		LinkedList list = new LinkedList();
		LinkedList.insert(list, 1);
		LinkedList.insert(list, 2);
		LinkedList.insert(list, 3);
		LinkedList.insert(list, 4);
		LinkedList.insert(list, 5);
		LinkedList.insert(list, 6);
		LinkedList.insert(list, 7);
		LinkedList.print(list);

	}

}


