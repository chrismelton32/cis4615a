import java.io.File;

public class R02_XP00_J
{
	public static void main(String[] args)
	{
		deleteFile1();
		deleteFile2();
	}

	// Given the non-compliant code below:
	public static void deleteFile1()
	{
		File someFile = new File("someFileName.txt");
		// Do something with someFile
		someFile.delete();
	}

	// Correct the code as shown in the Compliant Solution below:
	public static void deleteFile2()
	{
		File someFile = new File("someFileName.txt");
		// Do something with someFile
		if(!someFile.delete())
		{
			// Handle failure to delete the file
		}
	}
}
