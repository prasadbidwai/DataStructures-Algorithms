package com.Graph;

public class GraphApp {
	
	public static void main(String args[]){
		
		Graph gr = new Graph(5);
		
		gr.addVertex('a');
		gr.addVertex('d');
		gr.addVertex('b');
		gr.addVertex('c');
		gr.addVertex('e');
		//gr.addVertex('a');
		
		gr.addAdjecancyMatrix(0, 1);
		gr.addAdjecancyMatrix(1, 2);
		gr.addAdjecancyMatrix(0, 3);
		gr.addAdjecancyMatrix(3, 4);
		
		gr.DFS();
		System.out.println();
	}

}
