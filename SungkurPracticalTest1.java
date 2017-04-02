/* Date       : 23/09/2016
 * Name       : S.Sungkur
 * Student ID : 151233
 * Cohort	  : BSE15BFT
 * Purpose    : This Java Program is used add before a node,delete any node and search for any node in the list.
*/
class Node{
	Node previous; // create a temporary Node previous assigning value null to it
	int data; // data part
	Node next; // pointer to next newNode
	public Node(int data){
		this.data = data;
	}
	public void printElement(){
		System.out.println(this.data);
	}
}


class LinkedList{
	private Node LList;
	public LinkedList(){
		LList = null;
	}
	public int length(Node LList){
		if(LList == null){
			return 0;
		}
		//create a count variable to hold length
		int count = 0;
		//loop each element and increament the count till list reach to end.
		Node current = LList;
		while(current != null){
			count++;
			//move to next node
			current = current.next;
		}
		return count;
	}
	//part (ii)
	public Node DeleteAnyNode(Node LList, int position){
		//check boundary position by calling the previous methods
		int size = length(LList);
		if  (position > size || position < 1){ //perform check if position is in range of size or not
			System.out.println("Position not valid"); // if not in range
			return LList;
		}
		if(position == 1){
			Node temp = LList;//create temp - a Node variable pointing to LList
			LList =LList.next; //making second node as LList node by assigning LList to next node
			temp.next= null;
			return temp;
		}
		//in order to delete node which is not in position=1
		else{
			Node previous = LList; //point to head node
			int count = 1; //variable count track results of previous node

			while(count < position - 1){
				previous = previous.next;
				count++;
			}
			//deletingnodes at specified pposition
			Node current = previous.next; //current hode next node to previous
			previous.next = current.next;
			current.next = null;
			return current;
		}

	}



//================================================================//
	//part (i)
	public Node AddBefore(Node LList, int data, int position){
		// checks boundary
		int size = length(LList);
		if  (position > size + 1 || position < 1){ //perform check if position is in range of size or not
			System.out.println("Position not valid"); // if not in range
			return LList;
		}
		Node newNode = new Node(data);
		if(position == 1 ){ // check if position is one that is is we have to insert new node at the beginning
			newNode.next = LList; //update next pointer to point to LList
			return newNode; //return new LList of list
		}
		else{ // in another position except 1
			Node previous = LList;  //previous point to LList node
			int count = 1; //variable count track results of previous node

			while(count < position - 1){
				previous = previous.next;
				count++;
			}

			Node current = previous.next; //current hlode next node to previous
			newNode.next = current; //newNode point to current
			previous.next = newNode;
			return LList;
		}
	}




	public void printList(){
		Node temp = LList;
		while (temp != null){
			temp.printElement();
			temp = temp.next;
		}
	}
}

class SungkurPracticalTest1{
	public static void main(String arg[]){
		//LList start by "4"
		// 4 -> 5 -> 7 -> 8 ->null
		Node LList = new Node(4);
		Node second = new Node(5);
		Node third = new Node(7);
		Node fourth = new Node(8);

		//Attach them together to form a list
		LList.next = second; // 4 -> 5
		second.next = third; // 4 -> 5 -> 7
		third.next = fourth; // 4 -> 5 -> 7 -> 8 ->null

		LinkedList L = new LinkedList();
		L.printList();
		System.out.println();

		Node thirdNode = L.DeleteAnyNode(LList, 3);
		System.out.println(thirdNode.data);

		LList = L.AddBefore(LList, 15, 3); //(head, data, position)
		L.printList();

	}
}