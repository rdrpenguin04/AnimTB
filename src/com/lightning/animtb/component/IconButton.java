package com.lightning.animtb.component;

public class IconButton extends Button {
	public IconButton(Icon icon, Runnable whenClicked) {
		super(whenClicked, icon.width, icon.height);
		subComponents.add(icon);
	}
	
	public IconButton(Icon icon, Runnable whenClicked, int x, int y) {
		super(whenClicked, x, y, icon.width, icon.height);
		icon.x = x;
		icon.y = y;
		subComponents.add(icon);
	}
}
