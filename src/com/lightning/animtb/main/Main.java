package com.lightning.animtb.main;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;

import com.lightning.animtb.component.Component;
import com.lightning.animtb.component.MenuBar;
import com.lightning.animtb.component.Scene;
import com.lightning.animtb.component.dialog.WindowCloseDialog;
import com.lightning.animtb.util.Logger;

public class Main {
	public static BufferedImage display = new BufferedImage(960, 540, BufferedImage.TYPE_3BYTE_BGR);
	private static BufferedImage display2 = new BufferedImage(960, 540, BufferedImage.TYPE_3BYTE_BGR);
	private static ImageIcon displayIcon;
	private static JLabel displayLabel;
	private static JFrame frame;
	private static boolean icon = false;
	public static Stack<Component> objectStack = new Stack<>();
	public static ArrayList<Component> toRemove = new ArrayList<>();
	public static boolean mouseDown = false;
	
	public static int width = 960, height = 540;
	
	public static final Main singleThreadLock = new Main();
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Logger.getLogger().println("Animator's Toolbox 1.0");
		Logger.getLogger().println("Starting...");
		frame = new JFrame("Animator's Toolbox");
		frame.add(displayLabel = new JLabel(displayIcon = new ImageIcon(display2)));
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				synchronized(singleThreadLock) {
					width = evt.getComponent().getWidth();
					height = evt.getComponent().getHeight();
					display = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
					display2 = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
					displayIcon.setImage(display2);
				}
			}
		});
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent windowEvent) {
				icon = true;
			}
			
			public void windowDeiconified(WindowEvent windowEvent) {
				icon = false;
			}
			
			public void windowClosing(WindowEvent windowEvent) {
				synchronized(singleThreadLock) {
					objectStack.push(new WindowCloseDialog());
				}
		    }
		});
		displayLabel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {
				synchronized(singleThreadLock) {
					mouseDown = true;
					int mouseX = e.getX();
					int mouseY = e.getY();
					int button = e.getButton();
	
					for(int i = 0; i < objectStack.size(); i++) {
						Component c = objectStack.get(objectStack.size() - i - 1);
						if(mouseX >= c.x && mouseX < c.width + c.x && mouseY >= c.y && mouseY < c.height + c.y) {
							c.mousePressed(mouseX, mouseY, button);
							break;
						}
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				synchronized(singleThreadLock) {
					mouseDown = false;
					int mouseX = e.getX();
					int mouseY = e.getY();
					int button = e.getButton();
					
					for(int i = 0; i < objectStack.size(); i++) {
						Component c = objectStack.get(objectStack.size() - i - 1);
						if(mouseX >= c.x && mouseX < c.width + c.x && mouseY >= c.y && mouseY < c.height + c.y) {
							if(c.mouseReleased(mouseX, mouseY, button)) break;
						}
					}
				}
			}
		});

	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.pack();
		frame.setVisible(true);

		objectStack.push(new Scene());
		objectStack.push(new MenuBar());
		
		long lastTime = System.currentTimeMillis();
		
		while(frame.isVisible()) {
			synchronized(singleThreadLock) {
			    if(!icon) frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				for(Component c : objectStack) {
					c.render();
				}
				
				display2.getGraphics().drawImage(display, 0, 0, null);
				frame.repaint();
				width = frame.getWidth();
				height = frame.getHeight();
				display.getGraphics().clearRect(0, 0, width, height);
				for(Component c : toRemove) {
					objectStack.remove(c);
				}
			}
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
	
	public static void minimize() {
		frame.setState(JFrame.ICONIFIED);
	}
	
	public static void newProject() {
		// Will do later
	}
	
	public static void sendCloseSignal() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
