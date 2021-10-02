package counter;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class PushCounterPanel extends JPanel {
	
	private JTextField points;
	private ButtonListener listener;
	private JLabel pLabel;
	
	private JButton out;
	private JLabel oLabel;
	
	private int count; 
	private JButton push; 
	private JLabel label;
	
	public PushCounterPanel () {
		
		count = 0;
		push = new JButton ("Push Me For More!"); 
		push.addActionListener (new ButtonListener());
		label = new JLabel ("Pushes: " + count);
		pLabel = new JLabel ("Letter Grade: ");
		points = new JTextField(5);
		points.addActionListener(listener);
		
		out = new JButton("DO NOT PRESS");
		out.addActionListener(new ButtonListener());
		oLabel = new JLabel("LETS GET OUT OF HERE!");
		
		add (out);
		add (oLabel);
		
		add (push); 
		add (label);
		add (points);
		add (pLabel);
		
		setPreferredSize (new Dimension(300,100)); 
		setBackground (Color.blue); 
	}

	private class ButtonListener implements ActionListener { 
		public void actionPerformed (ActionEvent event) 
		{
			if (event.getSource()==push){
				count+=1; 
				label.setText("Pushes: " + count);
			}
			else if (event.getSource()==out){
				oLabel.setText("TIME TO GO!");
			}
			else{
				String p = points.getText();
				int pp = Integer.parseInt(p);
				String letter_grade="";
				if(pp>=90){
					letter_grade = "A";
				}
				else if (pp>=80){
					letter_grade="B";
				}
				else if (pp>=70){
					letter_grade="C";
				}
				else{
					letter_grade="F";
				}
				pLabel.setText("You earned a " + letter_grade);
			}
		} 
	} 
	
}
