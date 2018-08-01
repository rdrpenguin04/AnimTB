package com.lightning.animtb.component;

public class DropButton extends TextButton implements Runnable {
	private Runnable realWhenClicked;
	Dropdown parent;
	
	public DropButton(String text, Runnable whenClicked) {
		super(text, whenClicked);
		super.whenClicked = this;
		realWhenClicked = whenClicked;
		width = text.length()*8;
		height = 16;
		subComponents.get(0).x -= 4;
		subComponents.get(0).y -= 4;
	}
	
	public void renderThis() {
		if(subComponents.get(0).x != x) subComponents.get(0).x = x;
		if(subComponents.get(0).y != y) subComponents.get(0).y = y;
		super.renderThis();
	}
	
	public void run() {
		realWhenClicked.run();
		parent.removeThis();
	}
}
