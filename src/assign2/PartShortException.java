package assign2;

public class PartShortException extends Exception
{
	private int quantityAvailable = 0; // current stock level.
	
	public PartShortException(int qAvailable, String errMsg)
	{
		super(errMsg);
		this.quantityAvailable = qAvailable;
	}
	
	public int getQuantity()
	{
		return quantityAvailable;
	}

}
