package com.lightning.animtb.component.dialog;

import java.awt.image.BufferedImage;

import com.lightning.animtb.component.TextButton;
import com.lightning.animtb.component.Icon;
import com.lightning.animtb.component.Text;

public class OptionDialog extends Dialog {
	public OptionDialog(BufferedImage icon, String mainText, String[] options, Runnable[] whenClicked) {
		super(Math.max(12+icon.getWidth(null)+mainText.length()*8,widthOfOptions(options)),36+icon.getHeight(null));
		subComponents.add(new Icon(icon, x+4, y+4));
		subComponents.add(new Text(mainText, x+8+icon.getWidth(null), y-4+icon.getHeight(null)/2));
		int totalWidth = 4;
		for(int i = 0; i < options.length; i++) {
			subComponents.add(new TextButton(options[i], whenClicked[i], x+totalWidth, y+8+icon.getHeight(null)));
			totalWidth += Math.max(options[i].length()*8, 56) + 16;
		}
	}
	
	private static int widthOfOptions(String[] options) {
		int total = 4;
		for(String s : options) {
			total += Math.max(s.length()*8, 56) + 16;
		}
		return total;
	}

	public void renderThis() {
		super.renderThis();
	}

	public boolean mousePressedThis(int mouseX, int mouseY, int button) {return false;}
	
	public boolean mouseReleasedThis(int mouseX, int mouseY, int button) {return false;}
	
	public void changeRunnables(Runnable[] newWhenClicked) {
		for(int i = 0; i < newWhenClicked.length; i++) {
			((TextButton)subComponents.get(i+2)).whenClicked = newWhenClicked[i];
		}
	}
}
