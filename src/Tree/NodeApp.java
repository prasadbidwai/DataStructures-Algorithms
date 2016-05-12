class NodeApp{

	

	public static void main(String[] args) 
	{
		TreeDS td = new TreeDS();
		td.insertElement(10);
		td.insertElement(8);
		td.insertElement(12);
		td.insertElement(7);
		td.insertElement(9);
		td.insertElement(11);
		td.insertElement(13);

		Node found = td.findElement(17);
		System.out.println(found);	
		System.out.println("\n\n");

		System.out.println("levelWise printing:: \n");

		td.printLevelWise();

		System.out.println("now traversing PreOrder:: \n");

		td.PreOrder(td.root);
		
		System.out.println("now traversing Inorder:: \n");

		td.InOrder(td.root);		

		System.out.println("now traversing PostOrder:: \n");

		td.PostOrder(td.root);
	}
}