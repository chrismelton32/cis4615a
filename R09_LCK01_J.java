public class R09_LCK01_J
{
	// Rule 09. Locking (LCK)
	// LCK01-J. Do not synchronize on objects that may be reused
	// Given the non-compliant code below:
	private int count = 0;
	private final Integer Lock = count;

	public void doSomething()
	{
		synchronized(Lock) 
		{
			count++;
			// ...
		}
	}

	// Correct the code as shown in the Compliant Solution below:
	private int count2 = 0;
	private final Integer Lock2 = new Integer(count);

	public void doSomething2()
	{
		synchronized(Lock2) 
		{
			count2++;
			// ...
		}
	}
}
