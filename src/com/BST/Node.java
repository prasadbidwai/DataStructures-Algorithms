package com.BST;

public class Node {
	
	public int data;
	Node leftChild;
	Node rightChild;
	
	public Node(int key) {
		data = key;
	}
	
	public void displayNode(){
		System.out.println(""+data);
		
	}
	
}
