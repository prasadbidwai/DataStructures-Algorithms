class MergeSortEx{

	int[] sortArray;
	int nElements;

	public MergeSortEx(int s)
	{
		
		sortArray = new int[s];
		nElements = 0;

	}
	public void insert(int s){

		sortArray[nElements] = s;
		nElements++;
	}

	public void mergeSort(){

		int[] workSpace = new int[nElements];
		recMergeSort(workSpace, 0, nElements-1);
	}

	public void recMergeSort(int[] workSpace, int lowbound, int upbound)
	{

		if (lowbound == upbound) {
			return;
		}

		else
		{
			int mid = (lowbound+upbound) / 2;

			recMergeSort(workSpace, lowbound, mid);
			recMergeSort(workSpace, mid+1, upbound);
			mergeOp(workSpace, lowbound, mid+1, upbound);
		}
	}

	public void mergeOp(int[] workSpace, int lowPtr, int highPtr, int upbound)
	{

		int j = 0;
		int lowbound = lowPtr;
		int mid = highPtr-1;
		int n = upbound - lowbound + 1; 

		while(lowPtr <= mid && highPtr <= upbound)

			if(sortArray[lowPtr] < sortArray[highPtr])
				workSpace[j++] = sortArray[lowPtr++];
			
			
			else
			
				workSpace[j++] = sortArray[highPtr++];
			

		while(lowPtr <= mid)
		{
			workSpace[j++] = sortArray[lowPtr++];
		}

		while(highPtr <= upbound){
			workSpace[j++] = sortArray[highPtr++];
		}

	
		for(int k=0; k < n ; k++)
		{
			sortArray[lowbound+k] = workSpace[k];
		}

//		display(workSpace);
	
	}
	public void display(){
		for (int i = 0; i < nElements; i++){
			System.out.println(" "+ sortArray[i]);
		}
	}

}