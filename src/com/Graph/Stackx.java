package com.Graph;

public class Stackx {

	private int top = -1;
	private int maxsize=20;
	int[] aray;

	public Stackx(){
		
		//maxsize = size;
		aray = new int[maxsize];
	}
	
	public void push(int key)	{
		aray[++top] = key;
	}
	
	public int pop(){
		return aray[top--];
	}
	
	public int peek(){
		return aray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
}
