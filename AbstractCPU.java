
//-------------------------AbstractCPUProduct ---------------------------//
abstract class AbstractCPU
{
	abstract String test();
}
//----------------------ConcreteRichieCPUProduct -------------------------//
class RichieCPU extends AbstractCPU
{
	public String test()
	{
		return "Richie CPU Test:\n-- 1.86 Ghz";
	}
}
//-------------------ConcreteAdvanceRichieCPUProduct ---------------------//
class AdvanceCPU extends AbstractCPU
{
	public String test()
	{
		return "AdvanceRichie CPU Test:\n-- 2.24 Ghz";
	}
}
//--------------------ConcreteSuperRichieCPUProduct ----------------------//
class SuperCPU extends AbstractCPU
{
	public String test()
	{
		return "SuperRichie CPU Test:\n-- 2.43 Ghz";
	}
}
//---------------------ConcreteUltraRichieCPUProduct ---------------------//
class UltraCPU extends AbstractCPU
{
	public String test()
	{
		return "UltraRichie CPU Test:\n-- 2.66 Ghz";
	}
}

