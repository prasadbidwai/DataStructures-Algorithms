package LinkListQuestions;

//package linkListQuestions;

//import java.util.HashSet;

public class LinkListApp {


	public static void main(String[] args)
	{
		LinkList l1 = new LinkList();

		l1.addfirst(3);
		l1.addfirst(10);
		l1.addfirst(4);
		l1.addfirst(20);
		l1.addfirst(50);
		l1.addfirst(90);

		System.out.println("Original Linked list:");
		l1.displayList();
		
		int start = 2;
		int last = 5;
		
		System.out.println("\n\nLinked list after reversal between index "+start+" and "+last+" :");
		
		l1.reverseBetween(l1.first, start, last);
//
//		System.out.println("\n\nDelete duplicates method is being called::");
//		l1.deleteDups(l1.first);

//		System.out.println("\nLinked list after all duplicates are deleted:");
		l1.displayList();
	}
}
