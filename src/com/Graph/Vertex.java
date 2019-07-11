package com.Graph;

public class Vertex {
	
	private char label;
	private boolean isVisited;
	
	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}
		
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Vertex(char lab){
		label = lab;
		isVisited = false;
	}
	
	

}
