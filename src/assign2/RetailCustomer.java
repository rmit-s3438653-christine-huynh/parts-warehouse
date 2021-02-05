package assign2;

public class RetailCustomer extends Customer
{
	private double discountRate = 0.0;
	
	public RetailCustomer(String cID, String cName, double cDiscountRate)
	{
		super(cID, cName);
		this.discountRate = cDiscountRate;
	}
	
	public double getDiscountRate()
	{
		return discountRate;
	}
	
	public double getDiscount(double aValue)
	{
		return aValue * this.discountRate;
	}

	@Override
	public String getId() 
	{
		return super.customerId;
	}

	@Override
	public String getName() 
	{
		return super.customerName;
	}
	public String toString()
	{
		return super.customerId + " Name: " + super.customerName
				+ " DiscountRate: %" + discountRate + ".";
	}
	
}