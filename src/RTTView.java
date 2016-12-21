import javax.swing.SwingUtilities;
import org.opencv.core.Core;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class RTTView extends javax.swing.JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
				displayPanels();
			}
		});

	}
	
	/**
	 * Set up frame and add video/text panels
	 */
	private static void displayPanels()
	{
		
		System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
		JFrame frame = new JFrame("RTTView");
		frame.setSize(657, 750);
		frame.setLayout(new GridLayout());
		frame.add(new VideoPanel());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
