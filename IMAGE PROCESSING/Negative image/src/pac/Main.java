package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {

		try {
			File input_file = new File("photo/in.jpg");
			BufferedImage image = ImageIO.read(input_file);

			int height = image.getHeight();
			int width = image.getWidth();

			for (int i = 0; i < width; ++i) {
				for (int j = 0; j < height; ++j) {

					int pixel = image.getRGB(i, j);

					//get the current colors of a pixel
					int alpha = (pixel>>24) & 0xff;
					int red = (pixel>>16) & 0xff;
					int green = (pixel>>8) &0xff;
					int blue = (pixel) & 0xff;

					//substract the color to make it negative
					red = 255 - red;
					green = 255 - green;
					blue = 255 - blue;

					//set the new value to the current pixel
					pixel = (alpha<<24) | (red<<16) | (green<<8) | blue;
					image.setRGB(i, j, pixel);
				}
			}

			//write the output image...
			File output_file = new File("photo/out.jpg");
			ImageIO.write(image, "jpg", output_file);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
