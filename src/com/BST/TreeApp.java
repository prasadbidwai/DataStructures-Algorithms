package com.BST;

public class TreeApp {

	public static void main(String args[]){
		
		BST bst = new BST();
		
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(12);
		bst.insert(37);
		bst.insert(43);
		bst.insert(30);
		bst.insert(33);
		bst.insert(87);
		bst.insert(93);
		bst.insert(97);
		
//		System.out.println("root:: "+bst.root.data);
		
		System.out.println(bst.depth());
		System.out.println("\nPriniting In-Order:: ");
		bst.inorder(bst.root);
		
		Node min = bst.getmin();
		System.out.println("\n\nSmallest Element: "+min.data);
		
		Node max = bst.getMax();
		System.out.println("Largest Element: "+max.data);
		
		System.out.println("\nPriniting level-wise:: ");
		bst.printlevelwise(bst.root);
		
		
	}
	
}
