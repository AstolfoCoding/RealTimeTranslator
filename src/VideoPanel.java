import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class VideoPanel  extends JPanel
{
	/**
	 * The VideoPanel class will set up the video panel and it's dimensions.
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	Video vid = new Video();
	
	public VideoPanel()
	{
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Timer timer = new Timer(0, new TimerListener());
		timer.start();
	}
	
	class TimerListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			image = vid.displayImage();
			repaint();
		}
		
	}
	
	public Dimension getPreferredSize()	
	{
		return new Dimension(700,700);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(image, 0, 0, this);
	}
}
