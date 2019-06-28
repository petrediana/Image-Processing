package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		try {
			File input_file  = new File("photo/in.jpg");
			BufferedImage image = ImageIO.read(input_file);

			int height = image.getHeight();
			int width = image.getWidth();

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {

					int pixel = image.getRGB(j, i);

					int alpha = (pixel>>24) & 0xff;
					int red = (pixel>>16) & 0xff;
					int blue = (pixel>>8) & 0xff;
					int green = pixel & 0xff;

					//get the avarage of those
					int avg = (red + blue + green) / 3;

					//replace the RGB value with the avarage
					//NOTE: alpha will stay the same
					pixel = (alpha<<24) | (avg<<16) | (avg<<8) | avg;
					image.setRGB(j, i, pixel);
				}
			}

			//write the output...
			File output_file = new File("photo/out.jpg");
			ImageIO.write(image, "jpg", output_file);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
