import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	/**
	 * // Returns the image at the path location as a BufferedImage or an error code.
	 * @param path location of the image
	 * @return the image as a BufferedImage or an error code
	 */
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
