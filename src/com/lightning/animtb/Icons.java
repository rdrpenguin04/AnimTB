package com.lightning.animtb;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Icons {
	public static BufferedImage warningIcon;

	static {
		try {
			warningIcon = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABAAgMAAADXB5lNAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4gcGAiYLV5sdJwAAAB1pVFh0Q29tbWVudAAAAAAAQ3JlYXRlZCB3aXRoIEdJTVBkLmUHAAAACVBMVEX///8AAAD//wBT7WDCAAAAAXRSTlMAQObYZgAAAAFiS0dEAmYLfGQAAADFSURBVDjLfZNBDsMgDAR3K/fuS//jJ/TQ/jP/y6UH24CKDVLAQcNqCAHw9vpE8cBfkxgNHRETHExHCE3PhIrKmTAVHgnCGCINIQRCpCFU/OkJ0/sKkZogLLqO8OUuUhOu4H1N+GpPKokw8KEk8nOadkQeiUpH5LEKGyJPxIuKSA0Pq4jU8CqJ53sSqeFpRQbnX0xYRUwNwLQipgagMoj7GsTUAIRFxqIBELbvZdUATPeMVQNQ2YlVAxAWe7H1leC3vnOHiR+8nA7KH2eOhAAAAABJRU5ErkJggg==")));
		} catch(Exception e) {
			warningIcon = null;
		}
	}
}
