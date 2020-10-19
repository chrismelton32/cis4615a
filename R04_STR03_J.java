import java.math.BigInteger;

public class R04_STR03_J
{
	public static void main(String[] args)
	{
		// Rule 04. Characters and Strings (STR)
		// STR03-J. Do not encode noncharacter data as a String
		// Given the non-compliant code below:
		BigInteger x = new BigInteger("530500452766");
		byte[] byteArray = x.toByteArray();
		String s = new String(byteArray);
		byteArray = s.getBytes();
		x = new BigInteger(byteArray);

		// Correct the code as shown in the Compliant Solution below:
		BigInteger x2 = new BigInteger("530500452766");
		String s2 = x2.toString(); // Valid character data
		byte[] byteArray2 = s2.getBytes();
		String ns = new String(byteArray2);
		x2 = new BigInteger(ns);
	}
}
