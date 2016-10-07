import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;
import org.opencv.videoio.VideoCapture;

public class Video //implements Runnable
{
	boolean flag = false;
	VideoCapture webCam = new VideoCapture(0);
	Mat frame = new Mat();
	MatOfByte byteMat = new MatOfByte();
	Image image = null;
	BufferedImage buffer = null;
	String filePath = "";

	public BufferedImage displayImage()
	{
		if(webCam.grab())
		{
			webCam.retrieve(frame);
			Imgcodecs.imencode(".jpg", frame, byteMat);
			try {
				image = ImageIO.read( new ByteArrayInputStream(byteMat.toArray()));
				buffer = (BufferedImage) image;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Cannot read from Input Stream");
				e.printStackTrace();
			}
			return buffer;
		}
		else
		{
			return null;
		}
	}
}
