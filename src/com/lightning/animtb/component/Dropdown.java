package com.lightning.animtb.component;

import com.lightning.animtb.main.Main;

public class Dropdown extends Component {
	public Dropdown(int x, int y, DropButton[] choices) {
		super(x, y, choiceWidth(choices), choices.length*16);
		for(int i = 0; i < choices.length; i++) {
			choices[i].x = x;
			choices[i].y = y + i * 16;
			choices[i].parent = this;
			subComponents.add(choices[i]);
		}
	}
	
	private static final int choiceWidth(DropButton[] choices) {
		int maxWidth = 0;
		for(int i = 0; i < choices.length; i++)
			if(maxWidth < choices[i].width)
				maxWidth = choices[i].width;
		return maxWidth;
	}

	private boolean wasDown = false;
	private boolean wasDown2 = false;
	
	public void renderThis() {
		if(Main.mouseDown && !wasDown)
			wasDown = true;
		else if(wasDown && !Main.mouseDown)
			wasDown2 = true;
		else if(wasDown2)
			removeThis();
	}

	public boolean mousePressedThis(int mouseX, int mouseY, int button) { return false; }

	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) { return false; }
}
