package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.controller;

public class Player1Selection extends JFrame{
	private JPanel characters;
	private JLabel name;
	private JTextArea details;
	public Player1Selection() {
		this.setBounds(0,0,1200,750);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon marvel = new ImageIcon("marvel.png");
		this.setIconImage(marvel.getImage());
		this.setTitle("CHOOSE CHAMPIONS");
		characters = new JPanel();
		characters.setPreferredSize(new Dimension(600,this.getHeight()));
		characters.setLayout(new GridLayout(0,3));
		characters.setBackground(Color.DARK_GRAY);
		this.add(characters,BorderLayout.CENTER);
		
		name = new JLabel();
		name.setText("   CHOOSE YOUR CHAMPIONS");
		name.setFont(new Font("Consolas",Font.ITALIC,80));
		name.setForeground(new Color(236,29,36));
		this.add(name,BorderLayout.NORTH);
		
		details = new JTextArea();
		details.setPreferredSize(new Dimension(200,this.getHeight()));
		details.setEditable(false);
		this.add(details, BorderLayout.EAST);
		details.setText("Details:");
		details.setBackground(new Color(197,199,196));
		
		
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
	public JTextArea getDetails() {
		return details;
	}
	public void setDetails(JTextArea details) {
		this.details = details;
	}
	public static void main(String[] args) {
		new Player1Selection();
	}
	public JPanel getCharacters() {
		return characters;
	}

}
