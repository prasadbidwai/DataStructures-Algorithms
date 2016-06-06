class ProducerConsumer
{

	public static void main(String[] args) {
		
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
	}

	static class Q
	{
		int n;
		boolean flag = true;

		synchronized void put(int n)
		{	while(flag)
				try{
					wait();
				}catch(InterruptedException e) {
					System.out.println("Interrupted execution: "+ e);
				}
			

			this.n = n;
			flag = true;
			System.out.println("put : "+ n);
			notify();
		}

		synchronized int get()
		{	
			while(!flag)
				try{
						wait();
				}catch(InterruptedException e)
					{
						System.out.println("Interrupted "+ e);
					}

			System.out.println("the value(n) being returned: " + n);
			flag = false;
			notify();
			return n;
		}
	} 

	static class Producer implements Runnable
	{
		Q q;
		Thread t;

		Producer(Q q)
		{
			this.q = q;
			t = new Thread(this, "Producer Thread");
			t.start();
		}
		
		public void run()
		{
			int i = 0;

			while(true){
				q.put(i++);
			}
			
		}
	}

	static class Consumer implements Runnable
	{
		Q q;
		Thread t;

		public Consumer(Q q)
		{
			this.q = q;
			t = new Thread(this, "Cosumer");
			t.start();
		}
		
		public void run()
		{
			while(true) {
				q.get();	
			}
		}

	}

}