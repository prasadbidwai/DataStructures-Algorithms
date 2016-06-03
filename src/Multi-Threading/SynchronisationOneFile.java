class SynchronisationOneFile
{
	public static void main(String[] args) {
		Callme target =  new Callme();

		Caller ob1 = new Caller(target, "Hello");
		Caller ob2 = new Caller(target, "Synchronised");
		Caller ob3 = new Caller(target, "World !!");

		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted "+ e);
		}
	}

static class Caller implements Runnable
{
	Thread t;
	String msg;
	Callme target;

	public Caller(Callme targ, String s)
	{
		msg = s;
		target = targ;
		t = new Thread(this);
		t.start();	// In multithreading, start will call run method to begin thread execution 
	}

	public void run() 			
	{
		
		target.call(msg);	//call to method w/o synchronized keyword.

		target.synchronizedCall(msg);	//call to method with synchronized keyword.
	}
}	
	
static class Callme{
	//Method w/o synchronized keyword.
	void call(String msg)	
	{

		System.out.print("[ "+ msg);
	try{
			Thread.sleep(1000);
	   }catch(InterruptedException e)
	    {
			System.out.println("Interrupted"+ e);
		}
		System.out.println("]");
	}

	//Method with synchronized keyword.
	synchronized void synchronizedCall(String msg)
	{
		System.out.print("[ "+ msg);
	try{
			Thread.sleep(1000);
	   }catch(InterruptedException e)
	    {
			System.out.println("Interrupted"+ e);
		}
		System.out.println("]");
	}
}

}

/*
Output:

// output for the method w/o synchronized method:

c:\Data Structures\Multi-Threading\Synchronisation>java SynchronisationOneFile
[ Synchronised[ World !![ Hello]
]
]

// output for the synchronized method: 

[ World !!]				
[ Synchronised]
[ Hello]

*/