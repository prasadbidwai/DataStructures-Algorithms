class StrategyPatternSingleFile
{
	public static void main(String[] args) 
	{
		Duck md = new MallardDuck();

		System.out.println("\nMallard Duck behavior:: ");
		md.performFly();
		md.performQuack();

		Duck wd = new WoodenDuck();

		System.out.println("\nWooden Duck behavior:: ");
		wd.performFly();
		wd.performQuack();

		System.out.println("\nchanging the Flying Behavior to fly With rocket !!");
		wd.setFlyBehavior(new FlyWRocket());
		wd.performFly();		
	}


public static class Duck
{
	FlyBehavior fb;
	QuackBehavior qb;

	public void performFly()
	{
		fb.fly();
	}

	public void performQuack()
	{
		qb.quack();
	}

	public void setFlyBehavior(FlyBehavior fb)
	{
		this.fb = fb;
	}

	public void setQuackBehavior(QuackBehavior qb)
	{
		this.qb = qb;
	}
}

interface FlyBehavior
{
	public void fly();
}

interface QuackBehavior
{
	public void quack();
}

static class MallardDuck extends Duck
{
	public MallardDuck()
	{
		fb = new FlyWithWings();
		qb = new Quack();
	}

}

static class FlyWithWings implements FlyBehavior
{
	public void fly()
	{
		System.out.println("I am flying With Wings");
	}
}

static class FlyWRocket implements FlyBehavior
{
	public void fly()
	{
		System.out.println("I am flying Rocket powered !!");
	}
}

static class NoFly implements FlyBehavior
{
	public void fly()
	{
		System.out.println("I am a wooden Duck, Cant fly :p");
	}
}

static class Quack implements QuackBehavior
{
	public void quack()
	{
		System.out.println("Quack Quack");
	}
}

static class NoQuack implements QuackBehavior
{
	public void quack()
	{
		System.out.println("   *****Mute*****    ");
	}
}

static class WoodenDuck extends Duck
{
	public WoodenDuck()
	{
		fb = new NoFly();
		qb = new NoQuack();
	}
}

}