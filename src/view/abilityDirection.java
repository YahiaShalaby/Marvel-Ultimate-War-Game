package view;

import javax.swing.*;

import model.abilities.AreaOfEffect;
import model.world.Direction;

import java.awt.*;
import java.awt.Color;

import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class abilityDirection extends JFrame implements ActionListener{
	private JButton up;
	private JButton down;
	private JButton left;
	private JButton right;
	private JButton done;
	private boolean flag =false;
	Direction direction;
	public abilityDirection() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(new BorderLayout());
		this.setBounds(0,0,400,300); 
		this.setTitle("abilityDirections");
		ImageIcon marvel = new ImageIcon("marvel.png");
		this.setIconImage(marvel.getImage());
		
//		JLabel background=new JLabel(new ImageIcon("C:\\abilityDirections\\Yahia Shalaby\\Downloads\\Startup.jpg"));
//		background.setBounds(0,0,350,700);
//        this.add(background);

		up = new JButton("UP");
		up.addActionListener(this);	
		up.setPreferredSize(new Dimension(this.getWidth(),100));
		
		down = new JButton("DOWN");
		down.addActionListener(this);
		down.setPreferredSize(new Dimension(this.getWidth(),100));
		
		left = new JButton("LEFT");
		left.addActionListener(this);
		left.setPreferredSize(new Dimension(200,100));
		
		right = new JButton("RIGHT");
		right.addActionListener(this);
		right.setPreferredSize(new Dimension(200,100));
		
//		done = new JButton("O");
//		done.addMouseListener(this);
//		done.setPreferredSize(new Dimension(50,50));
		
		this.add(up, BorderLayout.NORTH);
		this.add(down, BorderLayout.SOUTH);
		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
		//this.add(done, BorderLayout.CENTER);
		
		//this.pack();
		this.setVisible(true);
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==up ) {
			direction= Direction.DOWN;
			dispose();
		}
		if(e.getSource()==down ) {
			direction=Direction.UP;
			dispose();
		} if(e.getSource()==left ) {
			direction= Direction.LEFT;
			dispose();
		} if(e.getSource()==right ) {
			direction= Direction.RIGHT;
			dispose();
		}
	}

	public Direction getDirection() {
		return direction;
	}
	public Direction getD() {
		for(int i=0;i<10000000;i++) {
			if(this.getDirection()!=null)
				return this.getDirection();
		}
		return null;
	}

	public static void main(String[] args) {
		abilityDirection a =new abilityDirection();
		for(int i=0;i<10000000;i++) {
			System.out.println(i);
			if(a.getDirection()!=null)
				break;
		}
		System.out.println(a.getDirection());
	}






}
