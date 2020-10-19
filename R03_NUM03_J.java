import java.io.DataInputStream;
import java.io.IOException;

public class R03_NUM03_J
{
	public static void main(String[] args)
	{
		DataInputStream is = new DataInputStream(System.in);

		try
		{
			int i = getInteger(is);
			long l = getIntegerL(is);
			is.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	// Rule 03. Numeric Types and Operations (NUM)
	// NUM03-J. Use integer types that can fully represent the possible range of unsigned data
	// Given the non-compliant code below:
	public static int getInteger(DataInputStream is) throws IOException
	{
		return is.readInt();
	}

	// Correct the code as shown in the compliant solution below:
	public static long getIntegerL(DataInputStream is) throws IOException
	{
		return is.readInt() & 0xFFFFFFFFL; // Mask with 32 one-bits
	}
}
