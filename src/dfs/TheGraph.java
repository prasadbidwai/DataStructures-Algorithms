import java.util.*;

class TheGraph{

	private int MaxVerts = 20;
	int[][] adjMatrix;
	private Vertex[] vertexList;
	//private TheStack thestack; 
	Stack<Integer> thestack; 
	private int nVerts;
//	private TheQueue theQ;
	Queue<Integer> theQ;

	public TheGraph(){

		vertexList = new Vertex[MaxVerts];
		adjMatrix = new int[MaxVerts][MaxVerts];
		thestack = new Stack<Integer>();
		theQ = new LinkedList<Integer>();

		nVerts = 0;
		
		for(int i = 0; i < MaxVerts ; i++){
			for(int j = 0 ; j <MaxVerts ; j++){
				adjMatrix [i][j] = 0;
			}
		}
	}

	public void addEdge(int a, int b){
		adjMatrix[a][b] = adjMatrix[b][a] = 1;
	}

	public void addVertex(char c){
		vertexList[nVerts++] = new Vertex(c);
	}

	public void displayVertex(int k){
		System.out.print(vertexList[k].label+" ");
	}

	public void printGraph(){
		for(int m = 0 ; m < nVerts ; m++){
			for(int n = 0 ; n < nVerts ; n++){
				System.out.print(adjMatrix[m][n]+" ");
			}
			System.out.println("\n ");
		}
	}

	public void displayVertices(){
		for (int p = 0 ; p < nVerts ; p++){
			System.out.print(vertexList[p].label+" ");
		}
	}

	public void dfs(){

		vertexList[0].isVisited = true;
		displayVertex(0);
		thestack.push(0);

		while(!thestack.isEmpty()){
			int k = getAdjecantVertex(thestack.peek());

			if (k == -1)
				thestack.pop();

			else{
				vertexList[k].isVisited = true;
				displayVertex(k);
				thestack.push(k);
			}
		}

		for(int l = 0; l < nVerts; l++){
			vertexList[l].isVisited = false;
		}
	}

	public void bfs()
	{
		vertexList[0].isVisited = true;
		displayVertex(0);
		theQ.add(0);
		int v2;

		while(!theQ.isEmpty()){

			int v1 = theQ.remove();

			while((v2 = getAdjecantVertex(v1)) != -1){

				vertexList[v2].isVisited = true;
				displayVertex(v2);
				theQ.add(v2);
			}
		}
		
		for(int l = 0; l < nVerts; l++){
			vertexList[l].isVisited = false;
		}
	}

	public int getAdjecantVertex(int v){
		
		for (int i = 0; i < nVerts; i++) 
			if((adjMatrix[v][i] == 1) && (vertexList[i].isVisited == false)){
				return i;
			}
		return -1;
	}
}