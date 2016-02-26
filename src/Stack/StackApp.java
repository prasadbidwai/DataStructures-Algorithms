class StackApp{
	
	public StackApp(){

		Stackx op = new Stackx(4);
	}

		op.push(1);
		op.push(2);
		op.push(3);
		op.push(4);

		while(!op.isEmpty){

			int thisOne = op.pop();
			System.out.println(thisOne+ " ");
		}
	
}