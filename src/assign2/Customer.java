package assign2;

public abstract class Customer implements java.io.Serializable
{
	protected String customerId = "cust_id";
	protected String customerName = "cust_name";
	
	public Customer(String cID, String cName) 
	{
		this.customerId = cID;
		this.customerName = cName;
	}

	public abstract double getDiscount(double aValue);
	
	public abstract String getId();
	
	public abstract String getName();
}
