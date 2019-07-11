package sorting;

public class Sort {
	
	int[] a = {7,8,9,4,3,2,5,1};
	int in;
	int out;

	int len=a.length;
	
	public void bubbleSort() {
		for(out=len-1;out>0;out--)
		{
			for(in=0;in<out;in++)
			{
				if(a[in]>a[in+1])
					swap(in,(in+1));
				
			}
			
		}
	}

	public void selectSort()
	{
		for (int i = 0; i < a.length-1; i++) {
	        // Assume first element is min
	      int  min = i;
	        for (int j = i + 1; j < a.length; j++) {
	            if (a[j] < a[min]) {
	                min = j;

	            }
	        }
	        if (min != i) {
	            swap(i,min);
	        }
	            
	    }
	}

	public void swap(int one, int two)
	{
	int temp = a[one];
	a[one] = a[two];
	a[two] = temp;
	}

	public void display() {
		for(int i=0;i<len;i++)
		{			
			System.out.println(" "+a[i]);			
		}
		
	}

	
	
}




		
