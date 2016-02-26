class TheQueue{
	
	int rear, front;
	int[] queueArray;
	int maxSize = 20;

	public TheQueue(){
		rear = -1;
		front = 0;
		queueArray = new int[maxSize];
	}

	public void insert(int key){
		if(rear == maxSize - 1)
		{
			rear = -1;
		}
		queueArray[++rear] = key;
	}

	public int remove(){
		int temp = queueArray[front++];

		if(front == maxSize)
			front = 0;
		return temp;
	}

	public boolean isEmpty(){

		return (front == rear + 1);
	}

}