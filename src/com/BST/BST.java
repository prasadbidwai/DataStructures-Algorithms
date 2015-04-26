package com.BST;

public class BST {
	public Node root;
	
	public BST(){
		root = null;
	}
	
	public void insert(int dat){
	
		Node newnode = new Node();
		newnode.data = dat;
		
		if (root == null){
			root = newnode;
		}
		
		else
		{
			Node current = root; 
			Node parent;
			
			while(true){
				parent = current;
				
				if(dat < current.data){
					current = current.leftChild;
					
					if(current == null){
						parent.leftChild = newnode;
						return;
					}
				}
				
				if(dat > current.data){
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
			System.out.println(local.data);
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
	

}
