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
}