


//-------------------------------AbstractRichieFactory---------------------------//
abstract class AbstractRichieFactory
{

	public static AbstractRichieFactory Factory(String system) throws NoFactoryException
	{	
		if (system.equals("Richie"))				//Check for single instance and get the instance
			return ConcreteRichie.getInstance();
		else if (system.equals("AdvanceRichie"))
			return ConcreteAdvanceRichie.getInstance();
		else if (system.equals("SuperRichie"))
			return ConcreteSuperRichie.getInstance();
		else if (system.equals("UltraRichie"))
			return ConcreteUltraRichie.getInstance();

		throw new NoFactoryException();			//If system does not matches with any generation builds, throw exception
	}

	abstract AbstractCPU getCPU();				//Get core components
	abstract AbstractMMU getMMU();
	abstract AbstractMotherboard getMotherboard();
}

//-------------------------------ConcreteRichieFactory---------------------------//
class ConcreteRichie extends AbstractRichieFactory
{
	private static AbstractRichieFactory theInstance;		//Singleton Pattern
	private ConcreteRichie()
	{}
	public static AbstractRichieFactory getInstance()
	{
		if (theInstance == null) 
			theInstance = new ConcreteRichie();
		return theInstance;
	}
	
	public AbstractCPU getCPU() 				//Core component Creation
	{ 
		return new RichieCPU(); 
	}
	public AbstractMMU getMMU() 
	{ 
		return new RichieMMU(); 
	}
	public AbstractMotherboard getMotherboard() 
	{ 
		return new RichieMotherboard(); 
	}
}

//-----------------------ConcreteAdvanceRichieFactory---------------------------//
class ConcreteAdvanceRichie extends AbstractRichieFactory
{
	private static AbstractRichieFactory theInstance;		//Singleton Pattern
	public static AbstractRichieFactory getInstance()
	{
		if (theInstance == null) 
			theInstance = new ConcreteAdvanceRichie();
		return theInstance;
	}
	
	public AbstractCPU getCPU()  				//Core component Creation
	{ 
		return new AdvanceCPU(); 
	}
	public AbstractMMU getMMU() 
	{ 
		return new AdvanceMMU(); 
	}
	public AbstractMotherboard getMotherboard() 
	{ 
		return new AdvanceMotherboard(); 
	}
}

//-----------------------ConcreteSuperRichieFactory---------------------------//
class ConcreteSuperRichie extends AbstractRichieFactory
{
	private static AbstractRichieFactory theInstance;		//Singleton Pattern
	private ConcreteSuperRichie()
	{}
	public static AbstractRichieFactory getInstance()
	{
		if (theInstance == null) 
			theInstance = new ConcreteSuperRichie();
		return theInstance;
	}
	
	public AbstractCPU getCPU()  				//Core component Creation
	{ 
		return new SuperCPU(); 
	}
	public AbstractMMU getMMU() 
	{ 
		return new SuperMMU(); 
	}
	public AbstractMotherboard getMotherboard() 
	{ 
		return new SuperMotherboard(); 
	}
}

//-----------------------ConcreteUltraRichieFactory------------------------//
class ConcreteUltraRichie extends AbstractRichieFactory
{
	private static AbstractRichieFactory theInstance;		//Singleton Pattern
	private ConcreteUltraRichie()
	{}
	public static AbstractRichieFactory getInstance()
	{
		if (theInstance == null) 
			theInstance = new ConcreteUltraRichie();
		return theInstance;
	}
	
	public AbstractCPU getCPU()  				//Core component Creation
	{ 
		return new UltraCPU(); 
	}
	public AbstractMMU getMMU() 
	{ 
		return new UltraMMU(); 
	}
	public AbstractMotherboard getMotherboard() 
	{ 
		return new UltraMotherboard(); 
	}
}


class NoFactoryException extends Exception { }
