package com.StackUses;

public class EStack {
	private int top;
	private int maxsize;
	private int[] daray;
	private char[] charray;

	public EStack(int s){
		top = -1;
		maxsize = s;
		daray = new int[maxsize];
		charray = new char[maxsize];
	}

	public void push(int a){
		daray[++top] = a;
	}

	public void pushString(char r){

		char result; 

		switch(r){ 

		case '{':
			charray[++top] = '{'; 
			break;
		case '[':
			charray[++top] = '['; 
			break;
		case '(':
			charray[++top] = '('; 
			break;

		case ')':
			result = popChar(); 
			if (result != '('){
				System.out.println("missing }" );
				return; 
			}
			break;

		case ']':
			result = popChar(); 
			if (result != '['){
				System.out.println("missing ]" );
				return;
			}
			break;

		case '}':
			result = popChar(); 
			if (result != '{'){
				System.out.println("missing ]" );
				return;
			}

			break;



		}
		
	}

	public char popChar(){
		return charray[top--];
	}

	public int pop(){
		return daray[top--];
	}

	public boolean isEmpty(){
		return (top ==-1);
	}



}
