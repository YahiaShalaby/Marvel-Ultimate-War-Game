package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Studio2 extends JFrame implements MouseListener{
	private JLabel label;
	private JButton cont;
	public Studio2() {
		this.setBounds(300,100,1000,600);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.setTitle("Studio no.2");
		ImageIcon marvel = new ImageIcon("marvel.png");
        this.setIconImage(marvel.getImage());
        
        cont=new JButton("Continue");
        cont.setFont(new Font("Consolas",Font.BOLD,35));
        cont.setBounds(20,450,100,100);
        cont.addMouseListener(this);
        cont.setBackground(new Color(43,45,47));
        cont.setForeground(new Color(210,1,23));
        this.add(cont, BorderLayout.SOUTH);
		
		//JLabel background=new JLabel(new ImageIcon("Studio3.jpeg"));
        JLabel background=new JLabel(new ImageIcon("s&s studio.gif"));
		background.setBounds(0,0,350,700);
        this.add(background, BorderLayout.CENTER);
		
		//this.pack();
	    this.revalidate();
		this.repaint();

	}
	

public static void main(String[] args) {
	new Studio2();
}


@Override
public void mouseClicked(MouseEvent e) {
	dispose();
	//new MainMenu();//openMainMenu
	
}


@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}