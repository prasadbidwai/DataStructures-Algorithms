public class Mocha extends CondimentDecorator
{
	Beverage beverage;

	public Mocha(Beverage be)
	{
		beverage = be;
	}

	public String getDescription()
	{
		return beverage.getDescription() + ", Mocha ";
	}

	public int cost()
	{
		return 1 + beverage.cost();
	}
}

