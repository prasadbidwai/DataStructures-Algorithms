class SubsetSum{

	public static void main(String[] args) {
		int[] input = {1,3,9,2};
		int target = 5; 

		System.out.println("the subset for sum "+ target+" exists: "+ findIfExists(input, target));
	}

	public static boolean findIfExists(int[] input, int target)
	{
		boolean[][] dptable = new boolean[input.length+1][target+1];

		for (int i = 0 ; i <= input.length ; i++){
			dptable[i][0] = true;
		}

		for(int i = 1 ; i <= target ; i++){
			dptable[0][i] = false;
		}
		
		for (int i = 1 ;i < input.length+1 ;i++ ) {

			for (int j = 1 ;j < target+1 ;j++ ) {

				dptable[i][j] = dptable[i-1][j];				

					if(dptable[i][j] == false && j >= input[i-1])
					{
						dptable[i][j] = dptable[i][j] || dptable[(i-1)][(j - input[i-1])];
					}				
			}			
		}

		return dptable[input.length][target];
	}
}