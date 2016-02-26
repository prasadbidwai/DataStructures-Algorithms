class MergeSortApp{

	public static void main(String[] args){

		MergeSortEx ms = new MergeSortEx(11);

		ms.insert(20);
		ms.insert(11);
		ms.insert(10);
		ms.insert(19);
			ms.insert(88);
		ms.insert(52);
		ms.insert(36);
		ms.insert(2);
		ms.insert(0);
		ms.insert(1);
		ms.insert(51);
	
		ms.mergeSort();
		ms.display();
	}
}