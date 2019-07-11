package com.MergeSort;

public class MergeSart {
	
	public int[] array = {30, 20, 10, 90, 100, 60, 500, 200};		
	
	public void mergeSort(){		
		int[] workSpace = new int[array.length];
		recmergeSort(workSpace, 0, array.length-1);
		printSorted();
	}

	public void recmergeSort(int[] workspace, int lowerbound, int upperbound){

		if (lowerbound == upperbound)
		{
			return;
		}
		else
		{	
			int mid = (lowerbound + upperbound) / 2;

			recmergeSort(workspace, lowerbound, mid);
			recmergeSort(workspace, mid+1, upperbound);
			merge(workspace, lowerbound, mid+1, upperbound);
		}
	}

	public void merge(int[] workspace, int lowptr, int highptr, int upperbound){

		int lowerbound = lowptr;
		int mid = highptr -1;
		int j = 0;
		int n = upperbound - lowerbound + 1;
		
		while(lowptr <= mid && highptr <= upperbound){

			if(array[lowptr] <= array[highptr]){
				workspace[j++] = array[lowptr++];
			}
			
			else {
					workspace[j++] = array[highptr++];
			}
		}
		
		while(lowptr <= mid){
			workspace[j++] = array[lowptr++];
		}
			
		while(highptr <= upperbound){
			workspace[j++] = array[highptr++];
		}
		
		
		for(j=0; j<n; j++){
			array[lowerbound+j] = workspace[j];
	}
			
	}
	
	public void printSorted(){
		for(int i = 0; i < array.length; i++){
			System.out.println(" "+array[i]);
		}
	}

}