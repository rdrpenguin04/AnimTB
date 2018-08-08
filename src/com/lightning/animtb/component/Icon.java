package com.lightning.animtb.component;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lightning.animtb.main.Main;

public class Icon extends Component {
	private BufferedImage icon;
	
	public Icon(BufferedImage icon) {
		super(icon.getWidth(null), icon.getHeight(null));
		this.icon = icon;
	}
	public Icon(BufferedImage icon, int x, int y) {
		super(x, y, icon.getWidth(null), icon.getHeight(null));
		this.icon = icon;
	}

	public void renderThis() {
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		g.drawImage(icon, x, y, null);
	}
	
	public boolean mousePressedThis(int mouseX, int mouseY, int button) {return false;}
	
	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) {return false;}
}
