package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		try {

			int width = 400;
			int height = 250;

			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			for (int i = 0; i < width; ++i) {
				for (int j = 0; j < height; ++j) {

					int alhpa = (int)(Math.random() * 256); //generating
					int red = (int)(Math.random() * 256); //values
					int green = (int)(Math.random() * 256); //less than
					int blue = (int)(Math.random() * 256); //256

					int pixel = (alhpa<<24) | (red<<16) | (green<<8) | blue;
					image.setRGB(i, j, pixel);
				}
			}

			//let's see the result..
			File output_file = new File("photo/out.jpg");
			ImageIO.write(image, "jpg", output_file);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
