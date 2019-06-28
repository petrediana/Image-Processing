package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainUPSIDEDOWN {
	public static void main(String[] args) {
		try {
			File inputFile = new File("photo/in.jpg");
			BufferedImage image = ImageIO.read(inputFile);

			int width = image.getWidth();
			int height = image.getHeight();

			BufferedImage mirrorImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			for (int i = 0; i < width; ++i) {
				for (int j = 0; j < height; ++j) {
					int curr_pixel = image.getRGB(i, j);

					mirrorImage.setRGB(i, height - 1 - j, curr_pixel);
				}
			}

			//see the output
			File outputFile = new File("photo/outUPSIDEDOWN.jpg");
			ImageIO.write(mirrorImage, "jpg", outputFile);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
