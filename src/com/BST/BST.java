package com.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	public Node root;
	
	public BST(){
		root = null;
	}
	
	public void insert(int dat){
	
		Node newnode = new Node(dat);
//		newnode.data = dat;
		
		if (root == null){
			root = newnode;
		}
		
		else
		{
			Node current = root; 
			Node parent;
			
			while(true){
				parent = current;
				
				if(dat < current.data)
				{
					current = current.leftChild;					
					if(current == null){
						parent.leftChild = newnode;
						return;
					}
				}
				
				else if(dat > current.data)
				{
					current = current.rightChild;	
					if (current == null){
						parent.rightChild = newnode;
						return;
					}
				}								
				
			}
		}
	}
	
	public Node find (int key){
		Node current = root; 
		
		while(current.data != key){
			
			if(key < current.data){
				current = current.leftChild;
			}
			
			if(key > current.data){
				current = current.rightChild;
			}
			
			if(current == null){
				return null;
			}
		}
		return current;
	}
	
	public void inorder(Node local){
		
		//Node local = root;
		
		if(local != null){
			inorder(local.leftChild);
			System.out.print(local.data+" ");
			inorder(local.rightChild);
		}
	}
	
	public Node getmin(){
	
		Node current, last = null;
		current = root;
				
		while(current!= null){
			last = current;
			current = current.leftChild;				
		}		
		return last;
	}
	
	public Node getMax(){
		
		Node current,last = null;
		current = root;
		
		while( current!= null){
			last = current;
			current = current.rightChild;
		}
		return last;		
	}
	
	public void printlevelwise(Node local) {
		
		Queue<Node> qn = new LinkedList<Node>();
		qn.add(local);
		
		
		while(!qn.isEmpty()) {
			Node tempNode = (Node) qn.remove();
			System.out.print(tempNode.data+" ");	
			if (tempNode.leftChild != null)
			qn.add(tempNode.leftChild);
			if (tempNode.rightChild != null)
			qn.add(tempNode.rightChild);			
		}
		
	}
	
	public int depth() {
		int depth = 1, depth1 = 1;
		Node tempNode = root;
		Node tempNode1 = root;
		
		while(tempNode != null) {
			
			tempNode = tempNode.leftChild;
			depth++;
		}
		
		while(tempNode1 != null) {
			
			tempNode1 = tempNode1.rightChild;
			depth1++;
		}
		
		return depth>depth1? depth:depth1;
	}
	

}
