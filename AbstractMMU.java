

//------------------------------AbstractMMUProduct ------------------------//
abstract class AbstractMMU
{
	abstract String test();
}
//---------------------------ConcreteRichieMMUProduct ------------------------//
class RichieMMU extends AbstractMMU
{
	public String test()
	{
		return "Richie MMU Test:\n-- 1 KB";
	}
}
//-----------------------ConcreteAdvanceRichieMMUProduct ---------------------//
class AdvanceMMU extends AbstractMMU
{
	public String test()
	{
		return "AdvanceRichie MMU Test:\n-- 2 KB";
	}
}
//------------------------ConcretSuperRichieMMUProduct ---------------------//
class SuperMMU extends AbstractMMU
{
	public String test()
	{
		return "SuperRichie MMU Test:\n--4 KB";
	}
}
//------------------------ConcretUltraRichieMMUProduct ---------------------//
class UltraMMU extends AbstractMMU
{
	public String test()
	{
		return "UltraRichie MMU Test: \n--8 KB";
	}
}
