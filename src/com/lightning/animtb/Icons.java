package com.lightning.animtb;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Icons {
	public static BufferedImage IIcon;
	public static BufferedImage MIcon;
	public static BufferedImage warningIcon;
	public static BufferedImage XIcon;

	static {
		try {
			IIcon = ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAYAAACqaXHeAAAABmJLR0QAGQAZAP+qRjn+AAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH4ggJFjoA5yIV2QAAAB1pVFh0Q29tbWVudAAAAAAAQ3JlYXRlZCB3aXRoIEdJTVBkLmUHAAADhElEQVR42u2bYW7DIAyFccQlktN0J99O0x2D/ajYXNfGBjsJ1YJUravahPfxniE0hXRcK53vhyM6BRMJPqWvcKTwUmxMAOCwPuc9RVPB39/Gg5HPESAlEkaOFo87TwXf74MnQMdkYMBZAFjhWDQVbHWABQYCUTxuyF7xVDgWHeWADhCwN4CXUW8Jj3bAur4es5TickOOHHXp/2gHVBDb9jiHxw3ZI94ivBUJS6siLVAYN0AEAFW8BEIripFuGIWQe8RjgVb7Y9EeANT2XD1o1AVwRQDPw1S8Jry3ELaEWWKybSyEIQcUzvaSeEl4b+573k+F48+SOIguyJbprkf8qPAeIJJwDoK2asya9XGRk8R7R90KQooHF4H6Pi0KuWV9LERyARa/h3DJDdv2DEMa/bpOkKKQtas6KvQs8RwIDgItvPU1KQqL1fqcCzzib7eUSnk8brcxCHS9wfWlvibtRWTribgDe0b+8/P5OYA/EtzrpBA2AZTW6FPr77GqG220L9T2TEH8jcFiHX1OsCf3Hx/884hpEvdZ62Pu2cDEo+8tel9fY7a3QNBsj4thloqfleDMjes7XRdka8YiR//RkUQ2PvdZMWptSf+8LSn+C4x3aiVr+Z916rNOidp+wRKRtZmL3lUDLgAXgAvABeACcAGIA2C80jqljfQt/12MgOkWltlXg9v2eKyr/BdfDS7poLuxJm3w72tAttpq9muCanFs924AUh14110hLf8YAFj2BWiVnQUMHX1r/tUI0IPRGWBdz4fACaajbo0ApJQKjoF1v322qU8CguwP5iKICVq+iTnL+lL2h2YByQUcjHryoyHQ0ZZES8VPAvBSDPFJKgz62tEQsHjO+spUCJoDnmpBFUVHX4JgBTHyPUDtgySec4GUfVMN4KKAR5sjfL/vMztg8VQwFwnN+hqApyhIoy89j1wrcKPeEt8ogF03Sb1EwQLB0iy3yXE1CAvUQNT3tKzfdS2AozAqHMej59qjJVwCQcS7LoZ+o9DaL8C5r/fteDZO6PTWgsE9J+Jdt8qyEOqJvEItMeBgtED0iDdHoAVBy3tvTLglt8X+I+J7ALxASOnvC9UI21sKoRQHJu+7/GACH1isCxEgJAdEjboHQNMNe13icnXAM+oRAFg3RIFoOSBKeAQAdtWIOzgKgzqgMadDROej21v9dPb68fSBexhT/nz+BwmmtCZaQAZ1AAAAAElFTkSuQmCC")));
		} catch(Exception e) {
			IIcon = null;
		}
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
