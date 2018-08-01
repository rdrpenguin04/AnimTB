package com.lightning.animtb;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Icons {
	public static BufferedImage MIcon;
	public static BufferedImage warningIcon;
	public static BufferedImage XIcon;

	static {
		try {
			MIcon = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4ggBAhMmr/IsjAAAAB1pVFh0Q29tbWVudAAAAAAAQ3JlYXRlZCB3aXRoIEdJTVBkLmUHAAAAHUlEQVQoz2NkYPjPQApgYiARjEgNtAeMoxFHCw0AiRICGUAdhEkAAAAASUVORK5CYII=")));
		} catch(Exception e) {
			MIcon = null;
		}
		try {
			warningIcon = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABAAgMAAADXB5lNAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4gcGAiYLV5sdJwAAAB1pVFh0Q29tbWVudAAAAAAAQ3JlYXRlZCB3aXRoIEdJTVBkLmUHAAAACVBMVEX///8AAAD//wBT7WDCAAAAAXRSTlMAQObYZgAAAAFiS0dEAmYLfGQAAADFSURBVDjLfZNBDsMgDAR3K/fuS//jJ/TQ/jP/y6UH24CKDVLAQcNqCAHw9vpE8cBfkxgNHRETHExHCE3PhIrKmTAVHgnCGCINIQRCpCFU/OkJ0/sKkZogLLqO8OUuUhOu4H1N+GpPKokw8KEk8nOadkQeiUpH5LEKGyJPxIuKSA0Pq4jU8CqJ53sSqeFpRQbnX0xYRUwNwLQipgagMoj7GsTUAIRFxqIBELbvZdUATPeMVQNQ2YlVAxAWe7H1leC3vnOHiR+8nA7KH2eOhAAAAABJRU5ErkJggg==")));
		} catch(Exception e) {
			warningIcon = null;
		}
		try {
			XIcon = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4ggBATcyRoanDgAAAB1pVFh0Q29tbWVudAAAAAAAQ3JlYXRlZCB3aXRoIEdJTVBkLmUHAAAAX0lEQVQoz5WSQQoAMQgDJ/n/n+1hYSlYU+rBg2ZEgwKA4h7a8p35da5WCuoC77N1U/MBgVFb2P0GzWpANYyczHBud+vMY5i4kjKwXzn55uDgkXFw8Mg4qI/M8/Pp9b0XEc8YG5juF3IAAAAASUVORK5CYII=")));
		} catch(Exception e) {
			XIcon = null;
		}
	}
}
