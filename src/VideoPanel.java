import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class VideoPanel  extends JPanel
{
	/**
	 * The VideoPanel class will set up the video panel and it's dimensions.
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	//private BufferedImage extractedImage;
	private String processedText;
	Video vid = new Video();
	ITesseract instance = new Tesseract();
	//instance.setDatapath("")
	
	public VideoPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Timer timer = new Timer(0, new TimerListener());
		timer.start();
	}
	
	/**
	 * The TimerListener repaints the jpg image 
	 */
	class TimerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			
			image = vid.displayImage();
			processedText = processText(image);
			System.out.println(processedText);
			repaint();
		}
		
	}
	
	/**
	 * processText finds the text in a .jpg image and extracts
	 * the text.
	 * @param img - BufferedImage being processed
	 * @return returns a string
	 */
	public String processText(BufferedImage img)
	{
		String result = null;
		System.out.println("I'm here");
		if(img!=null)
		{
			try {
				result = instance.doOCR(img);
			} catch (TesseractException e) {
				System.err.println(e.getMessage());
			}
		}
		return result;
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(image, 0, 0, this);
		g.setColor(Color.white);
		g.fillRect(0, 520, 657, 230);
		g.setColor(Color.black);
		g.drawString(processedText, 250, 650);
	}
}
