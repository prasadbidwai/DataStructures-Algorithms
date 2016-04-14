class SortingApp
{
	public static void main(String[] args)
	{
		Trials arr = new Trials();
		arr.insert(64); // insert items
		arr.insert(21);
		arr.insert(33);
		arr.insert(70);
		arr.insert(12);
		arr.insert(85);
		arr.insert(44);
		arr.insert(3);
		arr.insert(99);
		arr.insert(0);
		arr.insert(108);
		arr.insert(36);

		// for(int j=0; j<100; j++) // fill array with
		// { // random numbers
		// 	int n = (int)(java.lang.Math.random()*99);
		// 	arr.insert(n);
		// }


		arr.displayArray();

		System.out.println("the mergeSort is being called now:: ");

		//arr.mergeSort();
		arr.quickSOrt();
		System.out.println("sorting is done");		
		
		arr.displayArray();
	}
}