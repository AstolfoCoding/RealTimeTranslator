import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TranslatedText extends JPanel
{
	/**
	 * Generated UID from Eclipse
	 */
	private static final long serialVersionUID = 8755532489147261754L;
	private String translatedText;
	Video vid = new Video();
	BufferedImage image = null;
	ITesseract instance = new Tesseract();
	/**
	 * 
	 */
	public TranslatedText()
	{

	}

	public BufferedImage getImage()
	{
		return image;
	}
	public String getText()
	{
		translatedText = setText();
		return translatedText;
	}
	
	public String setText()
	{
		String result = null;
		image = vid.displayImage();
		System.out.println("I'm here");
		if(image!=null)
		{
			try {
				result = instance.doOCR(image);
				System.out.println("I'm here");
			} catch (TesseractException e) {
				System.err.println(e.getMessage());
			}
		}
		return result;
	}
	
}
