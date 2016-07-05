class Singleton
{
	private static Singleton instance;

	private Singleton()
	{}

	public static Singleton getInstance()
	{
		if (instance == null)
			instance = new Singleton();
		return instance;
	}
}

// *************** End of Simpler version Singleton ***************


/*Thread Safe Version Using Synchronized
   Synchronized method can have an overhead and might hamper the getInstance methode*/

class SingletonThreadSafe
{
	private static SingletonThreadSafe uniqueInstance;

	private SingletonThreadSafe(){}

	public static Synchronized SingletonThreadSafe getInstance()
	{
		if(uniqueInstance == null){
			uniqueInstance = new SingletonThreadSafe();
		}

		return uniqueInstance;
	}
}
// *************** End of Thread Safe version of Singleton using Synchronized ***************


/* Double check lock version for(not guarnteed to work prior to Java 5)*/

class SingletonDoubleCheck
{
	private volatile static SingletonDoubleCheck uniqueInstance; 
	/* Volatile keyword ensures the variable uniqueInstance is handled correctly 
	by multiple threads when is being initialized to Singleton instance */

	private SingletonDoubleCheck(){}

	public static SingletonDoubleCheck getInstance()
	{
		if(uniqueInstance == null)
		{
			Synchronized(SingletonDoubleCheck.class)
			{
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonDoubleCheck();
				}
			}
		}
		return uniqueInstance;
	}

} 