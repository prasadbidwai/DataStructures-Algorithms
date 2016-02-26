class Queuex{


int[] queueAray;
int maxsize, rear, front;
int nItems = 0;

	public Queuex(int s){

		maxsize = s;
		queueAray = new int[maxsize];
		rear = -1;
		front = 0;

	}

	public void insert(int s){

		if(rear == maxsize - 1)
		{
			rear = -1;
		}

		queueAray[++rear] = s;
		nItems++;
	}

	public int remove(){

		int temp = queueAray[front++];

		if(front == maxsize){
			front = 0;
		}
		nItems --;
		
		return temp;
	}

	public boolean isEmpty(){

		return(nItems == 0);
	}

	public boolean isFull(){

		return(nItems == maxsize);
	}

}