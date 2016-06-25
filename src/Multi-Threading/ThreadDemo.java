//code to demnostrate the new thread creation using the runnable Interface method
// other file associated with this: NewThread.java

class ThreadDemo 
{
	public static void main(String args[]) 
	{
		new NewThread(); // create a new thread
	try {
	
		for(int i = 5; i > 0; i--) 
		{
			System.out.println("Main Thread: " + i);
			Thread.sleep(1000);
		}
	} catch (InterruptedException e) 
		{
			System.out.println("Main thread interrupted.");
		}
	
		System.out.println("Main thread exiting.");
	}

static class NewThread implements Runnable 
{
	Thread t;
	NewThread() 
	{
	// Create a new, second thread
		t = new Thread(this, "Demo Thread");
		System.out.println("Child thread: " + t);
		t.start(); // Start the thread
	}
	// This is the entry point for the second thread.
	public void run() 
	{
		System.out.println("call came to NewThread run method first");
		try 
		{
			for(int i = 5; i > 0; i--) 
			{
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) 
		  {
			System.out.println("Child interrupted.");
		  }
		System.out.println("Exiting child thread.");
	}
}
 
}