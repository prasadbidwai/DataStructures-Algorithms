class Client
{
	
	public static void main(String[] args) 
	{
		
		Singleton inst;

//		inst = new Singleton();

		inst = Singleton.getInstance();	
	}
	
}