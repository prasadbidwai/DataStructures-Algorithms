package com.Graph;

public class Graph {

	private int[][] adjMatrix;
	private Vertex[] vertexList;
	private int nvertises;
	Stackx styak;
	public Graph(int size){

		adjMatrix = new int[size][size];
		vertexList = new Vertex[20];
		nvertises = 0;

		styak = new Stackx();

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
		System.out.println(vertexList[v].getLabel());
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
	}

	public int getAdjecant(int v){

		for(int j = 0; j < vertexList.length; j++){

			if (adjMatrix[v][j] == 1 && vertexList[j].isVisited() == false){

				return j;
			}
		}

		return -1;
	}




}
