package com.lightning.animtb.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lightning.animtb.main.Main;

public class Button extends Component {
	public Runnable whenClicked;
	
	public Button(String text, Runnable whenClicked) {
		super(Math.max(text.length()*8, 56)+8, 24);
		if(text.length()*8 > 64) {
			subComponents.add(new Text(text, x+4, y+4));
		} else {
			subComponents.add(new Text(text, x+32-text.length()*4, y+4));
		}
	}
	
	public Button(String text, Runnable whenClicked, int x, int y) {
		super(x, y, Math.max(text.length()*8, 56)+8, 24);
		if(text.length()*8 > 64) {
			subComponents.add(new Text(text, x+4, y+8));
		} else {
			subComponents.add(new Text(text, x+32-text.length()*4, y+4));
		}
	}
	
	public void renderThis(boolean halfBright) {
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		g.setColor(halfBright ? Color.LIGHT_GRAY.darker() : Color.LIGHT_GRAY);
		g.fillRect(x, y, width, height);
	}
	
	public boolean mousePressedThis(int mouseX, int mouseY) {return false;}
	
	public boolean mouseReleasedThis(int mouseX, int mouseY) {
		whenClicked.run();
		return true;
	}
}
