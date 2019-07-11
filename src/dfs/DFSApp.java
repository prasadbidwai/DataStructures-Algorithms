class DFSApp{
	
	public static void main(String[] args){
		//TheGraph tg = new TheGraph();

		TheGraph tg = new TheGraph();

		tg.addVertex('A'); // 0 (start for dfs)
		tg.addVertex('B'); // 1
		tg.addVertex('C'); // 2
		tg.addVertex('D'); // 3
		tg.addVertex('E'); // 4
		tg.addVertex('F'); // 5
		tg.addVertex('G'); // 6		
		
		tg.addEdge(0, 1); // AB
		tg.addEdge(1, 2); // BC
		tg.addEdge(0, 3); // AD
		tg.addEdge(3, 4); // DE
		tg.addEdge(1, 6); // BG
		tg.addEdge(3, 5); // DF
		
//		tg.printGraph();
//		tg.displayVertices();

		System.out.println("Calling the DFS:: ");
		tg.dfs(); // depth-first search
		
		System.out.println("\nCalling the BFS Now :: ");
		tg.bfs();

		System.out.println();
	}
}


//	The Tree:
//			      A
//			   /     \
//			  B       D	
//			 / \     / \
//			C   G   E   F
