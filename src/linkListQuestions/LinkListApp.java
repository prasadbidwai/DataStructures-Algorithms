package linkListQuestions;




public class LinkListApp {

	public static void main(){
	LinkList l1 = new LinkList();

	l1.addfirst(1);
	l1.addfirst(2);
	l1.addfirst(5);
	l1.addfirst(3);
	l1.addfirst(10);
	l1.addfirst(4);
	
	System.out.println("Saved link list: \n");
	l1.displayList();
	
}
}
