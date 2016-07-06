//package linkListQuestions;

//import java.util.HashSet;

public class LinkListApp {

	
	public static void main(String[] args)
	{
		LinkList l1 = new LinkList();

		l1.addfirst(2);
		//System.out.println("added first");
		l1.addfirst(10);
		l1.addfirst(5);
		l1.addfirst(3);
		l1.addfirst(10);
		l1.addfirst(4);
		l1.addfirst(20);
		l1.addfirst(20);
		l1.addfirst(10);
		
		System.out.println("Original Linked list with all duplicates:");
		l1.displayList();
		
		
		System.out.println("\n\nDelete duplicates method is being called::");
		l1.deleteDups(l1.first);

		System.out.println("\nLinked list after all duplicates are deleted:");
		l1.displayList();	
	}
}
