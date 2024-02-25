package view;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;


public class ExceptionMessage extends JFrame{
	JLabel pic;
	public ExceptionMessage() {
		this.setBounds(450,70,640,680);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		this.setTitle("UO-OH");
		ImageIcon marvel = new ImageIcon("marvel.png");
		this.setIconImage(marvel.getImage());
		ImageIcon exception = new ImageIcon("Exception.jpg");
        
		pic = new JLabel();
		pic.setIcon(exception);
		this.add(pic);
		pic.setVerticalTextPosition(pic.BOTTOM);
		pic.setHorizontalTextPosition(pic.CENTER);
		pic.setFont(new Font("Consolas",Font.BOLD,15));
		//this.pack();
	    this.revalidate();
		this.repaint();
	}
	public JLabel getMessage() {
		return pic;
	}
	public static void main(String[] args) {
		new ExceptionMessage();
	}


}
