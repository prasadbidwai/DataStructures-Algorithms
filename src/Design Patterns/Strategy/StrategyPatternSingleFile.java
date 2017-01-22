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
}

abstract class Duck
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

class MallardDuck extends Duck
{
	public MallardDuck()
	{
		fb = new FlyWithWings();
		qb = new Quack();
	}

}

class FlyWithWings implements FlyBehavior
{
	public void fly()
	{
		System.out.println("I am flying With Wings");
	}
}

class FlyWRocket implements FlyBehavior
{
	public void fly()
	{
		System.out.println("I am flying Rocket powered !!");
	}
}

class NoFly implements FlyBehavior
{
	public void fly()
	{
		System.out.println("I am a wooden Duck, Cant fly :p");
	}
}

class Quack implements QuackBehavior
{
	public void quack()
	{
		System.out.println("Quack Quack");
	}
}

class NoQuack implements QuackBehavior
{
	public void quack()
	{
		System.out.println("   *****Mute*****    ");
	}
}

class WoodenDuck extends Duck
{
	public WoodenDuck()
	{
		fb = new NoFly();
		qb = new NoQuack();
	}
}

