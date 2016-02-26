class StackApp{
	
	
	
	
		public static void main(String[] args){

		Stackx op = new Stackx();
		op.push(1);
		op.push(2);
		op.push(3);
		op.push(4);

		while(!op.isEmpty()){

			int thisOne = op.pop();
			System.out.println(thisOne+ " ");
		}
	}
}