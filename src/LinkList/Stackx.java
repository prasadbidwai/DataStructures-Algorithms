class Stackx{
	
	LinkList StackLink;
	public Stackx(){

		StackLink = new LinkList();
	}

	public void push(int j){

		StackLink.addFirstLink(j);
	}

	public int pop(){

		int poped = StackLink.deleteFirst();
		return	poped;
	}

	public boolean isEmpty(){

		return StackLink.isEmpty();
	}


}