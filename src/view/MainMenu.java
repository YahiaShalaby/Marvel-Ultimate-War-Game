package view;
import javax.swing.*;
import java.awt.event.*;
import controller.controller;

public class MainMenu extends JFrame implements MouseListener{
	JButton startGame;
	JButton instructions;
	JButton quit;
	public MainMenu() {
		this.setBounds(425,200,800,600);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("Main Menu");
		ImageIcon marvel = new ImageIcon("marvel.png");
		this.setIconImage(marvel.getImage());
		
        startGame=new JButton("Start Game");
        startGame.setBounds(20,200,200,50);
        startGame.addMouseListener(this);
        this.add(startGame);
        
        instructions=new JButton("Instructions");
        instructions.setBounds(20,250,200,50);
        instructions.addMouseListener(this);
        this.add(instructions);
        
        quit=new JButton("Quit");
        quit.setBounds(20,300,200,50);
        quit.addMouseListener(this);
        this.add(quit);
        
		JLabel background=new JLabel(new ImageIcon("StartUp.png"));
		background.setBounds(0,0,350,700);
        this.add(background);
        
		this.pack();
	    this.revalidate();
		this.repaint();
	}
	public JButton getstartGame() {
		return startGame;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==startGame) {
			dispose();
		}
		else if(e.getSource()==instructions) {
			dispose();
			//new instructions();
		}
		else if(e.getSource()==quit) {
			dispose();
		}
		
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
	new MainMenu();
}

}
