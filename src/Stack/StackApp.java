class StackApp{
	

	public static void main(String[] args) {
	
	Stackx op = new Stackx();

		op.push(1);
		op.push(2);
		op.push(3);
		op.push(4);

		while(!op.isEmpty()){

			int thisOne = op.pop();
			System.out.println(thisOne+ " ");
		}

		BracketChecker bc = new BracketChecker();
		
		System.out.println("String being tested: a{b[c]d}e");
		bc.checkDelimeter("a{b[c]d}e");

		System.out.println("\n String being tested: a[b{c}d]e}");
		bc.checkDelimeter("a[b{c}d]e}");

		System.out.println(" \n String being tested: a{b(c)");
		bc.checkDelimeter("a{b(c)");
		
		
		}
}