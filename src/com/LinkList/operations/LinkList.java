package com.LinkList.operations;

import java.util.HashSet;

public class LinkList {
	public Link first; 
	
	public LinkList(){
		first=null;
	}
	
	public void addfirst(int da){
		Link newLink = new Link(da);
		newLink.next = first;
		first = newLink;
	}
	
	public Link deleteFirst(){
		Link temp = first;
		first= first.next;
		return temp;	
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void displayList() {
		Link current = first;
		
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println(" ");
	}
	
	public void deleteDups(){
		HashSet<Integer> set1 = new HashSet<Integer>();

		Link previous = null;
		Link current = first;
		while(current != null){
			if(set1.contains(current.data)){
				previous.next = current.next;
			}
			else{
				set1.add(current.data);
				previous = current;
				}
			current = current.next;
		} 
	}
	
}
