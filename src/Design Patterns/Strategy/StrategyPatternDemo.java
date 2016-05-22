class StrategyPatternDemo
{

	public static void main(String[] args) {
	
	Duck md = new MallardDuck();
	
	md.performFly();
	md.performQuack();

	Duck wd = new WoodenDuck();

	wd.performFly();
	wd.performQuack();

	wd.setFlyBehavior(new FlyWRocket());
	wd.performFly();		
	}
}

/*
*/