import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
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
			/**JSplitPane splitPane = new JSplitPane();
			JPanel topPanel = new JPanel() 
			{
				private static final long serialVersionUID = 1L;
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(image, 0, 0, null);
					g.drawString(processedText, 0, 700);
				}
				
			};
			
			JPanel botPanel = new JPanel()
			{
				private static final long serialVersionUID = 1L;
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawString(processedText, 0, 700);
				}
				
			};
			JTextField textField = new JTextField();
			textField.setText(processText(image));
			textField.setEditable(false);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setDividerLocation(600);
			splitPane.setTopComponent(topPanel);
			splitPane.setBottomComponent(botPanel);
			botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.Y_AXIS));*/
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
	
	public Dimension getPreferredSize()	
	{
		return new Dimension(650,700);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(image, 0, 0, this);
		g.drawString(processedText, 0, 650);
	}
}
