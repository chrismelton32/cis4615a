public class R06_MET01_J
{
	public static void main(String[] args)
	{
		int num1 = getAbsAdd(-3, 7);
		int num2 = getAbsAdd2(-6, -12);

		System.out.printf("getAbsAdd result: %d\ngetAbsAdd2 result: %d\n", num1, num2);
	}

	// Rule 06. Methods (MET)
	// MET01-J. Never use assertions to validate method arguments
	// Given the non-compliant code below:
	public static int getAbsAdd(int x, int y)
	{
		assert x != Integer.MIN_VALUE;
		assert y != Integer.MIN_VALUE;
		int absX = Math.abs(x);
		int absY = Math.abs(y);
		assert (absX <= Integer.MAX_VALUE - absY);
		return absX + absY;
	}

	// Correct the code as shown in the Compliant Solution below:
	public static int getAbsAdd2(int x, int y)
	{
		if(x == Integer.MIN_VALUE || y == Integer.MIN_VALUE)
		{
			throw new IllegalArgumentException();
		}
		int absX = Math.abs(x);
		int absY = Math.abs(y);
		if(absX > Integer.MAX_VALUE - absY)
		{
			throw new IllegalArgumentException();
		}
		return absX + absY;
	}
}
