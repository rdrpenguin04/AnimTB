package com.lightning.animtb.component.dialog;

import com.lightning.animtb.Icons;

public class AboutDialog extends OptionDialog {
	public AboutDialog() {
		super(Icons.IIcon, "Animator's Toolbox version 1.0 by Ray Redondo",
			new String[] {"Okay"},
			new Runnable[] {new Runnable(){public void run(){}}}
		);
		changeRunnables(getOptions());
	}
	
	private Runnable[] getOptions() {
		return new Runnable[] {
			new Runnable() {
				public void run() {
					removeThis();
				}
			}
		};
	}
}
