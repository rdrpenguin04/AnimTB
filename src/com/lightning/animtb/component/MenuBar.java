package com.lightning.animtb.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lightning.animtb.Icons;
import com.lightning.animtb.component.dialog.AboutDialog;
import com.lightning.animtb.main.Main;

public class MenuBar extends Component {
	private static final DropButton[] fileMenu;
	private static final DropButton[] windowMenu;
	
	static {
		fileMenu = new DropButton[] {
			new DropButton("New Project...", new Runnable() {
				public void run() {
					Main.newProject();
				}
			})
		};
		windowMenu = new DropButton[] {
			new DropButton("About Animator's Toolbox", new Runnable() {
				public void run() {
					Main.objectStack.push(new AboutDialog());
				}
			})
		};
	}
	
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
		int widthFromLeft = 0;
		DropButton tmp = new DropButton("File ", new Runnable() {
			public void run() {
				Main.objectStack.push(new Dropdown(0, 16, fileMenu));
			}
		});
		tmp.x = 0;
		tmp.y = 0;
		tmp.parent = new DummyParent();
		widthFromLeft += tmp.width;
		subComponents.add(tmp);
		final int windowPos = widthFromLeft;
		tmp = new DropButton("Window ", new Runnable() {
			public void run() {
				Main.objectStack.push(new Dropdown(windowPos, 16, windowMenu));
			}
		});
		tmp.x = widthFromLeft;
		tmp.y = 0;
		tmp.parent = new DummyParent();
		widthFromLeft += tmp.width;
		subComponents.add(tmp);
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
