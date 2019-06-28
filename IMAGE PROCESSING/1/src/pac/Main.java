package pac;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		Main app = new Main();

		try {

			String filePath = "photo/in/p1.jpg";
			File input_file = new File(filePath);

			BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(input_file);

			System.out.println("Image read");


			String outputPath = "photo/out";
			File outputFile = new File(outputPath);

			ImageIO.write(image, "jpg", outputFile);

			System.out.println("Image wrote");
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
