package com.lightning.animtb.component;

public class DummyParent extends Dropdown {
	public DummyParent() {
		super(0, 0, new DropButton[0]);
	}
	
	public void renderThis() {}

	public boolean mousePressedThis(int mouseX, int mouseY, int button) {return false;}

	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) {return false;}
	
	public void removeThis() {}
}
