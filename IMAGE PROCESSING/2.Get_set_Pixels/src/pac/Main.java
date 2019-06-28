package pac;

import com.sun.prism.paint.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {

		try {
			File inputFile = new File("photo/in/p1.jpg");
			BufferedImage inputImage = ImageIO.read(inputFile);

			int imageWidth = inputImage.getWidth();
			int imageHeight = inputImage.getHeight();
			System.out.println(imageHeight + " " + imageWidth);

			for (int i = 0; i < imageWidth; i++) {
				int pixel = inputImage.getRGB(i, 100);
				pixel = Color.BLACK.getIntArgbPre();
				inputImage.setRGB(i, 100, pixel);
			}

			//write to the file..
			File outputFile = new File("photo/out");
			ImageIO.write(inputImage, "jpg", outputFile);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
