class QueueApp{

	public static void main(String[] args){

		Queuex qu = new Queuex(5);

		qu.insert(2);
		qu.insert(3);
		qu.insert(4);
		qu.insert(9);
		qu.insert(10);
		qu.insert(11);

//		qu.remove();
//		qu.remove();
//		qu.remove();

		qu.insert(5);
		qu.insert(6);
		qu.insert(7);

		while(!qu.isEmpty()){

			int t = qu.remove();
			System.out.println(t + "   ");
		}
	}

}