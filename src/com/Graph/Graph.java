package com.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int[][] adjMatrix;
	private Vertex[] vertexList;
	private int nvertises;
	Stackx styak;
	Queue<Integer> qn;
	
	public Graph(int size){

		adjMatrix = new int[size][size];
		vertexList = new Vertex[20];
		nvertises = 0;

		styak = new Stackx();
		qn = new LinkedList<Integer>();

		for(int i = 0; i < size; i++){
			for(int j = 0; j< size; j++){
				adjMatrix [i][j] = 0;
			}
		}
	}

	public void addVertex(char lab){
		vertexList[nvertises++] = new Vertex(lab);				
	}

	public void displayVertex(int v){
		System.out.print(vertexList[v].getLabel()+" ");
	}

	public void addAdjecancyMatrix(int a, int b){
		adjMatrix [a][b] = adjMatrix[b][a] = 1;
	}


	public void DFS(){

		displayVertex(0);;
		vertexList[0].setVisited(true);
		styak.push(0);

		while(!styak.isEmpty()){
			int v = getAdjecant(styak.peek());
			if (v == -1){
				styak.pop();
			}

			else {
				displayVertex(v);
				vertexList[v].setVisited(true);
				styak.push(v);
			}
		}
		
		for (int i = 0; i < nvertises; i++) {
			vertexList[i].setVisited(false);
		}
	}
	
	public void BFS() {
		displayVertex(0);
		vertexList[0].setVisited(true);
		qn.add(0);		
		int v2;
		
		while (!qn.isEmpty()) {
			int v1 = qn.remove();
			while((v2 = getAdjecant(v1))!=-1 ) {
				displayVertex(v2);
				vertexList[v2].setVisited(true);
				qn.add(v2);
			}
			
		} 
		for (int i = 0; i < nvertises; i++) {
			vertexList[i].setVisited(false);
		}
	}

	public int getAdjecant(int v){

		for(int j = 0; j < nvertises; j++){
			if (adjMatrix[v][j] == 1 && vertexList[j].isVisited() == false){
				return j;
			}
		}
		return -1;
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


}
