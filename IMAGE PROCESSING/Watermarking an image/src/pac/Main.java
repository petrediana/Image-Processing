package pac;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
	public static void main(String[] args) {
		try {
			File inputFile = new File("photo/in.jpg");
			BufferedImage image = ImageIO.read(inputFile);

			BufferedImage copy = new BufferedImage(image.getWidth(),
					image.getHeight(), BufferedImage.TYPE_INT_RGB);

			Graphics graphics = copy.getGraphics();
			graphics.drawImage(image, 0, 0, null);

			graphics.setFont(new Font("Arial", Font.PLAIN, 40));
			graphics.setColor(new Color(0, 255, 0, 150));

			String message = "wm";
			graphics.drawString(message, image.getWidth() / 2, image.getHeight() / 2);

			graphics.dispose();

			//write image...
			File outputFile = new File("photo/out.jpg");
			ImageIO.write(copy, "jpg", outputFile);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
