public class R12_TSM01_J
{
	// Rule 12. Thread-Safety Miscellaneous (TSM)
	// TSM01-J. Do not let the this reference escape during object construction.
	// Given the non-compliant code below:
	final class Publisher
	{
		public static Publisher published;
		int num;

		Publisher(int number)
		{
			// Initialization
			this.num = number;
			// ...
			published = this;
		}
	}

	// Correct the code as shown in the Compliant Solution below:
	final class Publisher2
	{
		static volatile Publisher2 published;
		int num;

		Publisher2(int number)
		{
			// Initialization
			this.num = number;
			// ...
			published = this;
		}
	}
}
