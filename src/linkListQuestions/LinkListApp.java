package linkListQuestions;

import java.util.HashSet;

public class LinkListApp {


	
	public static void main(){
	LinkList l1 = new LinkList();

	l1.addfirst(2);
	System.out.println("added first");
	l1.addfirst(10);
	l1.addfirst(5);
	l1.addfirst(3);
	l1.addfirst(10);
	l1.addfirst(4);
	l1.addfirst(20);
	
	System.out.println("Saved link list: \n");
	l1.displayList();
	
//	l1.deleteDups(l1.first);
//	l1.displayList();
//	
}
}
