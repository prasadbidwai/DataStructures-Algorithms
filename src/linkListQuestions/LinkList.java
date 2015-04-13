package linkListQuestions;

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
	
}
