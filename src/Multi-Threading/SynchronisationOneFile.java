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
		
	//	target.call(msg);	//call to method w/o synchronized keyword.

	//	target.synchronizedCall(msg);	//call to method with synchronized keyword.

		synchronized(target) { 		 // synchronized block (one more way to avoid race condition by guarding the call to the unsynchronized method by unsynchronized block)
			target.call(msg);
		}
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

	//Method with synchronized keyword (this will help avoid race condition by allowing exclusively only one thread have access to this method )
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

these 3 different outputs from this program when each method from run is un commented and run one at a time: 

//output when the call() method(unsynchronized) is called: 

[ Synchronised[ World !![ Hello]
]
]
(In this case, nothing exists to stop all three threads from calling the same method, on the same object,
at the same time. This is known as a race condition, because the three threads are racing each
other to complete the method.)


// output for the synchronized method (THE METHOD DEFINITION IS GUARDED BY SYNCHRONIZED KEYWORD.): 
[ Hello]
[ Synchronised]
[ World !!]

//	output when non synchronized method(call()) is called from inside a synchronized block.

[ Hello]
[ World !!]
[ Synchronised]

*/