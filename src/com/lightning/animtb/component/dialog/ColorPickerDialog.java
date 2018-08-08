package com.lightning.animtb.component.dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;

import com.lightning.animtb.component.Button;
import com.lightning.animtb.component.TextButton;
import com.lightning.animtb.main.Main;
import com.lightning.animtb.util.Invokable;
import com.lightning.animtb.util.Util;

public class ColorPickerDialog extends Dialog {
	public float hue, saturation, value;
	public Invokable whenPicked;
	
	public ColorPickerDialog(Color curColor, Invokable whenPicked) {
		super(176, 168);
		Button selectButton = new TextButton("Select", new Runnable() {
			public void run() {
				removeThis();
			}
		}, x + 56, y + 140);
		subComponents.add(selectButton);
		float r = curColor.getRed()/255f, g = curColor.getGreen()/255f, b = curColor.getBlue()/255f;
		float min, max, delta;
		min = Math.min(r, Math.min(g, b));
		max = Math.max(r, Math.max(g, b));
		value = max;
		delta = max - min;
		if( max != 0 )
			saturation = delta / max;
		else {
			saturation = 0;
			hue = 0;
		}
		if( r == max )
			hue = (g - b) / delta;
		else if( g == max )
			hue = 2 + (b - r) / delta;
		else
			hue = 4 + (r - g) / delta;
		hue /= 6;
		if(hue < 0)
			hue++;
		this.whenPicked = whenPicked;
	}

	private boolean mouseDownInHS = false;
	private boolean mouseDownInV = false;
	
	public void renderThis() {
		super.renderThis();
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		for(int i = 0; i < 128; i++) {
			for(int j = 0; j < 128; j++) {
				target.setRGB(x+i+4, y+j+4, HSVToRGB(i/128f, j/128f, value));
			}
			g.setColor(new Color(i*2, i*2, i*2));
			g.fillRect(x+140, y+i+4, 32, 1);
		}
		g.setColor(Color.BLACK);
		g.drawArc((int)(hue*128+x-0.5f), (int)(saturation*128+y-0.5f), 8, 8, 0, 360);
		g.fillPolygon(new int[] {x+136,x+140,x+136}, new int[] {(int)(y+value*128+8),(int)(y+value*128+4),(int)(y+value*128)}, 3);
		g.fillPolygon(new int[] {x+176,x+172,x+176}, new int[] {(int)(y+value*128+8),(int)(y+value*128+4),(int)(y+value*128)}, 3);
		
		if(!Main.mouseDown) {
			mouseDownInHS = false;
			mouseDownInV = false;
			return;
		}
		
		Point mousePos = MouseInfo.getPointerInfo().getLocation(); // We're fullscreen, so why convert?
		int mouseX = mousePos.x;
		int mouseY = mousePos.y;
		
		mouseX -= x;
		mouseY -= y;
		if(mouseDownInHS) {
			mouseX = Util.clamp(mouseX, 4, 132);
			mouseY = Util.clamp(mouseY, 4, 132);
			hue = (mouseX-4)/128f;
			saturation = (mouseY-4)/128f;
		} else if(mouseDownInV) {
			mouseY = Util.clamp(mouseY, 4, 132);
			value = (mouseY-4)/128f;
		}
		whenPicked.invoke(new Color(HSVToRGB(hue, saturation, value)));
	}

	public boolean mousePressedThis(int mouseX, int mouseY, int button) {
		mouseX -= x;
		mouseY -= y;
		if(mouseX >= 4 && mouseX < 132 && mouseY >= 4 && mouseY < 132) {
			mouseDownInHS = true;
		} else if(mouseX >= 140 && mouseX < 172 && mouseY >= 4 && mouseY < 132) {
			mouseDownInV = true;
		}
		return true;
	}

	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) {
		return true;
	}
	
	private static int HSVToRGB(float hue, float saturation, float value) {
		float r, g, b;
		float f, p, q, t;
		if(saturation == 0) {
			r = g = b = value;
			return combineRGB(r, g, b);
		}
		hue *= 6;
		int i = (int)Math.floor(hue);
		f = hue - i;
		p = value * (1 - saturation);
		q = value * (1 - saturation * f);
		t = value * (1 - saturation * (1 - f));
		switch( i ) {
			case 0:
				r = value;
				g = t;
				b = p;
				break;
			case 1:
				r = q;
				g = value;
				b = p;
				break;
			case 2:
				r = p;
				g = value;
				b = t;
				break;
			case 3:
				r = p;
				g = q;
				b = value;
				break;
			case 4:
				r = t;
				g = p;
				b = value;
				break;
			default:
				r = value;
				g = p;
				b = q;
				break;
		}
		return combineRGB(r, g, b);
	}
	
	public static int combineRGB(float r, float g, float b) {
		return ((int)Math.min(r*256, 255) << 16) + ((int)Math.min(g*256, 255) << 8) + ((int)Math.min(b*256, 255));
	}
}
