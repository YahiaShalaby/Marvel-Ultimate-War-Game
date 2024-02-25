package controller;
import java.io.IOException;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.effects.Effect;
import model.effects.Shock;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;
import view.*;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class controller implements MouseListener{
	private Game game;
	private Player1Selection p1;////player selection screen
	private Player fp;////first player
	private Player sp;////second player
	private User users;
	private StartUp startUp;//// startup page
	private Studio studio;//// zeina bus studios
	private Studio2 studio2;//// shalaby & shakib studios
	private MainMenu mainMenu;
	private GameView GameView;
	private WinningScreen WinningScreen;
	private ExceptionMessage expMessage;
	private JPanel d;
	private JPanel st;
	private ArrayList<Champion> gameChamps;
	private ArrayList<JButton> buttons;
	private ArrayList<JButton> boardButtons;
	private ArrayList<Point> pointList;
	private int count;
	private boolean turnOver;
	private boolean firstTurn = true;
	private JButton up;
	private JButton down;
	private JButton right;
	private JButton left;
	private JButton attUp;
	private JButton attDown;
	private JButton attRight;
	private JButton attLeft;
	private JButton ability1;
	private JButton ability2;
	private JButton ability3;
	private JButton LeaderAbility;
	private JButton endTurn;
	private JButton abU;
	private JButton abD;
	private JButton abL;
	private JButton abR;
	private JButton abC;
	private JButton st1;
	private JButton st2;
	private JButton st3;
	private Point targetPoint;
	private boolean ability1Used;
	private boolean ability2Used;
	private boolean ability3Used;
	//////////////////////////////////////////////////
	ImageIcon strange = new ImageIcon("Dr Strange.jpg");
	ImageIcon CA = new ImageIcon("Captain America.jpg");	
	ImageIcon DP = new ImageIcon("Deadpool.jpg");
	ImageIcon Electro = new ImageIcon("Electro.jpg");
	ImageIcon GR = new ImageIcon("Ghost Rider.jpg");
	ImageIcon Hela = new ImageIcon("Hela.jpg");
	ImageIcon Hulk = new ImageIcon("Hulk.jpg");
	ImageIcon IM = new ImageIcon("Iceman.jpg");
	ImageIcon IronMan = new ImageIcon("Iron Man.jpg");
	ImageIcon QS = new ImageIcon("QuickSilver.jpg");
	ImageIcon SM = new ImageIcon("Spiderman.jpg");
	ImageIcon Venom = new ImageIcon("Venom.jpg");
	ImageIcon YJ = new ImageIcon("Yellow Jacket.jpg");
	ImageIcon Thor = new ImageIcon("Thor.jpeg");
	ImageIcon Loki = new ImageIcon("Loki.jpeg");
	ImageIcon test = new ImageIcon("mrvl.gif");
	
	ImageIcon ds = new ImageIcon("ds.png");
	ImageIcon ca = new ImageIcon("ca.png");
	ImageIcon dp = new ImageIcon("dp.png");
	ImageIcon electro = new ImageIcon("electro.png");
	ImageIcon gr = new ImageIcon("gr.png");
	ImageIcon hela = new ImageIcon("hela.png");
	ImageIcon hulk = new ImageIcon("hulk.png");
	ImageIcon im = new ImageIcon("im.png");
	ImageIcon iceman = new ImageIcon("iceman.png");
	ImageIcon qs = new ImageIcon("qs.png");
	ImageIcon sm = new ImageIcon("sm.png");
	ImageIcon venom = new ImageIcon("venom.png");
	ImageIcon yj = new ImageIcon("yj.png");
	ImageIcon thor = new ImageIcon("thor.png");
	ImageIcon loki = new ImageIcon("loki.png");
	//////////////////////////////////////////////////

	ImageIcon cover = new ImageIcon("Cover.png");
    ImageIcon sword = new ImageIcon("sword.png");
    Border Lborder = BorderFactory.createLineBorder(Color.yellow,7);
    Border t1border = BorderFactory.createLineBorder(Color.red,7);
    Border t2border = BorderFactory.createLineBorder(Color.blue,7);
    Border loadborder = BorderFactory.createLineBorder(Color.black,6);

	

	

	
	public controller() throws IOException, NotEnoughResourcesException, UnallowedMovementException {
		startUp = new StartUp();
		while(startUp.isVisible()) {
			System.out.println("");
		}
		studio = new Studio();
		while(studio.isVisible()) {         //////////Start up & Studios
			System.out.println("");
		}
		studio2 = new Studio2();
		while(studio2.isVisible()) {
			System.out.println("");
		}
		
		
		users = new User();
		while(users.isVisible()) {
			System.out.println("");
		}
		fp = new Player(users.getFirstPlayerName());
		sp = new Player(users.getSecondPlayerName());
		game = new Game(fp,sp);
		count=0;
		p1 = new Player1Selection();
		buttons = new ArrayList<JButton>();
		boardButtons =  new ArrayList<JButton>();
		pointList = new ArrayList<Point>();
		game.loadAbilities("Abilities.csv");
		game.loadChampions("Champions.csv");
		for(int i=0;i < game.getAvailableChampions().size();i++) {
			JButton b = new JButton();
			b.setBackground(Color.DARK_GRAY);
			b.addMouseListener(this);
			//b.setText(game.getAvailableChampions().get(i).getName());
			buttons.add(b);
			if(game.getAvailableChampions().get(i).getName().equals("Dr Strange"))
				b.setIcon(strange);
			else if(game.getAvailableChampions().get(i).getName().equals("Captain America"))
				b.setIcon(CA);
			else if(game.getAvailableChampions().get(i).getName().equals("Deadpool"))
				b.setIcon(DP);
			else if(game.getAvailableChampions().get(i).getName().equals("Electro"))
				b.setIcon(Electro);
			else if(game.getAvailableChampions().get(i).getName().equals("Ghost Rider"))
				b.setIcon(GR);
			else if(game.getAvailableChampions().get(i).getName().equals("Hela"))
				b.setIcon(Hela);
			else if(game.getAvailableChampions().get(i).getName().equals("Hulk"))
				b.setIcon(Hulk);
			else if(game.getAvailableChampions().get(i).getName().equals("Iceman"))
				b.setIcon(IM);
			else if(game.getAvailableChampions().get(i).getName().equals("Ironman"))
				b.setIcon(IronMan);
			else if(game.getAvailableChampions().get(i).getName().equals("Quicksilver"))
				b.setIcon(QS);
			else if(game.getAvailableChampions().get(i).getName().equals("Spiderman"))
				b.setIcon(SM);
			else if(game.getAvailableChampions().get(i).getName().equals("Venom"))
				b.setIcon(Venom);
			else if(game.getAvailableChampions().get(i).getName().equals("Yellow Jacket"))
				b.setIcon(YJ);
			else if(game.getAvailableChampions().get(i).getName().equals("Thor"))
				b.setIcon(Thor);
			else if(game.getAvailableChampions().get(i).getName().equals("Loki"))
				b.setIcon(Loki);
			b.setBorder(loadborder);
			p1.getCharacters().add(b);
		}
		p1.revalidate();
		p1.repaint();
		while(p1.isVisible()) {
			System.out.println("");
		}
		
		game.placeChampions();
		game.prepareChampionTurns();
		GameView = new GameView();
		updateDetails();
		Object[][] boardTemp = game.getBoard();
		PriorityQueue turnOrder = game.getTurnOrder();
		WinningScreen = new WinningScreen();
		up = new JButton();up.setText("^");
		down = new JButton();down.setText("-");
		left = new JButton();left.setText("<");
		right = new JButton();right.setText(">");
		up.setBackground(new Color(249, 254, 255));
		down.setBackground(new Color(249, 254, 255));
		left.setBackground(new Color(249, 254, 255));
		right.setBackground(new Color(249, 254, 255));
		LeaderAbility=new JButton();LeaderAbility.setText("O");
		LeaderAbility.setBackground(new Color(205, 127, 50));
		
		attUp = new JButton();attUp.setText("Up");
		attDown = new JButton();attDown.setText("Down");
		attLeft = new JButton();attLeft.setText("Left");
		attRight = new JButton();attRight.setText("Right");
		attRight = new JButton();attRight.setText("Right");
		attUp.setBackground(new Color(255, 204, 203));
		attDown.setBackground(new Color(255, 204, 203));
		attLeft.setBackground(new Color(255, 204, 203));
		attRight.setBackground(new Color(255, 204, 203));
		JLabel ATTACK = new JLabel("ATTACK");
		ATTACK.setForeground(Color.white);
		ATTACK.setFont(new Font("Comicsans",Font.BOLD,15));
		
		ability1 = new JButton();ability1.setText("Ability 1");ability1.setBackground(new Color(173,216,230));
		ability2 = new JButton();ability2.setText("Ability 2");ability2.setBackground(new Color(144,238,144));
		ability3 = new JButton();ability3.setText("Ability 3");ability3.setBackground(new Color(177,156,217));
		//Directional
		abU = new JButton();abU.setText("Up");abU.addMouseListener(this);abU.setBackground(new Color(255, 204, 203));
		abD = new JButton();abD.setText("Down");abD.addMouseListener(this);abD.setBackground(new Color(255, 204, 203));
		abL = new JButton();abL.setText("Left");abL.addMouseListener(this);abL.setBackground(new Color(255, 204, 203));
		abR = new JButton();abR.setText("Right");abR.addMouseListener(this);abR.setBackground(new Color(255, 204, 203));
		abC = new JButton();abC.setBackground(new Color(255, 204, 203));
		//Single Target
		st1 = new JButton();st1.addMouseListener(this);st1.setBackground(new Color(173,216,230));
		st2 = new JButton();st2.addMouseListener(this);st2.setBackground(new Color(144,238,144));
		st3 = new JButton();st3.addMouseListener(this);st3.setBackground(new Color(177,156,217));
		
		endTurn = new JButton();endTurn.setText("End Turn");
		endTurn.setBackground(new Color(139,0,0));
		endTurn.setForeground(new Color(0,0,0));
		endTurn.setFont(new Font("Consolas",Font.BOLD,17));
		
		
		
		GameView.getMove().add(up,BorderLayout.NORTH);up.addMouseListener(this);
		GameView.getMove().add(down,BorderLayout.SOUTH);down.addMouseListener(this);
		GameView.getMove().add(left,BorderLayout.WEST);left.addMouseListener(this);
		GameView.getMove().add(right,BorderLayout.EAST);right.addMouseListener(this);
		
		GameView.getMove().add(LeaderAbility,BorderLayout.CENTER);LeaderAbility.addMouseListener(this);
		GameView.getAttack().add(attUp,BorderLayout.NORTH);attUp.addMouseListener(this);
		GameView.getAttack().add(attDown,BorderLayout.SOUTH);attDown.addMouseListener(this);
		GameView.getAttack().add(attLeft,BorderLayout.WEST);attLeft.addMouseListener(this);
		GameView.getAttack().add(attRight,BorderLayout.EAST);attRight.addMouseListener(this);
		JButton s = new JButton();
		s.setBackground(new Color(255, 204, 203));
		s.setIcon(sword);
		GameView.getAttack().add(s,BorderLayout.CENTER);
		
		GameView.getAbilities().add(ability1);ability1.addMouseListener(this);
		GameView.getAbilities().add(ability2);ability2.addMouseListener(this);
		GameView.getAbilities().add(ability3);ability3.addMouseListener(this);
		
		GameView.getControls().add(endTurn);endTurn.addMouseListener(this);
		
		//////////GAME///////////
		updateBoard(boardTemp);
		while(game.checkGameOver()==null) {
		turnOver=false;
		updateDetails();
		while(turnOver==false) {
			System.out.println("");
		}
		
		GameView.revalidate();
		GameView.repaint();

		}
		WinningScreen.getWinner().setText(game.checkGameOver().getName()+" is the winner!");
		WinningScreen.setFont(new Font("Comicsans",Font.BOLD,35));
		WinningScreen.setVisible(true);
		GameView.setVisible(false);	
	}
	
	

public Player getFp() {
		return fp;
	}


public Player getSp() {
		return sp;
	}





@Override
public void mouseClicked(MouseEvent e) {
	JButton b =(JButton)e.getSource();
	if((p1.isVisible())) {/////////HERE
		if(!buttons.contains(b)) {
			return;
		}
		count+=1;
		int r =buttons.indexOf(b);
		if(count<=3) {
			fp.getTeam().add(game.getAvailableChampions().get(r));
			if(count==1) {
				fp.setLeader(game.getAvailableChampions().get(r));
				//buttons.get(r).setBackground(new Color(255,255,0));
				buttons.get(r).setBorder(Lborder);
			}else 
				//buttons.get(r).setBackground(new Color(255,0,0));
				buttons.get(r).setBorder(t1border);
			game.getAvailableChampions().remove(r);
			buttons.remove(r);
		}
		else if(count>3 && count<=6) {
			sp.getTeam().add(game.getAvailableChampions().get(r));
			if(count==4) {
				sp.setLeader(game.getAvailableChampions().get(r));
				//buttons.get(r).setBackground(new Color(255,255,0));
				buttons.get(r).setBorder(Lborder);
			}else 
				//buttons.get(r).setBackground(new Color(0,0,255));
				buttons.get(r).setBorder(t2border);
			game.getAvailableChampions().remove(r);
			buttons.remove(r);
		}
		
		if(count==6) {
			p1.dispose();
		}
	}else if(GameView.isVisible()) {
		if(b.equals(up)) {////////////////////UP CLICKED
          try {
			game.move(Direction.DOWN);
		} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
			expMessage = new ExceptionMessage();
			expMessage.getMessage().setText(e1.getMessage());
			return;
		}
          updateBoard(game.getBoard()); 
          updateDetails();
		}else if(b.equals(down)){/////////////Down Clicked
	        try {
				game.move(Direction.UP);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
	          updateBoard(game.getBoard());
	          updateDetails();
		}else if(b.equals(left)) {///////////Left Clicked
	        try {
				game.move(Direction.LEFT);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
	          updateBoard(game.getBoard()); 
	          updateDetails();
		}else if(b.equals(right)) {///////////Right Clicked
	        try {
				game.move(Direction.RIGHT);
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
	          updateBoard(game.getBoard()); 
	          updateDetails();
		}else if(b.equals(attUp)) {//////////Up attack clicked <3
			try {
				game.attack(Direction.DOWN);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard());
			updateDetails();
		}else if(b.equals(attDown)) {//////////Down attack clicked <3
				try {
					game.attack(Direction.UP);
				} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
					expMessage = new ExceptionMessage();
					expMessage.getMessage().setText(e1.getMessage());
					return;
				}
				updateBoard(game.getBoard()); 
				updateDetails();
		}else if(b.equals(attRight)) {//////////Right attack clicked <3
			try {
				game.attack(Direction.RIGHT);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
		}else if(b.equals(attLeft)) {//////////Left attack clicked <3 CUTEE!!
			try {
				game.attack(Direction.LEFT);
			} catch (NotEnoughResourcesException | ChampionDisarmedException | InvalidTargetException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
		}else if(b.equals(LeaderAbility)) {//////////Using Leader Ability
			try {
				game.useLeaderAbility();
			} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
		}else if(b.equals(ability1)) {/////////////////Using Ability 1
			if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.DIRECTIONAL) {////FIX
				addD();
				ability1Used = true;
			}else if(game.getCurrentChampion().getAbilities().get(0).getCastArea()!=AreaOfEffect.SINGLETARGET) {
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(0));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					expMessage = new ExceptionMessage();
					expMessage.getMessage().setText(e1.getMessage());
					return;
				}
				updateBoard(game.getBoard()); 
				updateDetails();
			}else if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SINGLETARGET) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText("Singletarget: click button on board");
				return;
			}
		}else if(b.equals(ability2)) {/////////////////Using Ability 2
			if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.DIRECTIONAL) {/////FIX
				addD();
				ability2Used = true;
			}else if (game.getCurrentChampion().getAbilities().get(1).getCastArea()!=AreaOfEffect.SINGLETARGET){
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(1));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					expMessage = new ExceptionMessage();
					expMessage.getMessage().setText(e1.getMessage());
					return;
				}
				updateBoard(game.getBoard()); 
				updateDetails();
			}else if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SINGLETARGET) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText("Singletarget: click button on board");
				return;
			}
		}else if(b.equals(ability3)) {/////////////////Using Ability 3
			if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.DIRECTIONAL) {/////FIX
				addD();
				ability3Used = true;
			}else if(game.getCurrentChampion().getAbilities().get(2).getCastArea()!=AreaOfEffect.SINGLETARGET){
				try {
					game.castAbility(game.getCurrentChampion().getAbilities().get(2));
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					expMessage = new ExceptionMessage();
					expMessage.getMessage().setText(e1.getMessage());
					return;
				}
				updateBoard(game.getBoard()); 
				updateDetails();
			}else if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SINGLETARGET) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText("Singletarget: click button on board");
				return;
			}
		}else if(boardButtons.contains(b)) {///////////////Single Target On Board Click //Here
			int r = boardButtons.indexOf(b);
			targetPoint = pointList.get(r);
			addSingleTarget();
			
//			ArrayList<Ability> temp = game.getCurrentChampion().getAbilities();
//			for(int i=0;i<temp.size();i++) {
//				if(temp.get(i).getCastArea()==AreaOfEffect.SINGLETARGET) {
//					int r = boardButtons.indexOf(b);
//					Point tempPoint = pointList.get(r);
//					try {
//						game.castAbility(temp.get(i),(int)tempPoint.getX(),(int)tempPoint.getY());
//					} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
//							| CloneNotSupportedException e1) {
//						expMessage = new ExceptionMessage();
//						expMessage.getMessage().setText(e1.getMessage());
//						return;
//					}
//					updateBoard(game.getBoard()); 
//					updateDetails();
//					return;
//				}
//			}
		}else if(b.equals(abU)||b.equals(abD)||b.equals(abL)||b.equals(abR)) {
			castD(b);
		}else if(b.equals(st1)||b.equals(st2)||b.equals(st3)) {
			castSingleTarget(b);
		}else if(b.equals(endTurn)) {///////////End Turn Clicked
			turnOver = true;
			game.endTurn();
	        updateBoard(game.getBoard()); 
	        updateDetails();
	        removeSingleTarget();
	        removeD();
		}
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
	JButton b =(JButton)e.getSource();
	if((p1.isVisible())) {
		if(!buttons.contains(b)) {
			return;
		}
		int r =buttons.indexOf(b);
		p1.getDetails().setText(game.getAvailableChampions().get(r).toString());
	}
	

}


@Override
public void mouseExited(MouseEvent e) {
	p1.getDetails().setText("");
	
}

public void updateBoard(Object[][] boardTemp) {
	if(firstTurn==false) {
		clearBoard();
	}
	for(int i=0;i<game.getBoardwidth();i++) {
		for(int j=0;j<game.getBoardheight();j++) {
			JButton b = new JButton();
			b.addMouseListener(this);
			if(boardTemp[i][j] instanceof Champion) {
				Champion tempChamp = (Champion)boardTemp[i][j];
				//b.setText(tempChamp.getName());
				if(tempChamp.getName().equals("Dr Strange"))
					b.setIcon(ds);
				else if(tempChamp.getName().equals("Captain America"))
					b.setIcon(ca);
				else if(tempChamp.getName().equals("Deadpool"))
					b.setIcon(dp);
				else if(tempChamp.getName().equals("Electro"))
					b.setIcon(electro);
				else if(tempChamp.getName().equals("Ghost Rider"))
					b.setIcon(gr);
				else if(tempChamp.getName().equals("Hela"))
					b.setIcon(hela);
				else if(tempChamp.getName().equals("Hulk"))
					b.setIcon(hulk);
				else if(tempChamp.getName().equals("Iceman"))
					b.setIcon(iceman);
				else if(tempChamp.getName().equals("Ironman"))
					b.setIcon(im);
				else if(tempChamp.getName().equals("Quicksilver"))
					b.setIcon(qs);
				else if(tempChamp.getName().equals("Spiderman"))
					b.setIcon(sm);
				else if(tempChamp.getName().equals("Venom"))
					b.setIcon(venom);
				else if(tempChamp.getName().equals("Yellow Jacket"))
					b.setIcon(yj);
				else if(tempChamp.getName().equals("Thor"))
					b.setIcon(thor);
				else if(tempChamp.getName().equals("Loki"))
					b.setIcon(loki);
				b.setText(""+tempChamp.getCurrentHP());
				b.setHorizontalTextPosition(b.CENTER);
				b.setVerticalTextPosition(b.TOP);
				b.setForeground(new Color(194,24,7));
				b.setBackground(new Color(220,220,220));//
			
					
			}else if(boardTemp[i][j] instanceof Cover) {
				Cover tempCover = (Cover)boardTemp[i][j];
//				b.setBackground(new Color(169,149,123));
				b.setBackground(new Color(220,220,220));
				b.setText("Cover  Health: "+tempCover.getCurrentHP());
				b.setIcon(cover);
				b.setHorizontalTextPosition(b.CENTER);
				b.setVerticalTextPosition(b.TOP);
			}
			else
				b.setBackground(new Color(220,220,220));
			b.addMouseListener(this);
			boardButtons.add(b);
			pointList.add(new Point(i,j));
			GameView.getboard().add(b);
		}
	}
	if(firstTurn==true) {
		firstTurn=false;
	}
	GameView.revalidate();
	GameView.repaint();
}
public void clearBoard() {
	for(int i=0;i<boardButtons.size();i++) {
		boardButtons.remove(i);
		i--;
	}
	GameView.getboard().removeAll();
	GameView.revalidate();
	GameView.repaint();
}
public void updateDetails() {
	String a = " ";
	a += fp.getName()+"    ";
	for(int i=0;i<fp.getTeam().size();i++) {
		a+=fp.getTeam().get(i).getName() + " - ";

	}
	a+="  Leader Ability Used: "+game.isFirstLeaderAbilityUsed()+" "+" ";
	GameView.getA().setText(a);
	String b = "";
	b+= sp.getName()+"   ";
	for(int i=0;i<sp.getTeam().size();i++) {
		b+=sp.getTeam().get(i).getName() + " - ";
	}
	b+="  Leader Ability Used: "+game.isSecondLeaderAbilityUsed()+" ";
	GameView.getB().setText(b);
	
	GameView.getPlayerDetails().revalidate();
	GameView.getPlayerDetails().repaint();
	
	ArrayList<Champion> queueTemp = new ArrayList<Champion>();
	String queueList = "";
	while(!game.getTurnOrder().isEmpty()) {
		Champion queueChamp = (Champion)game.getTurnOrder().remove();
		//queueList+= queueChamp.TurnOrderString()+" Leader: ";
		queueList+= queueChamp.TurnOrderString();
		if(queueChamp.equals(fp.getLeader())||queueChamp.equals(sp.getLeader())) {
			queueList+=" (LEADER) ";
		}//else 
//			queueList+="No ";
		ArrayList<Effect> currentEffectTemp2 = new ArrayList<Effect>();
		for(int i=0;i<queueChamp.getAppliedEffects().size();i++) {
			Effect temp = queueChamp.getAppliedEffects().get(i);
			queueList+= ""+temp+" ";
		}
		GameView.getTurnOrderDetails().setText(queueList);
		queueList+="\n";
		queueTemp.add(queueChamp);
	}
	while(!queueTemp.isEmpty()) {
		game.getTurnOrder().insert(queueTemp.remove(0));
	}
	
	GameView.getTurnOrderDetails().revalidate();
	GameView.getTurnOrderDetails().repaint();
	
	String currentDetails = ""+game.getCurrentChampion();
	ArrayList<Effect> currentEffectTemp = new ArrayList<Effect>();
	while(!game.getCurrentChampion().getAppliedEffects().isEmpty()) {
		Effect temp = game.getCurrentChampion().getAppliedEffects().remove(0);
		currentDetails+= ""+temp+"\n";
		currentEffectTemp.add(temp);
	}
	while(!currentEffectTemp.isEmpty()) {
		game.getCurrentChampion().getAppliedEffects().add(currentEffectTemp.remove(0));
	}
	GameView.getcurrentDetails().setText(currentDetails);
	GameView.getcurrentDetails().revalidate();
	GameView.getcurrentDetails().repaint();
}
public void addD() {
    d = new JPanel();
	d.setPreferredSize(new Dimension(200,170));
	d.setLayout(new BorderLayout());
	GameView.getControls().add(d);
	d.setBackground(new Color(43,45,47));
	d.add(abU, BorderLayout.NORTH);
	d.add(abD, BorderLayout.SOUTH);
	d.add(abL, BorderLayout.WEST);
	d.add(abR, BorderLayout.EAST);
	d.add(abC, BorderLayout.CENTER);
	d.setVisible(true);
	d.revalidate();
	d.repaint();
}
public void removeD() {
	GameView.getControls().remove(d);
}
public void castD(JButton b) {
	if(b.equals(abU)) {
		if(ability1Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.DOWN);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability1Used=false;
			removeD();
			return;
		}else if(ability2Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.DOWN);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability2Used=false;
			removeD();
			return;
		}else if(ability3Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.DOWN);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability3Used=false;
			removeD();
			return;
		}
	}else if(b.equals(abD)) {
		if(ability1Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.UP);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability1Used=false;
			removeD();
			return;
		}else if(ability2Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.UP);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability2Used=false;
			removeD();
			return;
		}else if(ability3Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.UP);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability3Used=false;
			removeD();
			return;
		}
	}else if(b.equals(abL)) {
		if(ability1Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.LEFT);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability1Used=false;
			removeD();
			return;
		}else if(ability2Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.LEFT);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability2Used=false;
			removeD();
			return;
		}else if(ability3Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.LEFT);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability3Used=false;
			removeD();
			return;
		}
	}else if(b.equals(abR)) {
		if(ability1Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(0), Direction.RIGHT);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability1Used=false;
			removeD();
			return;
		}else if(ability2Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(1), Direction.RIGHT);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability2Used=false;
			removeD();
			return;
		}else if(ability3Used) {
			try {
				game.castAbility(game.getCurrentChampion().getAbilities().get(2), Direction.RIGHT);
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				expMessage = new ExceptionMessage();
				expMessage.getMessage().setText(e1.getMessage());
				return;
			}
			updateBoard(game.getBoard()); 
			updateDetails();
			ability3Used=false;
			removeD();
			return;
		}
	}
}
public void addSingleTarget() {
	boolean flag=false;
	ArrayList<Ability> temp = game.getCurrentChampion().getAbilities();
//    st = new JPanel();
//	st.setPreferredSize(new Dimension(200,30));
//	st.setLayout(new GridLayout());
//	GameView.getControls().add(st);
	//st.setBackgrounst(Color.black);
	for (int i=0;i<temp.size();i++) {
		if(temp.get(i).getCastArea()==AreaOfEffect.SINGLETARGET) {
			flag=true;
			switch(i) {
			case 0:st1.setText(temp.get(i).getName());st1.setPreferredSize(new Dimension(200,30));
			     st1.setFont(new Font("Consolas",Font.BOLD,15));GameView.getControls().add(st1);break;
			case 1:st2.setText(temp.get(i).getName());st2.setPreferredSize(new Dimension(200,30));
		           st2.setFont(new Font("Consolas",Font.BOLD,15));GameView.getControls().add(st2);break;
			case 2:st3.setText(temp.get(i).getName());st3.setPreferredSize(new Dimension(200,30));
	              st3.setFont(new Font("Consolas",Font.BOLD,15));GameView.getControls().add(st3);break;
			}
			
		}
			
	}
	GameView.getControls().revalidate();
	GameView.getControls().repaint();
}
public void removeSingleTarget() {
	GameView.getControls().remove(st1);
	GameView.getControls().remove(st2);
	GameView.getControls().remove(st3);
	GameView.getControls().revalidate();
	GameView.getControls().repaint();
}
public void castSingleTarget(JButton b) {
	if(b.equals(st1)) {
		try {
			game.castAbility(game.getCurrentChampion().getAbilities().get(0),(int)targetPoint.getX(),(int)targetPoint.getY());
		} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
				| CloneNotSupportedException e1) {
			expMessage = new ExceptionMessage();
			expMessage.getMessage().setText(e1.getMessage());
			removeSingleTarget();
			return;
		}
		
		removeSingleTarget();
		updateBoard(game.getBoard()); 
		updateDetails();
		return;
	}else if(b.equals(st2)) {
		try {
			game.castAbility(game.getCurrentChampion().getAbilities().get(1),(int)targetPoint.getX(),(int)targetPoint.getY());
		} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
				| CloneNotSupportedException e1) {
			expMessage = new ExceptionMessage();
			expMessage.getMessage().setText(e1.getMessage());
			removeSingleTarget();
			return;
		}
		removeSingleTarget();
		updateBoard(game.getBoard()); 
		updateDetails();
		return;
	}else if(b.equals(st3)) {
		try {
			game.castAbility(game.getCurrentChampion().getAbilities().get(2),(int)targetPoint.getX(),(int)targetPoint.getY());
		} catch (NotEnoughResourcesException | AbilityUseException | InvalidTargetException
				| CloneNotSupportedException e1) {
			expMessage = new ExceptionMessage();
			expMessage.getMessage().setText(e1.getMessage());
			removeSingleTarget();
			return;
		}
		
		removeSingleTarget();
		updateBoard(game.getBoard()); 
		updateDetails();
		return;
	}
}
public static void main(String[] args) throws IOException, NotEnoughResourcesException, UnallowedMovementException {
	new controller();
}

}




