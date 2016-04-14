class Trials
{
	private int maxsize = 10000001;
	private int[] workspace;
	private int[] theArray;
	private int nElemes;

	public Trials()
	{
		nElemes = 0;
		theArray = new int[maxsize];
	}

	public void insert(int key)
	{
		theArray[nElemes++] = key;
	}
	
	public void mergeSort()
	{
		workspace = new int[nElemes];
		recmergeSort(workspace, 0, nElemes-1); 
	}

	public void createArray()
	{

	}

	public void recmergeSort(int[] workspace, int lowerBound, int upperBound)
	{
		if(lowerBound == upperBound)
		{
			return; 
		}

		else
		{
			int mid = (lowerBound + upperBound)/2;

			recmergeSort(workspace, lowerBound, mid);
			recmergeSort(workspace, mid+1, upperBound);
			merge(workspace, lowerBound, mid+1, upperBound);
		}
	}

	public  void displayArray()
	{
		for (int i = 0 ; i < nElemes; i++) 
		{
			System.out.println(theArray[i]);	
		}
		
	}

	public void merge(int[] workspace, int lowerPtr, int highrPtr, int upperBound)
	{

		int mid = highrPtr -1;
		int lowerBound = lowerPtr;

		int n = (upperBound - lowerBound)+1;
		int j = 0;


		while(lowerPtr <= mid && highrPtr <= upperBound)
		{
			if(theArray[lowerPtr] < theArray[highrPtr])
			{
				workspace[j++] = theArray[lowerPtr++];
			}
			else
			{
				workspace[j++] = theArray[highrPtr++];
			}
		}

		while(lowerPtr <= mid)
		{
			workspace[j++] = theArray[lowerPtr++];
		}

		while(highrPtr <= upperBound)
		{
			workspace[j++] = theArray[highrPtr++];
		}

		for( j = 0 ; j < n ; j++)
		{
			theArray[lowerBound+j] = workspace[j];
		}
	
	}

	public void quickSOrt()
	{
		recQuickSort(0, nElemes-1);
	}

	public void recQuickSort(int left, int right)
	{
		if(right <= left)
		{
			return;
		}

		else
		{
			int pivot = theArray[right];
			
			int partition = partiotioIt(left, right, pivot);

			recQuickSort(left, partition -1);
			recQuickSort(partition+1, right);
		}
	}

	public int partiotioIt(int left, int right, int pivot)
	{
		int leftptr = left - 1;
		int rightptr = right;

		while(true)
		{
			while(theArray[++leftptr]  < pivot)
				;
			while(rightptr > 0 && theArray[--rightptr] > pivot)
				;

			if(rightptr <= leftptr)
				break;

			swap(leftptr, rightptr);
		}
		swap(leftptr, right);
		return leftptr;
	
	}

	public void swap(int left, int right)
	{
		int temp = theArray[left];
		theArray[left] = theArray[right];
		theArray[right] = temp;
	}

}