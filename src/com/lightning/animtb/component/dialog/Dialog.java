package com.lightning.animtb.component.dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lightning.animtb.component.Component;
import com.lightning.animtb.main.Main;

public abstract class Dialog extends Component {
	public Dialog(int width, int height) {
		super(width, height);
	}

	public void renderThis() {
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
}
