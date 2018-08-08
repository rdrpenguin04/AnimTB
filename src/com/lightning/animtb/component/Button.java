package com.lightning.animtb.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lightning.animtb.main.Main;

public class Button extends Component {
	public Runnable whenClicked;
	
	public Button(Runnable whenClicked, int width, int height) {
		super(width, height);
		this.whenClicked = whenClicked;
	}
	
	public Button(Runnable whenClicked, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.whenClicked = whenClicked;
	}
	
	public void renderThis() {
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, width, height);
	}
	
	public boolean mousePressedThis(int mouseX, int mouseY, int button) {return false;}
	
	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) {
		whenClicked.run();
		return true;
	}
}
