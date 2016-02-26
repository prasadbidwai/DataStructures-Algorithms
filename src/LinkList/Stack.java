class Stackx
{
	
	int top;
	int maxsize;
	int[] stackArray;

	public Stack(int size)
	{	
		maxsize = size;
		stackArray = new stackArray[maxsize]; 
		top = -1;
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}

	public boolean isFull(){

		return (top == maxsize-1); 
	}

	public void push(int key){

		stackArray[++top] = key;
	}

	public int pop(){

		return stackArray[top--];
	}

	public int peek(){

		return stackArray[top];
	}
	

}