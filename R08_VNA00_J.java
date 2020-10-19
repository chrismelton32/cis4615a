public class R08_VNA00_J
{
	// Rule 08. Visibility and Atomicity
	// VNA00-J. Ensure visibility when accessing shared primitive variables
	// Given the non-compliant code below:
	final class ControlledStop implements Runnable
	{
		private boolean done = false;

		@Override public void run()
		{
			while(!done)
			{
				try
				{
					// ...
					Thread.currentThread().sleep(1000); // Do something
				}
				catch(InterruptedException ie)
				{
					Thread.currentThread().interrupt(); // Reset interrupted status
				}
			}
		}
		
		public void shutdown()
		{
			done = true;
		}
	}

	// Correct the code as shown in the Compliant Solution below:
	final class ControlledStop2 implements Runnable
	{
		private volatile boolean done = false;

		@Override public void run()
		{
			while(!done)
			{
				try
				{
					// ...
					Thread.currentThread().sleep(1000); // Do something
				}
				catch(InterruptedException ie)
				{
					Thread.currentThread().interrupt(); // Reset interrupted status
				}
			}
		}

		public void shutdown()
		{
			done = true;
		}
	}
}
