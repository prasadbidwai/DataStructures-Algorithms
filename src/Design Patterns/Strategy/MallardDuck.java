public class MallardDuck extends Duck
{
	public MallardDuck()
	{
		fb = new FlyWIthWings();
		qb = new Quack();	
	}	
	
	public void display()
	{
		System.out.println("hey this is MallardDuck !!");
	}
}