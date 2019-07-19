class MinEditDistance
{
	public static void main(String[] args) {
		
		String s1 = "Editxyz";
		String s2 = "xyz";

		System.out.println("the min distance between two strings: "+ s1 +" and "+ s2 +" is: "+ findMinDistance(s1, s2));

	}

	public static int findMinDistance(String s1, String s2){

		int numOfRows = s1.length()+1;
		int numColumns = s2.length()+1;

		int[][] distanceTable = new int [numOfRows][numColumns];
		int m, n = 0;


		for (m = 0 ; m < numOfRows ; m++){
			for (n = 0 ; n < numColumns; n++) {

				if(m == 0)
					distanceTable[m][n] = n;

				else if(n == 0)
					distanceTable[m][n] = m;

				else if(s1.charAt(m-1) == s2.charAt(n-1))
					distanceTable[m][n] = distanceTable[m-1][n-1];
				
				else
					distanceTable[m][n] = Math.min(distanceTable[m-1][n-1], Math.min(distanceTable[m][n-1], distanceTable[m-1][n]))+1;
				
			}
		}

		return distanceTable[m-1][n-1];
	}
}