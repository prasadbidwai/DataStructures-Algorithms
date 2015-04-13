package linkListQuestions;

import java.util.HashSet;
import java.util.LinkedList;

public class Link {
	
	public int data;
	public Link next;
	
	public Link(int d){
		data = d;
	}
	
	public void displayLink(){
		System.out.println("Data: "+ data);
	}
	
}

