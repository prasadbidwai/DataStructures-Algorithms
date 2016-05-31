public class Whip extends CondimentDecorator
{
	Beverage beverage;

	public Whip(Beverage be)
	{
		this.beverage = be;
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

