public class LinkListApp{
	
	public static void main(String[] args)
	{
			LinkList ll = new LinkList();
			ll.addFirstLink(20);
			ll.addFirstLink(30);
			ll.addFirstLink(40);
			ll.addFirstLink(50);
			ll.addFirstLink(60);
			ll.addFirstLink(70);

			ll.printLinkList();

			Link result = ll.findLink(90);
			System.out.println("given number 90 exists "+(result!= null));

			Link result1 = ll.findLink(50);
			System.out.println("given number 50 exists "+(result1!= null));

//			ll.deleteFirst();
//			ll.deleteFirst();
//			ll.deleteFirst();

			ll.deleteLink(100);

			System.out.println("After Deletetion:\n");

			ll.printLinkList();
	}

}