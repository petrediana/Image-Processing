package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainBLUE {
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
					int blue = (pixel) & 0xff;

					//Paint the image all blue
					//So keep the BLUE and WHITE
					pixel = (alpha << 24) | blue;
					image.setRGB(i, j, pixel);

				}
			}

			//write the output
			File output_file = new File("photo/outBLUE.jpg");
			ImageIO.write(image, "jpg", output_file);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
