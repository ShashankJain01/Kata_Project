package validation;

import common.*;
import java.util.*;

public class CheckValidateEvaluate {
	StringBuilder Loop;
	Scanner inputloop;
	int Attempt =0;
	
/*
 This function is responsible for validation of the User value
 - validate the value should be 5 Dice only.
 - validate the value is between 1 to 6 only 
 */
	public int validate(String [] value){		
		int num;
		try{
	        if(value.length != Main.Dices){	
	        	System.out.print("\nPlease Roll all 5 Dice");
	        	return Main.invalid;
	        }else{
	        	for(int i=0;i<Main.Dices;i++)
	    		{
	    			num=Integer.parseInt(value[i]);
	    			if(num<Main.MinValue || num>Main.MaxValue)
	    			{	
	    				System.out.print("\nNumber should be in range of 1 to 6 Only");
	    				return Main.invalid;
	    			}
	    		}	        		
	        }	
		}catch(Exception e){			
			System.out.println("Invalid input");
			return Main.invalid;			
		}	
		return Main.valid;
	}
	
/*This function is responsible for calculating score of the dics that
 * User has entered.
 * Calculate the score based on Rules 
 * Argument taken(2):
 *  - Integer that has Rule number in the HashMap 
 *  - as the Array that has User entered values 
 * Return a score
 * */	
	public int score(int x, String [] val){ 
		int rulevalue = x;
		int scorepoint = 0;
		int multiple =1;
		int arrayvalue =0;
		int arrayvalueold=0;
		int setone =0;
        int settwo =0;
        int icount =0;
        
		Arrays.sort( val );
		
		/*For loop uses sorted array User values and then
		 * if the consecutive values are same then based on rule 
		 * calculation happens */
		for (int k = 0; k < val.length; k++){
			arrayvalue = Integer.parseInt(val[k]);
			if(arrayvalue == arrayvalueold){
				if(rulevalue == 2 && icount ==0 ){
					settwo = arrayvalue;
					icount =1;
				}
				setone=arrayvalue;
			}
			arrayvalueold = arrayvalue;
	    }
		if(rulevalue == 50){
			scorepoint = 50;
		}else if(rulevalue == 25){
			scorepoint = 25;
		}else if (rulevalue == 15){
			scorepoint = 15;
		}else if (rulevalue == 20){
			scorepoint = 20;
		}else if ( rulevalue == 1){
			multiple =2;
			scorepoint = setone * multiple;
		}else if( rulevalue == 2){
			multiple =2;
			scorepoint = (setone + settwo) * multiple;
		}else if( rulevalue == 3){
			multiple =3;
			scorepoint = setone * multiple;
		}else if( rulevalue == 4){
			multiple =4;
			scorepoint = setone * multiple;
		}else if( rulevalue ==0){
			scorepoint =0;
		}
		return scorepoint;
	}

/*This function is responsible for finding the Rule that can be applied 
 * to User entered value.
 * the logic is it takes one value of an array at a time and then traverse
 * next value till last value via for loop and based on value being same or not same, 
 * variable are set.
 * and at every last compare whatever rule is left, that rule boolean is set
 * to true
 * Argument taken : User entered array
 * Return: A rule number(integer) that is associated with a rule in Main Class
 */	
	
	public int rule(String [] val){
		int check = 0;
		boolean straight = false;
		boolean yahtee = false;
		boolean fourkind = false;
		boolean triple = false;
		boolean pair = false;
		boolean pairtwo = false;
		boolean fullhouse =false;
		boolean straightmax =false;
	/*the variables are named as what rules are left at that point of time to be true
	 * example:
	 * if pair, pairtwo , fullhouse have possibility to become at the end of the array 
	 * then the name of variable will be prprtful =1
	 * pr - pair, tr - triple, ya - yatzee , ful - fullhouse, 
	 * pairtwo - prt , four of kind - fo
	 *  */	
		int num1 =0;
		int num1old = 0;
		int prtrfoprtfulya=0 ;
		int trfofulya=0;
		int foya=0;
		int prprt=0;
		int prprtful =0;
		int prtfu=0;
		int trful=0;
		int prtrprtfo=0;
		int prtrprtfo1=0;
		int trfo=0;
		int prtr=0;
	    int prtr1=0;
		int pr=0;
		
		for(int j=0;j<Main.Dices;j++)
		{
			num1=Integer.parseInt(val[j]);	
			if (j >= Main.MinValue){
				if(num1old == num1){
				  check++;
				  if(check == 1 && j == Main.MinValue){
					  prtrfoprtfulya =1;
				  }else if(check ==2 && prtrfoprtfulya == 1 && j == check ){
					  trfofulya =1;
				  }else if(check == 3 && trfofulya ==1 && j == check ){
					  foya =1;
				  }else if(check == 4 &&  foya == 1 && j== check ){
					  yahtee = true;
				  }
				  if(check  ==2 &&  prprt == 1 && j==(check + 3)){
						pairtwo = true;
					}
				  if(check == 2 && prprtful == 1 &&  j==(check + 1)){
						prtfu =1;
				   }else if(check == 3 && prtfu == 1 && j==(check + 1)){
						fullhouse = true;
					}
				  if(check == 3 && trful == 1 && j==(check + 1)){
						fullhouse = true;
					}
				  if(check == 1 &&  prtrprtfo ==1 && j==(check + 1)){
					  prtrprtfo1 =1;
			       }else if(check == 2 &&  prtrprtfo1 ==1 && j==(check + 1)){
			    	   trfo=1;
			       }else if(check == 3 &&  trfo ==1 && j==(check + 1)){
			    	   fourkind = true;
			       }
				  if(check == 2 && prprt == 1 && j==(check + 2)){
						pairtwo = true;	
					}
			      if(check == 1 && prtr ==1 && j==(check + 2)){
						   prtr1=1;
				   }else if(check == 2 && prtr1 == 1 && j==(check + 2)){
						    triple = true;
				   }
				}else if(num1old < num1){
					if(check == 3 && foya == 1  && j==(check + 1)){
						fourkind = true;
					}if(check == 1 && prtrfoprtfulya == 1 &&  j==(check + 1)){
						prprtful =1;
					}else if(check  ==1 &&  prprtful == 1 && j==(check + 2)){
						prprt =1;
					}else if(check  ==1 &&  prprt == 1 && j==(check + 3)){
						pair = true;
					}
					if(check == 2 && prtfu ==1 && j==(check + 2)){
						pairtwo = true;
					}
					if(check == 2 && trfofulya ==1  && j==(check + 1) ){
						trful = 1;
					}else if(check == 2 && trful == 1 && j==(check + 2)){
						triple = true;
					}
					if(check == 0 && j==(check + 1)){
						prtrprtfo =1;
					}else if(check == 0 && prtrprtfo ==1 && j==(check + 2)){
						prtr =1;
					}else if(check == 0 &&  prtr == 1 && j==(check + 2)){
						pr =1;
					}else if(check == 1 &&  pr == 1 && j==(check + 3)){
						pair =true;
					}
					if(check == 1 && prtr1 == 1 && j==(check + 3)){
						pair = true;
					}	
					if(check == 2 && trfo == 1 && j==(check + 2)){
						triple = true;
					}if(check == 1 && prtrprtfo1 == 1 && j==(check + 2)){
						prprt =1;	
					}else if(check == 1 && prprt == 1 && j==(check + 3)){
						pair = true;	
					}
					
				}else{
					if(check == 3 && foya == 1  && j==(check - 1)){
						fourkind = true;
					}if(check == 1 && prtrfoprtfulya == 1 &&  j==(check + 1)){
						prprtful =1;
					}else if(check  ==1 &&  prprtful == 1 && j==(check + 2)){
						prprt =1;
					}else if(check  ==1 &&  prprt == 1 && j==(check + 3)){
						pair = true;
					}
					if(check == 2 && prtfu ==1 && j==(check + 2)){
						pairtwo = true;
					}
					if(check == 2 && trfofulya ==1  && j==(check + 1) ){
						trful = 1;
					}else if(check == 2 && trful == 1 && j==(check + 2)){
						triple = true;
					}
					if(check == 0 && j==(check + 1)){
						prtrprtfo =1;
					}else if(check == 0 && prtrprtfo ==1 && j==(check + 2)){
						prtr =1;
					}else if(check == 0 &&  prtr == 1 && j==(check + 2)){
						pr =1;
					}else if(check == 1 &&  pr == 1 && j==(check + 3)){
						pair =true;
					}
					if(check == 1 && prtr1 == 1 && j==(check + 3)){
						pair = true;
					}	
					if(check == 2 && trfo == 1 && j==(check + 2)){
						triple = true;
					}if(check == 1 && prtrprtfo1 == 1 && j==(check + 2)){
						prprt =1;	
					}else if(check == 1 && prprt == 1 && j==(check + 3)){
						pair = true;	
					}
					if(check == 0 && num1 == Main.MaxValue){
						straight = true;
					}else if(check == 0 && num1 != Main.MaxValue ){
						straightmax = true;
					}
				}
			}
			num1old =num1;
		}
		if( straight == true ){
			check = 15;
		}
		if( straightmax == true ){
			check = 20;
		}
		if(yahtee == true){
			check =50;
		}
		if(fullhouse == true){
			check =25;
		}
		if(fourkind == true ){
			check = 4;
		}
		if(triple == true){
			check =3;
		}
		if(pairtwo == true){
			check =2;
		}
		if(pair == true){
			check =1;
		}
		return check;
	}
	
/*The objective of this function is to reiterate the loop if user wants to 
 * roll dics again till 3 times.
 * it also allow USer to change any specific dics index and roll its value again
 * Argument taken: as Array that User entered 
 **/	
	
	public void loopcheck(String [] arrInput){
		
		inputloop=new Scanner(System.in);
		boolean run = true ;
		int num =0;	
		int[] newindex = new int [5];
        String [] replacecopy= null;
	    /*The while loop will allow user to set position of the dics that he need ot change 
	     * the value for*/	
		while(run){
		     System.out.print("\nEnter position of dices that you want to REROLL. (,) seperated => ");
		     Loop=new StringBuilder(inputloop.nextLine());
		     String []rollindex=Loop.toString().split(",");
		     
		     for(int i=0;i<rollindex.length;i++)
	    		{
	    			num=Integer.parseInt(rollindex[i]);
	    			newindex[i]= num;
	    			if(num<Main.MinValue || num>Main.Dices)
	    			{	
	    				System.out.print("\nNumber should be in range of 1 to 5 Only");
	    			
	    			}else{
	    				run = false;
	    			}	
	    		}	  
		}
	    run = true;
	    
	    /*The while loop allow user to enter new value for old value
	     * and validates it to be between 1 to 6*/
	    while(run){
	    	System.out.print("Enter the replaced values(,) seperated:");
	    	Loop=new StringBuilder(inputloop.nextLine());
	    	String [] replace=Loop.toString().split(",");
	    		for(int i=0;i<replace.length;i++){
	    				num=Integer.parseInt(replace[i]);
	    				if(num<Main.MinValue || num>Main.MaxValue){	
	    					System.out.print("\nNumber should be in range of 1 to 6 Only");
	    				}else{
	    					run = false;
	    				}
	    			}	
	    		replacecopy = Arrays.copyOf(replace, replace.length);
	    }	
	    for(int i=0;i<replacecopy.length;i++){
	          arrInput[newindex[i]-1]=replacecopy[i];	
	    }
	    System.out.print("\nDices values : ");
	    
	    /*This for loop run the new values for score and rule check*/
		for(String str:arrInput){
			System.out.print(str+" ");
		}
			if(validate(arrInput) == Main.valid ){
				int rulevalue = rule(arrInput);
				System.out.print(Main.RuleCheck.get(rulevalue));
				int scorevalue =  score(rulevalue,arrInput);
			    System.out.print("\nYour new score is :"+scorevalue);
			}
			else{
				System.out.print("\nInvalid Input Entered");
			}
		Attempt++; 
		if(Attempt<2)
		{
			System.out.print("\nDo you want to REROLL again(y/n) ?");
			Loop=new StringBuilder(inputloop.nextLine());
						
			if(Loop.toString().contains("y")
					&&
				(Loop.toString().trim().length()==1))
			{				
				loopcheck(arrInput);
			}		
		}
		else
		{
			System.out.println("Maximum limit of 3 completed..");
		}
	}
}
