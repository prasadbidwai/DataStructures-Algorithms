
class DecoratorSingleFile
{
	public static void main(String[] args) 
	{
		Beverage beverage = new HouseBlend();

		System.out.println(beverage.getDescription()+ "$" +beverage.cost());
		
		Beverage beverage2 = new DarkRoast();
		
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		
		System.out.println(beverage2.getDescription()+ "$" + beverage2.cost());

		Beverage beverage3 = new Whip(new Mocha(new HouseBlend()));
		System.out.println(beverage3.getDescription()+ "$" + beverage3.cost());	
	}
}

abstract class Beverage
{
	String description = "NO description available for";

	public String getDescription()
	{
		return description;
	}

	public abstract int cost();

}

abstract class CondimentDecorator extends Beverage
{
	public abstract String getDescription();
}

class HouseBlend extends Beverage
{
	public HouseBlend()
	{
		description = "HouseBlend coffee";
	}

	public int cost()
	{
		return 3;
	}

}

class DarkRoast extends Beverage
{
	public DarkRoast()
	{
		description = "DarkRoast";
	}

	public int cost()
	{
		return 1;
	}
}

class Mocha extends CondimentDecorator
{
	Beverage beverage;

	public Mocha(Beverage be)
	{
		beverage = be;
	}

	public String getDescription()
	{
		return beverage.getDescription()+ ", Mocha ";
	}

	public int cost()
	{
		return 1+ beverage.cost();
	}
}

class Whip extends CondimentDecorator
{
	Beverage beverage;

	public Whip(Beverage be)
	{
		beverage = be;
	}

	public String getDescription()
	{
		return beverage.getDescription()+ ", Whip ";
	}

	public int cost()
	{
		return 1+ beverage.cost();
	}
}


