class SimpleThread //extends Thread
{
	public static void main(String[] args) {
		
		MyThread mythread = new MyThread("customThread");
		mythread.start();
		// System.out.println("the name of the curent thread: "+ Thread.currentThread().getName());
		
	}

	static class MyThread extends Thread
	{
		MyThread(String name)
		{
			super(name);
		}

		public void run()
		{
			System.out.println("the name of the curent thread: "+ Thread.currentThread().getName());
			System.out.println("Thread ID: "+ Thread.currentThread().getId());
			System.out.println("thread priority is:"+ Thread.currentThread().getPriority());
			System.out.println("thread group: "+ Thread.currentThread().getThreadGroup());
			System.out.println("thread state: "+ Thread.currentThread().getState());
			System.out.println("thread maxPriority: "+ Thread.currentThread().getThreadGroup().getMaxPriority());
		}
	}

}

/* Output:

the name of the curent thread: customThread
Thread ID: 11
thread priority is:5
thread group: java.lang.ThreadGroup[name=main,maxpri=10]
thread state: RUNNABLE
thread maxPriority: 10

*/

//Simple thread Example Using Runnable Interface: 

public class MyRunnable implements Runnable
{
	public void run() 
	{
		System.out.println("Executing thread "+Thread.currentThread().getName());
	}

	public static void main(String[] args) throws InterruptedException 
	{
	
		Thread myThread = new Thread(new MyRunnable(), "myRunnable");
		myThread.start();
	
	}
}

/*
output:

Executing thread myRunnable
*/