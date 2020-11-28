package converter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TxtFilesWriter
{
	private static int slideNumber = 1;

	public static void writeToNewTxt(String notesContent, String pptxPath) throws IOException
	{
		Path path = Paths.get(pptxPath);
		Path parent = path.getParent();
		Path newDirectory = parent.resolve("Scripts");
		if (!Files.exists(newDirectory))
		{
			System.out.println("CREATING FOLDER");
			Files.createDirectory(newDirectory);
		}
		Path newFile = newDirectory.resolve(slideNumber + ".txt");
		Path newFilePath = Files.createFile(newFile);
		System.out.println("CREATING FILE " + slideNumber + ".txt");
		Files.write(newFilePath, notesContent.getBytes());
		System.out.println("Successfully extracted scripts for slide N:" + slideNumber);
		slideNumber++;
	}
}
