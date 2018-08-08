package com.lightning.animtb.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lightning.animtb.component.dialog.ColorPickerDialog;
import com.lightning.animtb.main.Main;
import com.lightning.animtb.util.Invokable;

public class Scene extends Component {
	public float projectAspect = 16.0f/9;
	public Color projectBG = new Color(0, 0, 255);
	
	public Scene() {
		super(0, 16, Main.width, (Main.height-16)*3/4);
	}

	public void renderThis() {
		if(Main.width != width) width = Main.width;
		if((Main.height-16)*3/4 != height) height = (Main.height-16)*3/4;
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		g.setColor(projectBG);
		g.fillRect(x, y, width, height);
	}
	
	public void renderThisPost() {
		BufferedImage target = Main.display;
		Graphics g = target.getGraphics();
		g.setColor(new Color(0, 0, 0, 128));
		float aspect = (float)width/height;
		
		if(aspect > projectAspect) {
			g.fillRect(x, y, (int)(width-projectAspect*height)/2, height);
			g.fillRect(x+width-(int)(width-projectAspect*height)/2, y, (int)(width-projectAspect*height)/2, height);
		}
	}

	public boolean mousePressedThis(int mouseX, int mouseY, int button) {
		return false;
	}

	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) {
		if(button == 3) { // right
			Scene me = this;
			Dropdown newDD = new Dropdown(mouseX, mouseY, new DropButton[] {
				new DropButton("Change background color", new Runnable() {
					public void run() {
						ColorPickerDialog dialog = new ColorPickerDialog(projectBG, new Invokable() {
							public void invoke(Object... params) {
								projectBG = (Color)params[0];
							}
						});
						dialog.setParent(me);
						subComponents.add(dialog);
					}
				})
			});
			subComponents.add(newDD);
			newDD.setParent(this);
			return true;
		}
		return false;
	}
}
