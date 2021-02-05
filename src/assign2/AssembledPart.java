package assign2;
import java.util.HashMap;

public class AssembledPart extends Part
{
	private Part partA = null;
	private Part partB = null;
	private double assemblyFee = 0.0;

	public AssembledPart(String aID, String aName, int aStockLevel, double aAssemblyFee, 
			Part aPartA, Part aPartB) 
	{	
		super(aID, aName, aStockLevel, (aAssemblyFee + aPartA.unitPrice + aPartB.unitPrice));
		this.assemblyFee = aAssemblyFee;
		this.partA = aPartA;
		this.partB = aPartB;
	}

	public int getAvailForAssembly()
	{
		if (this.partA.getStockLevel() < this.partB.getStockLevel())
		{
			return this.partA.getStockLevel();
		}
		else
		{
			return this.partB.getStockLevel();
		}
	}

	@Override
	public double supply(int qty) 
	{
		try{
			if (qty <= this.stockLevel)
			{
				this.stockLevel -= qty;
				return this.unitPrice * qty; 
			}
			else if (qty <= this.stockLevel + getAvailForAssembly())
			{
				double premade = this.stockLevel; 
				int remaining = qty - this.stockLevel;
				this.stockLevel = 0;
				this.partA.supply(remaining);
				this.partB.supply(remaining);

				return qty*this.unitPrice; 
			}

			else
			{
				throw new PartShortException(0, "error: Assembled Part");
			}
		}
		catch(PartShortException e)
		{
			System.out.println(e.getMessage());
			return -1;
		}
	}	
}
