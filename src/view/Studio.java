package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Studio extends JFrame implements MouseListener{
	private JLabel background;
	private JButton cont;
	public Studio() {
		this.setBounds(400,100,800,600);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		this.setTitle("Studio no.1");
		ImageIcon marvel = new ImageIcon("marvel.png");
        this.setIconImage(marvel.getImage());
		
        cont=new JButton("Continue");
        cont.setFont(new Font("Consolas",Font.BOLD,35));
        cont.setBounds(20,300,275,600);
        cont.addMouseListener(this);
        cont.setBackground(new Color(43,45,47));
        cont.setForeground(new Color(255,137,1));
        this.add(cont, BorderLayout.SOUTH);
        
	   // background=new JLabel(new ImageIcon("ZeinaBusStudios.jpg"));
        background=new JLabel(new ImageIcon("zb studio.gif"));
		background.setBounds(0,0,this.getWidth(),this.getHeight());
        this.add(background,BorderLayout.CENTER);
		
		this.pack();
	    this.revalidate();
		this.repaint();

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
	new Studio();
}
}

