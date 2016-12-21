import javax.swing.SwingUtilities;
import org.opencv.core.Core;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
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
		/**System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());
		JFrame frame = new JFrame("RTTView");
		JSplitPane splitPane = new JSplitPane();
		JPanel topPanel = new JPanel();
		JPanel botPanel = new JPanel();
		JTextField textField = new JTextField();
		VideoPanel vidPan = new VideoPanel();
		TranslatedText translatedText = new TranslatedText();
		textField.setText(translatedText.getText());
		//JPanel mainPanel = new JPanel();
		//mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		frame.setSize(657, 750);
		frame.setLayout(new GridLayout());
		frame.add(splitPane);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(600);
		splitPane.setTopComponent(topPanel);
		splitPane.setBottomComponent(botPanel);
		botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.Y_AXIS));
		topPanel.add(vidPan);
		textField.setEditable(false);
		botPanel.add(textField);
		botPanel.setVisible(true);
		//mainPanel.add(new VideoPanel());//, BorderLayout.NORTH);
		//mainPanel.add(new TranslationPanel());//, BorderLayout.SOUTH);
		//mainPanel.setVisible(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}

}
