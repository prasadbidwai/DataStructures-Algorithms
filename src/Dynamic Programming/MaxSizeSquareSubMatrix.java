/*

Question: Given a matrix of dimensions mxn having all entries as 1 or 0, 
find out the size of maximum size square sub-matrix with all 1s.

*/

class MaxSizeSquareSubMatrix{

	public static void main(String[] args) {

		int matrix[][] = { 	   { 0, 1, 1, 0, 1, 1 },
	                           { 1, 1, 0, 1, 1, 1 },
	                           { 0, 1, 1, 1, 0, 0 },
	                           { 1, 1, 1, 1, 0, 0 },
	                           { 1, 1, 1, 1, 1, 0 },
	                           { 0, 1, 1, 1, 0, 1 }
	                         };
		
		System.out.println("The maximum size of the sub-matrix with all 1`s is:  "+ returnMaxSize(matrix));
	}

	public static int returnMaxSize(int[][] matrix){

		int r = matrix.length;
		int c = matrix[0].length;
		int maxSize = 0; 

		int[][] maxTable = new int[r][c];

		for (int i = 0; i < r ; i++) {
			for (int j = 0; j < c ; j++ ) {
						
				if(i == 0 || j == 0)
				{
					maxTable[i][j] = matrix[i][j];
					maxSize = maxTable[i][j] > maxSize ? maxTable[i][j] : maxSize;
				}

				else if(matrix[i][j] == 0)
					maxTable[i][j] = 0;

				else
				{
					maxTable[i][j] = Math.min(Math.min(maxTable[i-1][j-1], maxTable[i-1][j]), maxTable[i][j-1]) + 1;
					maxSize = maxTable[i][j] > maxSize ? maxTable[i][j] : maxSize;
				}

			}
		}

			for (int i = 0; i < r ; i++) {
			for (int j = 0; j < c ; j++ ) {
				System.out.print(maxTable[i][j]+" ");
			}
			System.out.println(" ");
		}
	
		return maxSize;

	}


}