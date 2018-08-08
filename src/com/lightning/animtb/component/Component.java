package com.lightning.animtb.component;

import java.util.ArrayList;

import com.lightning.animtb.main.Main;

public abstract class Component {
	public int x, y, width, height;
	
	public Component(int width, int height) {
		x = Main.width/2 - width/2;
		y = Main.height/2 - height/2;
		this.width = width;
		this.height = height;
	}
	
	public Component(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	protected ArrayList<Component> subComponents = new ArrayList<>();
	
	public final void render() {
		renderThis();
		for(int i = 0; i < subComponents.size(); i++) {
			Component c = subComponents.get(subComponents.size() - i - 1);
			c.render();
		}
		renderThisPost();
	}

	public abstract void renderThis();
	public void renderThisPost() {}
	
	public final boolean mousePressed(int mouseX, int mouseY, int button) {
		boolean handled = false;
		for(Component c : subComponents) {
			if(mouseX >= c.x && mouseX < c.width + c.x && mouseY >= c.y && mouseY < c.height + c.y) {
				if(handled = c.mousePressed(mouseX, mouseY, button)) break;
			}
		}
		return handled || mousePressedThis(mouseX, mouseY, button); // ;)
	}
	
	public abstract boolean mousePressedThis(int mouseX, int mouseY, int button);
	
	public final boolean mouseReleased(int mouseX, int mouseY, int button) {
		boolean handled = false;
		for(Component c : subComponents) {
			if(mouseX >= c.x && mouseX < c.width + c.x && mouseY >= c.y && mouseY < c.height + c.y) {
				if(handled = c.mouseReleased(mouseX, mouseY, button)) break;
			}
		}
		return handled || mouseReleasedThis(mouseX, mouseY, button); // ;)
	}
	
	public abstract boolean mouseReleasedThis(int mouseX, int mouseY, int button);
	
	private Component parent = null;
	
	public final void setParent(Component parent) {
		this.parent = parent;
	}
	
	public final void removeThis() {
		if(parent != null) {
			parent.subComponents.remove(this);
		} else {
			Main.objectStack.remove(this);
		}
	}
}
