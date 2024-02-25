package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import controller.controller;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.world.Direction;

public class GameView extends JFrame {
	private JPanel board;
	private JScrollPane currentScroll;
	private JTextArea currentDetails;
	private JPanel playerDetails;
	private JTextArea turnOrderDetails;
	private JPanel controls;
	private JPanel abilities;
	private JPanel attack;
	private JPanel move;
	private JLabel a = new JLabel();
	private JLabel b = new JLabel();
	
	public GameView() {
		this.setBounds(0,0,1200,750);		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Marvel Ultimate War");
		
		ImageIcon marvel = new ImageIcon("marvel.png");
        this.setIconImage(marvel.getImage());
        
        //Border border = BorderFactory.createLineBorder(Color.DARK_GRAY,3);       
		
		board = new JPanel();
		board.setPreferredSize(new Dimension(this.getWidth()-200,this.getHeight()-200));
		board.setLayout(new GridLayout(5,5));
		this.add(board,BorderLayout.CENTER);
		board.setBackground(new Color(10,69,69));
		
		playerDetails = new JPanel();
		playerDetails.setPreferredSize(new Dimension(this.getWidth()-200,100));
		playerDetails.setLayout(new GridLayout(0,2));
		playerDetails.setBackground(Color.DARK_GRAY);
		playerDetails.setForeground(Color.white);
		this.add(playerDetails, BorderLayout.NORTH);
		a.setForeground(new Color(222,23,56));
		
		a.setFont(new Font("Consolas",Font.BOLD,14));
		
		b.setForeground(new Color(70,102,255));
		b.setFont(new Font("Consolas",Font.BOLD,14));
		playerDetails.add(a);
		playerDetails.add(b);
		
				
		turnOrderDetails = new JTextArea();
		turnOrderDetails.setPreferredSize(new Dimension(this.getWidth()-200,100));
		turnOrderDetails.setEditable(false);
		turnOrderDetails.setBackground(Color.DARK_GRAY);
		turnOrderDetails.setForeground(Color.white);
		turnOrderDetails.setFont(new Font("Consolas",Font.PLAIN,12));
		this.add(turnOrderDetails, BorderLayout.SOUTH);
		turnOrderDetails.setText("Turn Order:");
		
		
		currentDetails = new JTextArea();
		currentDetails.setPreferredSize(new Dimension(200,this.getHeight()));
		currentDetails.setEditable(false);
		this.add(currentDetails, BorderLayout.EAST);
		currentDetails.setText(" Current Details:");
		currentScroll = new JScrollPane(currentDetails);
		currentDetails.setBackground(new Color(43,45,47));
		currentDetails.setForeground(Color.white);
		this.add(currentScroll, BorderLayout.EAST);
		
		controls = new JPanel();
		controls.setPreferredSize(new Dimension(200,this.getHeight()-200));
		controls.setLayout(new GridLayout(6,1)); //was 0,2
		this.add(controls,BorderLayout.WEST);
		//controls.setBackground(new Color(255,77,88));
		controls.setBackground(new Color(43,45,47));
		
		abilities = new JPanel();
		abilities.setPreferredSize(new Dimension(200,170));
		abilities.setLayout(new GridLayout(3,4));
		controls.add(abilities);
		abilities.setBackground(new Color(43,45,47));
		
		attack = new JPanel();
		attack.setPreferredSize(new Dimension(200,170));
		attack.setLayout(new BorderLayout());
		controls.add(attack);
		attack.setBackground(new Color(43,45,47));
		
		move = new JPanel();
		move.setPreferredSize(new Dimension(200,170));
		move.setLayout(new BorderLayout());
		controls.add(move);
		move.setBackground(new Color(43,45,47));
		

		
		
		
//		d = new JPanel();
//		d.setPreferredSize(new Dimension(200,170));
//		d.setLayout(new BorderLayout());
//		controls.add(d);
//		d.setBackground(Color.black);
		
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
	public JPanel getBoard() {
		return board;
	}
	public JTextArea getCurrentDetails() {
		return currentDetails;
	}
	public JPanel getPlayerDetails() {
		return playerDetails;
	}
	public JTextArea getTurnOrderDetails() {
		return turnOrderDetails;
	}
	public JTextArea getcurrentDetails() {
		return currentDetails;
	}
	public void setcurrentDetails(JTextArea currentDetails) {
		this.currentDetails = currentDetails;
	}
	public static void main(String[] args) {
		new GameView();
	}
	public JPanel getboard() {
		return board;
	}
	public JPanel getControls() {
		return controls;
	}
	public JPanel getAbilities() {
		return abilities;
	}
	public JPanel getAttack() {
		return attack;
	}
	public JPanel getMove() {
		return move;
	}
	public JLabel getA() {
		return a;
	}
	public JLabel getB() {
		return b;
	}
	
	


}
