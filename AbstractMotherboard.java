
//------------------------AbstractMotherboardProduct ---------------------//
abstract class AbstractMotherboard
{
	abstract String test();
}
//-------------------ConcretRichieMotherboardProduct ---------------------//
class RichieMotherboard extends AbstractMotherboard
{
	public String test()
	{
		return "Richie Motherboard Test\n\t-- 5.60 V";
	}
}
//---------------ConcreteAdvanceRichieMotherboardProduct -----------------//
class AdvanceMotherboard extends AbstractMotherboard
{
	public String test()
	{
		return "AdvanceRichie Motherboard Test\n\t-- 8.43 V";
	}
}
//-------------------ConcretSuperRichieMotherboardProduct ----------------//
class SuperMotherboard extends AbstractMotherboard
{
	public String test()
	{
		return "SuperRichie Motherboard Test\n\t-- 12.43 V";
	}
}
//----------------ConcreteUltraRichieMotherboardProduct ------------------//
class UltraMotherboard extends AbstractMotherboard
{
	public String test()
	{
		return "UltraRichie Motherboard Test\n\t-- 14.22 V";
	}
}

