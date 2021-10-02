package bouncing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReboundPanel extends JPanel {
	private final int WIDTH = 600, HEIGHT = 400; 
	private final int DELAY = 10, IMAGE_SIZE = 10;
	private ImageIcon image; 
	private Timer timer; 
	private int x, y, moveX, moveY;
	
	
	//-----------------------------------------------------------------
	//  Sets up the panel, including the timer for the animation. 
	//-----------------------------------------------------------------
	public ReboundPanel() {
		timer = new Timer(DELAY, new ReboundListener()); 
		image = new ImageIcon("mcGG0RX.gif");
		x = 98; 
		y = 1; 
		moveX = moveY = 10;
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
		setBackground(Color.cyan); 
		timer.start(); 
	}
	
	//-----------------------------------------------------------------
	//  Draws the image in the current location. 
	//-----------------------------------------------------------------
	public void paintComponent(Graphics page) { 
		super.paintComponent(page); 
		image.paintIcon(this, page, x, y); 
	}
	
	private class ReboundListener implements ActionListener {
	//***************************************************************** 
	//  Represents the action listener for the timer. 
	//***************************************************************** 
	public void actionPerformed(ActionEvent event) { 
		//--------------------------------------------------------------
		//  Updates the position of the image and possibly the direction 
		//  of movement whenever the timer fires an action event. 
		//--------------------------------------------------------------
		x += moveX; 
		y += moveY;
		if (x <= 0 || x >= WIDTH-IMAGE_SIZE)
			moveX = moveX * -1;
		if (y <= 0 || y >= HEIGHT-IMAGE_SIZE) 
			moveY = moveY * -1;
		repaint(); 
		} 
	}
}
