package com.Queue;

public class QueueApp {
	
	public static void main(String[] args){
		
		Queue q = new Queue(5);
		
		q.insert(2);
		q.insert(55);
		q.insert(66);
		q.insert(22);
		q.insert(10);
		
		while(!q.isEmpty()){
			System.out.println(" " + q.remove());
		}
	
		System.out.println(q.isEmpty());
	}
	
	
}
