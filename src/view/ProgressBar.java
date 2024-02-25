package view;

import java.awt.*;
import javax.swing.*;
import model.world.Champion;
import engine.Game;
public class ProgressBar {

	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar(0,100);
	
	ProgressBar(){
		
		bar.setValue(100);
		bar.setBounds(0,0,420,50);
		bar.setStringPainted(true);
		bar.setFont(new Font("MV Boli",Font.BOLD,25));
		bar.setForeground(Color.blue);
		bar.setBackground(Color.black);
			
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		fill();
	}
	
	public void fill() {
		//Champion c=getCurrentChampion();
		int counter =100;
		
		while(counter>0) {
			
			bar.setValue(counter);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			counter -=1;
		}
		bar.setString("Done! :)");
	}
}
