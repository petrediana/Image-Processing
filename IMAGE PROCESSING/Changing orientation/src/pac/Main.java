package pac;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			//input bufferedimage image
			File inputFile = new File("photo/in.jpg");
			BufferedImage image = ImageIO.read(inputFile);

			//convert BufferedImage to Mat obj
			byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
			mat.put(0, 0, data);

			Mat newMat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
			Core.flip(mat, newMat, -1);

			//convert the newMat image to a BufferedImage
			byte[] newData = new byte[newMat.rows() * newMat.cols() * (int)(newMat.elemSize())];
			newMat.get(0, 0, newData);

			BufferedImage image1 = new BufferedImage(newMat.cols(), newMat.rows(), BufferedImage.TYPE_3BYTE_BGR);
			image1.getRaster().setDataElements(0,0,newMat.cols(),newMat.rows(),newData);

			File outputFile = new File("photo/out.jpg");
			ImageIO.write(image1, "jpg", outputFile);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
