package com.Queue;

public class Queue {
	
	private int rear;
	private int front;
	private int maxsize;
	private int[] Qarray;
	private int nSize = 0;
	
	public Queue(int s){
	
		rear = -1;
		front = 0;
		maxsize = s;
		Qarray = new int[maxsize];
		
	}
	
	public void insert(int key){
		
		if (rear == maxsize-1){
			rear = -1;
		}
		
		Qarray[++rear] = key;
		nSize ++;
	}
	
	public int remove(){
		
		int temp = Qarray[front++];
		
		if (front == maxsize){
			front = 0;
		}
		
		nSize --;
		return temp;
	}
	
	public boolean isEmpty(){
		
		if (nSize == 0)
		{
			return true;
		}
		return false;
	}
	
	public boolean isFull(){
		
		if (rear == nSize){
			return true;
		}
		return false;
		
	}
	
	
	
}
