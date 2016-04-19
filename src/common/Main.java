package common;


import user.*;
import java.util.HashMap;
import java.util.Map;


public class Main {

	/*Defined variables */
	public static final int Dices=5;
	public static final int MinValue=1;
	public static final int MaxValue=6;
	public static final int yahtzeeScore=50;
	public static final int invalid=-1;
	public static final int valid=0;
	public static final int validrule=7;
	


	 /* This is how to declare HashMap */
   public static Map<Integer, String> RuleCheck = new HashMap<Integer, String>();

 	
	public static void main(String args[]){
		
		    RuleCheck.put(1,"You have a Pair");
		    RuleCheck.put(2,"You have Two Pair");
		    RuleCheck.put(3,"You have Three of a Kind");
		    RuleCheck.put(4,"You have Four of a Kind");
		    RuleCheck.put(25,"You have Fullhouse");
		    RuleCheck.put(15,"You have a Straight");
		    RuleCheck.put(20,"You have Higher Straight");
		    RuleCheck.put(50,"Yahtzee");
		    RuleCheck.put(0,"No Rule achieved");

	   
		System.out.println("Welcome to the Game - Yatzee");
		
		Uservalues Uservalues=new Uservalues();
		Uservalues.initiate();
		
	}

}
