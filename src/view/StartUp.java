package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;
import java.awt.*;


public class StartUp extends JFrame implements MouseListener{
	JButton play;
	JButton name;
	public StartUp() {
		this.setBounds(425,200,800,600);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Start Up");
		ImageIcon marvel = new ImageIcon("marvel.png");
		//ImageIcon playbutton = new ImageIcon("Startup cont 2.jpg");
		this.setIconImage(marvel.getImage());
		
		Border border = BorderFactory.createLineBorder(Color.black,1);
		
        play=new JButton("Play");
        play.setFont(new Font("Consolas",Font.BOLD,35));
        play.setBounds(20,200,200,100);
        play.setBackground(new Color(43,45,47));
        play.setForeground(new Color(106,13,173));
        play.addMouseListener(this);
       // play.setIcon(playbutton);
        play.setBorder(border);
        this.add(play,BorderLayout.SOUTH);
        
        name = new JButton();
        name.setText("MARVEL ULTIMATE WAR");
        name.setFont(new Font("Consolas",Font.BOLD,35));
        name.setBounds(20,200,200,100);
        name.setBackground(Color.black);
        name.setForeground(new Color(106,13,173));
        name.setBorder(border);
        this.add(name,BorderLayout.NORTH);
        
        
        
        ImageIcon startup = new ImageIcon("Startup.jpg");
		JLabel background=new JLabel();
		background.setIcon(startup);
		background.setBounds(0,0,350,700);
        this.add(background,BorderLayout.CENTER);
        
		this.pack();
	    this.revalidate();
		this.repaint();
	}
	public JButton getPlay() {
		return play;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		dispose ();
		//new Studio();
		
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
	public static void main(String[] args) {
	new StartUp();
}

}
