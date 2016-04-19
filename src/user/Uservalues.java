package user;

import validation.*;
import common.*;

import java.util.*;

public class Uservalues {

	Scanner input;
	StringBuilder inputentered;
	StringBuilder inputenteredloop;
	StringBuilder end;
	String [] splitvalues; 
	String [] splitvaluesorig; 
	private CheckValidateEvaluate checkValidateEvaluate ;
	
	public void initiate(){
		
		boolean start=true;	
		input=new Scanner(System.in);
		checkValidateEvaluate = new CheckValidateEvaluate();
		int scorevalue;
		int rulevalue;
		/*Start of the while loop  */		
		while(start){
		
			System.out.print("\n Please Roll the Dics(Comma Seperated)Eg -1,2,3,4,5:");
			
			inputentered =new StringBuilder(input.nextLine());			
			splitvalues = inputentered.toString().split(",");
			splitvaluesorig = Arrays.copyOf(splitvalues, splitvalues.length);
			
			if(checkValidateEvaluate.validate(splitvalues) == Main.valid ){
				rulevalue = checkValidateEvaluate.rule(splitvalues);
				System.out.print(Main.RuleCheck.get(rulevalue));
				
				scorevalue =  checkValidateEvaluate.score(rulevalue,splitvalues);
			    System.out.print("\nYour score is :"+scorevalue);
			   
			    boolean roll =true;
			    while(roll){
			    	System.out.print("\nDo you want to reRoll (y/n):");
				
			    	inputenteredloop =new StringBuilder(input.nextLine());	
					if((inputenteredloop.toString().contains("y"))
						&&
							(inputenteredloop.toString().trim().length()==1)){
					
						checkValidateEvaluate.loopcheck(splitvaluesorig);
						roll =false;
					
					}else if((inputenteredloop.toString().contains("n"))
						&&
							(inputenteredloop.toString().trim().length()==1)){
						roll =false;
					}else{
						System.out.print("\nPlease enter valid values (y/n):");
					}	
			    }
			    roll =true;
			    while(roll){
			    	System.out.print("\nDo you wish to continue from start (y/n):");
			    	end=new StringBuilder(input.nextLine());
			    	if(end.toString().contains("y")  && 
		    				(end.toString().trim().length()==1)){	
			    		 roll = false;
		    		}
			    	else if(end.toString().contains("n")  && 
			    				(end.toString().trim().length()==1)){
			    			start = false;	
			    			roll = false;
			    	}else{
			    			System.out.print("\nPlease enter valid values (y/n):");
			    		}	
			    }
			}
	    }	
	}	
}
