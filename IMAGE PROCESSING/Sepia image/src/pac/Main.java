package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		try {
			File input_file = new File("photo/in.jpg");
			BufferedImage image = ImageIO.read(input_file);

			int width = image.getWidth();
			int height = image.getHeight();

			for (int i = 0; i < width; ++i) {
				for (int j = 0; j < height; ++j) {

					int pixel = image.getRGB(i, j);

					int alpha = (pixel>>24) & 0xff;
					int red = (pixel>>16) & 0xff;
					int green = (pixel>>8) & 0xff;
					int blue = pixel & 0xff;

					//calculate newRed, newGreen, newBlue
					int newRed = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
					int newGreen = (int)(0.349 * red + 0.686 * green+ 0.168 * blue);
					int newBlue = (int)(0.272 * red + 0.534 * green+ 0.131 * blue);

					//check condition
					red = (newRed > 255) ? 255 : newRed;
					green = (newRed > 255) ? 255 : newGreen;
					blue = (newRed > 255) ? 255 : newBlue;


					//replace the current pixel
					pixel = (alpha<<24) | (red<<16) | (green<<8) | blue;
					image.setRGB(i, j, pixel);

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
