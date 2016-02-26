class TheStack{

	int top; 
	int[] stackArray;
	int maxSize = 20;

	public TheStack(){
		top = -1;
		stackArray = new int[maxSize];
	}

	public void push(int key){
		stackArray[++top] = key;
	}

	public int pop(){
		return stackArray[top--];
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public int peek(){
		return stackArray[top];
	}
}