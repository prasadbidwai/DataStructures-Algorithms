package linkListQuestions;

import java.util.HashSet;

public class LinkList {
	public Link first; 
	
	public LinkList(){
		first=null;
	}
	
	public void addfirst(int da){
		Link newLink = new Link(da);
		newLink.next = null;
		first = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first= first.next;
		return temp;	
	}
	
	public boolean isEmpty() {
		if (first == null){
			return true;	
		}
		return false;
	}
	
	public void displayList() {
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
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
}
