package converter;

import org.apache.poi.sl.usermodel.Placeholder;
import org.apache.poi.xslf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class Converter
{
	public final static String PRESENTATION_LOCATION = "C:\\Users\\Somebody\\Desktop\\InheritanceAndAbstraction.pptx";

	public static void main(String[] args)
	{
		try (FileInputStream file = new FileInputStream(PRESENTATION_LOCATION))
		{
			XMLSlideShow presentation = new XMLSlideShow(file);
			List<XSLFSlide> slides = presentation.getSlides();
			for (XSLFSlide currentSlide : slides)
			{
				XSLFNotes notesForSlide = currentSlide.getNotes();
				for (XSLFShape shape : notesForSlide)
				{
					if (shape.getPlaceholder() == Placeholder.BODY)
					{
						if (shape instanceof XSLFAutoShape)
						{
							String noteContent = ((XSLFAutoShape) shape).getText();
							TxtFilesWriter.writeToNewTxt(noteContent, PRESENTATION_LOCATION);
						}
					}
				}
			}
		}
		catch (IOException exc)
		{
			exc.printStackTrace();
		}
	}
}
