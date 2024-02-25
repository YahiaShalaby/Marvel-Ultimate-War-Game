package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;


public class WinningScreen extends JFrame implements MouseListener{
	JButton exit;
	JLabel winner;
	public WinningScreen() {
		this.setBounds(425,200,800,600);
		this.setVisible(false);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("GAME OVER");
		ImageIcon marvel = new ImageIcon("marvel.png");
		this.setIconImage(marvel.getImage());
        exit=new JButton("EXIT");
        exit.setBounds(20,275,275,100);
        exit.addMouseListener(this);
        this.add(exit);
        
        winner=new JLabel();
        winner.setBounds(20,100,275,100);
        winner.setText("LOL LOL");
        winner.setForeground(new Color(255,255,255));
        this.add(winner);
        
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\Yahia Shalaby\\Downloads\\StartUp.jpg"));
		background.setBounds(0,0,350,700);
        this.add(background);
        
		this.pack();
	    this.revalidate();
		this.repaint();
	}
	
	public JLabel getWinner() {
		return winner;
	}

	public JButton getexit() {
		return exit;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		dispose ();
		
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
	new WinningScreen();
}

}
