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
		
		bst.inorder(bst.root);
		
		
	}
	
}
