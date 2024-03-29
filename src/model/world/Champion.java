package model.world;

import java.awt.Point;
import java.util.ArrayList;


import model.abilities.Ability;
import model.effects.Effect;

@SuppressWarnings("rawtypes")
public abstract class Champion implements Damageable,Comparable {
	private String name;
	private int maxHP;
	private int currentHP;
	private int mana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;
	

	public Champion(String name, int maxHP, int mana, int actions, int speed, int attackRange, int attackDamage) {
		this.name = name;
		this.maxHP = maxHP;
		this.mana = mana;
		this.currentHP = this.maxHP;
		this.maxActionPointsPerTurn = actions;
		this.speed = speed;
		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		this.condition = Condition.ACTIVE;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>();
		this.currentActionPoints=maxActionPointsPerTurn;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public String getName() {
		return name;
	}

	public void setCurrentHP(int hp) {

		if (hp <= 0) {
			currentHP = 0;
			condition=Condition.KNOCKEDOUT;
			
		} 
		else if (hp > maxHP)
			currentHP = maxHP;
		else
			currentHP = hp;

	}

	
	public int getCurrentHP() {

		return currentHP;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int currentSpeed) {
		if (currentSpeed < 0)
			this.speed = 0;
		else
			this.speed = currentSpeed;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point currentLocation) {
		this.location = currentLocation;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		if(currentActionPoints>maxActionPointsPerTurn)
			currentActionPoints=maxActionPointsPerTurn;
		else 
			if(currentActionPoints<0)
			currentActionPoints=0;
		this.currentActionPoints = currentActionPoints;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	public int compareTo(Object o)
	{
		Champion c = (Champion)o;
		if(speed==c.speed)
			return name.compareTo(c.name);
		return -1 * (speed-c.speed);
	}
	public String toString() {
		return "Champion Name: "+name+"\n"+ "Hp: "+ currentHP+"\n"+ "Mana: "+mana+"\n"+"Actions: "+currentActionPoints+"\n"
	     +"Speed: "+speed+"\n"+"Attack Range: "+attackRange+"\n"+"Attack Damage: "+attackDamage+"\n"+"\n"
		 + "Ability 1: "+abilities.get(0).getName()+"\n"+abilities.get(0).toString()+"\n"
	     + "Ability 2: "+abilities.get(1).getName()+"\n"+abilities.get(1).toString()+"\n"
		 + "Ability 3: "+abilities.get(2).getName()+"\n"+abilities.get(2).toString()+"\n";
	}
//	public String details() {
//		String r="";
//		r+="Champion Name: "+name+"\n"+ "Hp: "+ maxHP+"\n"+ "Mana: "+mana+"\n"+"Actions: "+maxActionPointsPerTurn+"\n"
//				+"Speed: "+speed+"\n"+"Attack Range: "+attackRange+"\n"+"Attack Damage: "+attackDamage+"\n";
//		for(int i=0;i<abilities.size();i++) {
//			r+="Ability "+i+1;
//		}
//	}
	public String TurnOrderString() {

			return name+"  "+"Hp: "+ currentHP+"   "+ "Mana: "+mana+"   "+"Actions: "+currentActionPoints+"   "
				     +"Speed: "+speed+"   "+"Attack Range: "+attackRange+"   "+"Attack Damage: "+attackDamage+"  ";
	}
	
public abstract void useLeaderAbility(ArrayList<Champion> targets);


}
