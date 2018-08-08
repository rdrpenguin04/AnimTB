package com.lightning.animtb.component.dialog;

import com.lightning.animtb.Icons;
import com.lightning.animtb.main.Main;

public class WindowCloseDialog extends OptionDialog {
	public WindowCloseDialog() {
		super(Icons.warningIcon, "Are you sure you want to exit?",
			new String[] {"Yes", "No"},
			new Runnable[] {new Runnable(){public void run(){}},new Runnable(){public void run(){}}}
		);
		changeRunnables(getOptions());
	}
	
	private Runnable[] getOptions() {
		return new Runnable[] {
			new Runnable() {
				public void run() {
					if(Main.cleanup()) System.exit(0);
				}
			},
			new Runnable() {
				public void run() {
					removeThis();
				}
			}
		};
	}
}
