package basic;

import java.awt.*;
import javax.swing.*;

public class Display {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("Label Demo"); 
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon ("img1.gif"); 
		JLabel label1, label2, label3;
		
		label1 = new JLabel ("Circles", icon, SwingConstants.CENTER);
		
		label2 = new JLabel ("Circles Right", icon, SwingConstants.CENTER); 
		label2.setHorizontalTextPosition (SwingConstants.LEFT); 
		label2.setVerticalTextPosition (SwingConstants.BOTTOM);
		
		label3 = new JLabel ("Circles Above", icon, SwingConstants.CENTER); 
		label3.setHorizontalTextPosition (SwingConstants.CENTER); 
		label3.setVerticalTextPosition (SwingConstants.BOTTOM);
		
		JPanel panel = new JPanel(); 
		panel.setBackground (Color.cyan); 
		panel.setPreferredSize (new Dimension (1500, 900)); 
		
		panel.add (label1); 
		panel.add (label2); 
		panel.add (label3);
		
		frame.getContentPane().add(panel); 
		frame.pack(); 
		frame.setVisible(true); 
		
	}

}
