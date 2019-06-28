package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainRED {
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

					//Paint the image all red
					//So keep the RED and WHITE

					pixel = (alpha << 24) | (red << 16);
					image.setRGB(i, j, pixel);

				}
			}

			//write the output
			File output_file = new File("photo/outRED.jpg");
			ImageIO.write(image, "jpg", output_file);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
