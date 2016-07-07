class SimpleThread //extends Thread
{
	public static void main(String[] args) {
		
		new MyThread("customThread");		
	}
}

class MyThread extends Thread
	{
		MyThread(String name)
		{
			super(name);
			start();
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

/* Output:

the name of the curent thread: customThread
Thread ID: 11
thread priority is:5
thread group: java.lang.ThreadGroup[name=main,maxpri=10]
thread state: RUNNABLE
thread maxPriority: 10

*/

//Simple thread Example Using Runnable Interface: 

// public class MyRunnable implements Runnable
// {
// 	public void run() 
// 	{
// 		System.out.println("Executing thread "+Thread.currentThread().getName());
// 	}

// 	public static void main(String[] args) throws InterruptedException 
// 	{
	
// 		Thread myThread = new Thread(new MyRunnable(), "myRunnable");
// 		myThread.start();
	
// 	}
// }

/*
output:

Executing thread myRunnable
*/

// One more Example of Thread Implementation using Runnable:

// class NewThread implements Runnable 
// {
// 	Thread t;
// 	NewThread() 
// 	{
// 		// Create a new, second thread
// 		t = new Thread(this, "Demo Thread");
// 		System.out.println("Child thread: " + t);
// 		t.start(); // Start the thread
// 	}
// 	// This is the entry point for the second thread.
// 	public void run() 
// 	{
// 		try 
// 		{
// 			for(int i = 5; i > 0; i--) 
// 			{
// 				System.out.println("Child Thread: " + i);
// 				Thread.sleep(500);
// 			}
// 		} catch (InterruptedException e) {
// 		System.out.println("Child interrupted.");
// 		}
// 		System.out.println("Exiting child thread.");
// 	}
// }
// class SimpleThread 
// {
// 	public static void main(String args[]) 
// 	{
// 		new NewThread(); // create a new thread
// 		try 
// 		{
// 			for(int i = 5; i > 0; i--) 
// 			{
// 				System.out.println("Main Thread: " + i);
// 				Thread.sleep(1000);
// 			}
// 		} catch (InterruptedException e) 
// 			{
// 				System.out.println("Main thread interrupted.");
// 			}
// 		System.out.println("Main thread exiting.");
// 	}
// }

/*
Output:
	Child thread: Thread[Demo Thread,5,main]
	Main Thread: 5
	Child Thread: 5
	Child Thread: 4
	Main Thread: 4
	Child Thread: 3
	Child Thread: 2
	Main Thread: 3
	Child Thread: 1
	Exiting child thread.
	Main Thread: 2
	Main Thread: 1
	Main thread exiting.
*/