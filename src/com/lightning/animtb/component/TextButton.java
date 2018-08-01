package com.lightning.animtb.component;

public class TextButton extends Button {
	public TextButton(String text, Runnable whenClicked) {
		super(whenClicked, Math.max(text.length()*8, 56)+8, 24);
		if(text.length()*8 > 64) {
			subComponents.add(new Text(text, x+4, y+4));
		} else {
			subComponents.add(new Text(text, x+32-text.length()*4, y+4));
		}
	}
	
	public TextButton(String text, Runnable whenClicked, int x, int y) {
		super(whenClicked, x, y, Math.max(text.length()*8, 56)+8, 24);
		if(text.length()*8 > 64) {
			subComponents.add(new Text(text, x+4, y+8));
		} else {
			subComponents.add(new Text(text, x+32-text.length()*4, y+4));
		}
	}
}
