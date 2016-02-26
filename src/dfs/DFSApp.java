class DFSApp{
	
	public static void main(String[] args){
		//TheGraph tg = new TheGraph();

		TheGraph tg = new TheGraph();

		tg.addVertex('A'); // 0 (start for dfs)
		tg.addVertex('B'); // 1
		tg.addVertex('C'); // 2
		tg.addVertex('D'); // 3
		tg.addVertex('E'); // 4
		
		tg.addEdge(0, 1); // AB
		tg.addEdge(1, 2); // BC
		tg.addEdge(0, 3); // AD
		tg.addEdge(3, 4); // DE
		
//		tg.printGraph();
//		tg.displayVertices();

		tg.dfs(); // depth-first search
		tg.bfs();

		System.out.println();
	}
}