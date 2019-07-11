package com.Graph;

public class GraphApp {
	
	public static void main(String args[]){
		
		Graph gr = new Graph(5);
		
		gr.addVertex('a');
		gr.addVertex('b');
		gr.addVertex('c');
		gr.addVertex('d');
		gr.addVertex('e');
		//gr.addVertex('a');
		
		gr.addAdjecancyMatrix(0, 1);   //ab
		gr.addAdjecancyMatrix(1, 2);   //bc
		gr.addAdjecancyMatrix(0, 3);   //ad
		gr.addAdjecancyMatrix(3, 4);   //de
		gr.addAdjecancyMatrix(1, 3);   //bd
		
		System.out.println("Prinitng BFS now::");
		gr.BFS();
		
		System.out.println("\n\nPrinting DFS now:: ");
		gr.DFS();
	}

}



/* 
 *		        a
 *		       / \
 *		      b---d
 *		     /     \
 *		    c		e
 * DFS: adbce
 * BFS: acdeb
 */
 