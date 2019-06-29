package pac;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		try {

			BufferedImage image1 = ImageIO.read(new File("photo/in.jpg"));
			BufferedImage image2 = ImageIO.read(new File("photo/out.jpg"));

			int width1 = image1.getWidth();
			int height1 = image1.getHeight();
			int width2 = image2.getWidth();
			int height2 = image2.getHeight();

			if (width1 == width2 && height1 == height2) {
				long dif = 0;

				for (int i = 0; i < width1; ++i) {
					for (int j = 0; j < height1; ++j) {
						int pixel1 = image1.getRGB(i, j);
						int pixel2 = image2.getRGB(i, j);

						int red1 = (pixel1>>16) & 0xff;
						int red2 = (pixel2>>16) & 0xff;

						int green1 = (pixel1>>8) & 0xff;
						int green2 = (pixel2>>8) & 0xff;

						int blue1 = (pixel1) & 0xff;
						int blue2 = (pixel2) & 0xff;

						dif += Math.abs(red1 - red2);
						dif += Math.abs(green1 - green2);
						dif += Math.abs(blue1 - blue2);
					}
				}
				// Total number of red pixels = width * height
				// Total number of blue pixels = width * height
				// Total number of green pixels = width * height
				// So total number of pixels = width * height * 3
				double total_pixels = width1 * height1 * 3;

				// Normalizing the value of different pixels
				// for accuracy(average pixels per color
				// component)
				double avg_pixels = dif / total_pixels;

				// There are 255 values of pixels in total
				double percentage = (avg_pixels / 255) * 100;

				System.out.println("Difference Percentage --> " + percentage);

			} else {
				System.out.println("The width and height must be the same!!");
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
