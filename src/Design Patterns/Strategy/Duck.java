public abstract class Duck
{
	FlyBehavior fb;
	QuackBehavior qb;

	public abstract void  display();
	
	public void performFly()
	{
		fb.fly();
	}	

	public void performQuack()
	{
		qb.quack();
	}

	public void setFlyBehavior(FlyBehavior newfb)
	{
		fb = newfb; 
	}	

	public void setQuackBehavior(QuackBehavior newfb)
	{
		fb = newfb; 
	}	

}

