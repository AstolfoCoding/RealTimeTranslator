import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.opencv.core.Core;


import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

public class RTTView 
{

	public static void main(String[] args) 
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				displayVideoFeed();
			}
		});

	}
	
	private static void displayVideoFeed()
	{
		System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
		JFrame frame = new JFrame("RTTView");
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new VideoPanel(), BorderLayout.NORTH);
		frame.setVisible(true);
		
	}

}
