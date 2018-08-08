package com.lightning.animtb.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lightning.animtb.Icons;
import com.lightning.animtb.main.Main;

public class MenuBar extends Component {
	public MenuBar() {
		super(0, 0, Main.width, 16);
		subComponents.add(new IconButton(new Icon(Icons.MIcon), new Runnable() {
			public void run() {
				Main.minimize();
			}
		}, Main.width - 32, 0));
		subComponents.add(new IconButton(new Icon(Icons.XIcon), new Runnable() {
			public void run() {
				Main.sendCloseSignal();
			}
		}, Main.width - 16, 0));
	}

	public void renderThis() {
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, width, height);
		if(width != Main.width) {
			subComponents.get(0).x = Main.width - 32;
			subComponents.get(1).x = Main.width - 16;
			width = Main.width;
		}
	}

	public boolean mousePressedThis(int mouseX, int mouseY, int button) {return false;}

	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) {return false;}
}
