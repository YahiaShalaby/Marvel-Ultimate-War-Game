package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.Color;

import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class User extends JFrame implements ActionListener, MouseListener{
	JButton button1;
	JButton button2;
	JTextField textField;
	JTextField textField1;
	private String firstPlayerName;
	private String secondPlayerName;
	private JButton cont;
	private JLabel label;
	public User() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//this.setLayout(new GridLayout(3,2));
		this.setLayout(new BorderLayout());
		this.setBounds(0,0,1200,750);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setTitle("Users");
		ImageIcon marvel = new ImageIcon("marvel.png");
		this.setIconImage(marvel.getImage());
		
		 Border redB = BorderFactory.createLineBorder(new Color(210,1,23),3);
		 Border blueB = BorderFactory.createLineBorder(new Color(39,81,185),3);
		
		
		ImageIcon bg = new ImageIcon("userBG.jpg");
		label = new JLabel();
		label.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
		label.setIcon(bg);
		label.setLayout(new FlowLayout());
		this.add(label,BorderLayout.CENTER);
		
		
		//ImageIcon contB = new ImageIcon("Continue Button.jpeg");
		
//		JLabel background=new JLabel(new ImageIcon("C:\\Users\\Yahia Shalaby\\Downloads\\Startup.jpg"));
//		background.setBounds(0,0,350,700);
//        this.add(background);

		ImageIcon button = new ImageIcon("play.png");
		button1 = new JButton("Submit");
		button1.addActionListener(this);
		button1.setBackground(new Color(210,1,23));
		button1.setForeground(new Color(0xD3D3D3));
		button1.setPreferredSize(new Dimension(467,100));
		button1.setIcon(button);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(300,60));
		textField.setFont(new Font("Consolas",Font.PLAIN,35));
		textField.setForeground(new Color(0xD3D3D3));
		textField.setBackground(new Color(210,1,23));
		textField.setCaretColor(Color.black);
		textField.setText("Player 1 name");
		textField.setBorder(redB);
//		
//		button2 = new JButton("Submit");
//		button2.addActionListener(this);
//		button2.setBackground(new Color(39,81,185));
//		button2.setForeground(new Color(0xD3D3D3));
		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(300,60));
		textField1.setFont(new Font("Consolas",Font.PLAIN,35));
		textField1.setForeground(new Color(0xD3D3D3));
		textField1.setBackground(new Color(39,81,185));
		textField1.setCaretColor(Color.white);
		textField1.setText("Player 2 name");
		textField1.setBorder(blueB);
//		
		label.add(textField);
		label.add(button1);
		label.add(textField1);
		
//		this.add(button2);
//		
//		 cont=new JButton();
//		 cont.setIcon(contB);
//	     cont.setBounds(20,300,275,100);
//	     cont.setBackground(new Color(0,0,0));
//	     cont.addMouseListener(this);
//          this.add(cont);
//		//this.pack();
		this.setVisible(true);
		this.revalidate();
		this.repaint();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource()==button1 ) {
			firstPlayerName=textField.getText();

		//}
		//if(e.getSource()==button2 ) {
			secondPlayerName=textField1.getText();
		//}
			dispose();

	}
	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField1() {
		return textField1;
	}

	public JButton getButton1() {
		return button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public String getFirstPlayerName() {
		return firstPlayerName;
	}

	public void setFirstPlayerName(String firstPlayerName) {
		this.firstPlayerName = firstPlayerName;
	}

	public String getSecondPlayerName() {
		return secondPlayerName;
	}

	public void setSecondPlayerName(String secondPlayerName) {
		this.secondPlayerName = secondPlayerName;
	}
	public static void main(String[] args) {
		new User();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		dispose();
		
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
