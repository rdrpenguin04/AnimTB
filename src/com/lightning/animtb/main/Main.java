package com.lightning.animtb.main;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;

import com.lightning.animtb.component.Component;
import com.lightning.animtb.component.dialog.Dialog;
import com.lightning.animtb.component.dialog.WindowCloseDialog;
import com.lightning.animtb.util.Logger;

public class Main {
	public static BufferedImage display = new BufferedImage(960, 540, BufferedImage.TYPE_3BYTE_BGR);
	private static BufferedImage display2 = new BufferedImage(960, 540, BufferedImage.TYPE_3BYTE_BGR);
	private static ImageIcon displayIcon;
	private static JLabel displayLabel;
	
	private static boolean dialogOpen = false;
	public static Stack<Component> objectStack = new Stack<>();
	
	public static int width = 960, height = 540;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Logger.getLogger().println("Animator's Toolbox 1.0");
		Logger.getLogger().println("Starting...");
		JFrame frame = new JFrame("Animator's Toolbox");
		frame.add(displayLabel = new JLabel(displayIcon = new ImageIcon(display2)));
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				width = evt.getComponent().getWidth();
				height = evt.getComponent().getHeight();
				display = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
				display2 = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
				displayIcon.setImage(display2);
			}
		});
		//frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.pack();
		frame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent windowEvent) {
		        dialogOpen = true;
		        objectStack.push(new WindowCloseDialog());
		    }
		});
		displayLabel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {
				int mouseX = e.getX();
				int mouseY = e.getY();
				
				for(Component c : objectStack) {
					if(mouseX >= c.x && mouseX < c.width + c.x && mouseY >= c.y && mouseY < c.height + c.y) {
						c.mousePressed(mouseX, mouseY);
						break;
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				int mouseX = e.getX();
				int mouseY = e.getY();
				
				for(Component c : objectStack) {
					if(mouseX >= c.x && mouseX < c.width + c.x && mouseY >= c.y && mouseY < c.height + c.y) {
						c.mouseReleased(mouseX, mouseY);
						break;
					}
				}
			}
		});
		frame.setVisible(true);
		width = frame.getWidth();
		height = frame.getHeight();
		
		long lastTime = System.currentTimeMillis();
		
		while(frame.isVisible()) {
			for(int i = 0; i < objectStack.size(); i++) {
				Component c = objectStack.elementAt(objectStack.size() - i - 1);
				c.render(!(c instanceof Dialog) && i != 0 && dialogOpen);
			}
			
			display2.getGraphics().drawImage(display, 0, 0, null);
			frame.repaint();
			display.getGraphics().clearRect(0, 0, width, height);
			
			long curTime = System.currentTimeMillis();
			while(curTime - 50 < lastTime) {
				Thread.yield();
				curTime = System.currentTimeMillis();
			}
			lastTime = curTime;
		}
	}
	
	public static boolean cleanup() {
		// Will check for saving etc.
		return true;
	}
}
