package com.LinkList.operations;

import java.util.HashSet;

import org.omg.CORBA.PUBLIC_MEMBER;

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
		if (first == null){
			return true;	
		}
		return false;
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
		Link n = first;
		while(n != null){
			if(set1.contains(n.data)){
				previous.next = n.next;
			}
			else{
				set1.add(n.data);
				previous = n;
				}
			n = n.next;
		} 
	}
	
}
