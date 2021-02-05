package assign2;

public class Part implements java.io.Serializable
{
	private String id = "part_id";
	private String name = "part_name";
	protected int stockLevel = -99;
	protected double unitPrice = -99.9;

	public Part(String pID, String pName, int pStockLevel, double pUnitPrice)
	{
		this.id = pID;
		this.name = pName;
		this.stockLevel = pStockLevel;
		this.unitPrice = pUnitPrice;
	}

	public String getID()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public int getStockLevel()
	{
		return this.stockLevel;
	}

	public double getUnitPrice()
	{
		return this.unitPrice;
	}

	public boolean replenish(int qty)
	{
		if (qty <= 0)
		{
			System.out.println("Quantity must be greater than 0.");
			return false;
		}
		else
		{
			this.stockLevel += qty;
			return true;
		}
	}

	public double supply(int qty)throws PartShortException
	{

		if (qty <= this.stockLevel)
		{
			this.stockLevel -= qty;
			return this.unitPrice * qty; 
		}
		else
		{
			throw new PartShortException(0, "PartShortException: current Qty < " + qty);
		}	

	}

	public String toString()
	{
		return getID() + " (" 
				+ getName() + ") "
				+ "Stock qty: "+ getStockLevel() + ", "
				+ "Unit-price $"+ Math.floor(getUnitPrice()*100)/100 + ".";
	}
}
