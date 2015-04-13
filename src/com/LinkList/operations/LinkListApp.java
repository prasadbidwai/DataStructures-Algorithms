package com.LinkList.operations;

public class LinkListApp {
	
	public void deleteDuplicate(Link l1){
		
		
		
	}

	public static void main(String[] args){
	LinkList l1 = new LinkList();

	l1.addfirst(1);
	l1.addfirst(2);
	l1.addfirst(5);
	l1.addfirst(3);
	l1.addfirst(1);
	l1.addfirst(10);
	l1.addfirst(4);
	
	System.out.println("Saved link list: ");
	
	//l1.displayList();
	l1.deleteDups();
	l1.displayList();
}
}
