package pac;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


public class Main {
	public static void main(String[] args) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

			CascadeClassifier classifier = new CascadeClassifier();
			classifier.load("haarcascade_frontalface_alt.xml");

			String fileName = "photo/in.jpg";
			Mat image = Imgcodecs.imread(fileName);

			//face detection
			MatOfRect faceDetection = new MatOfRect();
			classifier.detectMultiScale(image, faceDetection);

			//create a box that surrounds the face
			for (Rect rect : faceDetection.toArray()) {
				System.out.println(rect);
				Imgproc.rectangle(image, new Point(rect.x, rect.y),
						new Point(rect.x + rect.width, rect.y + rect.height),
						new Scalar(0, 255, 0));

			}

			String outputFile = "photo/out.jpg";
			Imgcodecs.imwrite(outputFile, image);

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
