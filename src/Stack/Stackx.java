class Stackx
{
	int top;
	int[] stackArray;
	int maxsize = 20; 

	public Stackx()
	{
		top = -1;
		stackArray = new int[maxsize];
	}

	public void push(int key)
	{
		stackArray[++top] = key;
	}

	public int pop(){
		return stackArray[top--];
	}

	public int peek()
	{
		return stackArray[top];
	}

	public boolean isEmpty()
	{
		return (top==-1);
	}

	public boolean isFull(){
		return (top == maxsize-1);
	}


}