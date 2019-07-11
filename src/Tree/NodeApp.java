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
		System.out.println("\nsearch for the element 17: "+ found);	
		System.out.println("\n");

		System.out.println("levelWise printing:: ");

		td.printLevelWise();
		System.out.println("\n");

		System.out.println("now traversing PreOrder:: ");

		td.PreOrder(td.root);
		System.out.println("\n");
		
		System.out.println("now traversing Inorder:: ");

		td.InOrder(td.root);

		System.out.println("\n");				

		System.out.println("now traversing PostOrder:: ");

		td.PostOrder(td.root);

		int n1 = 11;
		int n2 = 9;
		
		Node t = td.lca(td.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.iData);
	}
}