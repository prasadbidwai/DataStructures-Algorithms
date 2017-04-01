//package linkListQuestions;

import java.util.HashSet;

public class LinkList {
	public Link first; 
	
	public LinkList(){
		first=null;
	}
	
	public void addfirst(int da){
		Link newLink = new Link(da);
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first= first.next;
		return temp;	
	}
	
	public boolean isEmpty() {
	
		return(first == null);
	}
	
	public void displayList() {
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.print(" ");
	}

	public Link findLink(int key){

		Link current = first;

		while(current.idata != key){
			if(current.next == null)
				return null;

			else 
				current = current.next;
		}
		return current;
	}

	public Link deleteLink(int key){

		Link current = first;
		Link previous = first;
		
		while(current.idata != key){
			
			if (current.next == null)
			return null;

			else{

				previous = current;
				current = current.next;
			}
		}
		if(current == first)
			first = first.next;
		else	
			previous.next = current.next;
		return current;
	}	
	
	public void deleteDups(Link l1){
		HashSet<Integer> hs = new HashSet<Integer>();
		Link previous = null;
		while(l1!= null){
			if(hs.contains(l1.data))
			{
				previous.next = l1.next;
			}
			else{
				hs.add(l1.data);
				previous = l1;
			}
		l1 = l1.next;	
		}
	}
	
	public void reverseList()
	{
	  Link current = first;
	  Link reversedPart = null;
	  while(current!= null)
	  {
	    Link next = current.next;
	    current.next = reversedPart;
	    reversedPart = current; 
	    current = next;
	  }
	  first = reversedPart;
	}

	public Link reverseBetween(Link head, int m, int n) {
	    if(head == null) return null;
	    Link dummy = new Link(0); // create a dummy node to mark the head of this list
	    dummy.next = head;
	    Link pre = dummy; // make a pointer pre as a marker for the node before reversing
	    for(int i = 0; i<m-1; i++) pre = pre.next;
	    
	    Link start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
	    Link then = start.next; // a pointer to a node that will be reversed
	    
	    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
	    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
	    for(int i=0; i<n-m; i++)
	    {
	        start.next = then.next;
	        then.next = pre.next;
	        pre.next = then;
	        then = start.next;
	    }
	    
	    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
	    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
	    return dummy.next;
	}

	public ListNode swapPairs(ListNode head) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode current = dummy;
	    while (current.next != null && current.next.next != null) {
	        ListNode first = current.next;
	        ListNode second = current.next.next;
	        first.next = second.next;
	        current.next = second;
	        current.next.next = first;
	        current = current.next.next;
	    }
	    return dummy.next;
	}


}
