public class WoodenDuck extends Duck
{
	public WoodenDuck()
	{
		fb = new NoFly();
		qb = new NoQuack();
	}

	public void display()
	{
		System.out.println(" Wooden Duck !!");
	}

		
}