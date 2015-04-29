package com.StackUses;

public class StackApp {

	public static void main(String args[]){
		EStack es = new EStack(5);
		
		es.push(10);
		es.push(11);
		es.push(15);
		es.push(20);
		es.push(5);
		
		System.out.println("Conternt of the Stack:");
		
		while(!es.isEmpty()){
			int val = es.pop();
			System.out.println(val);
		}
		
		String test = "{([({})])}";
		
		for(int i=0; i <test.length(); i++){
			char c = test.charAt(i);
			es.pushString(c);
		}
		
	}
}
