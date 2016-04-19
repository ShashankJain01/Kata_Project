package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import validation.*;
import common.*;


public class Cases {
	
	/*
	 * Valid Test Cases
	 */
	   String[] input1={"4","5","6","2","5"};
	   String[] input2={"1","4","2","4","4"};
	   String[] input3={"1","2","3","1","1"};
	   
	/*
	 * InValid Test Cases
	 */	   
	   String[] input4={"99","11","4","5"};
	   String[] input5={"1","3","6"};
	   
	   CheckValidateEvaluate CheckValidateEvaluate = new CheckValidateEvaluate();

	@Test
	public void test() {
		   
		   assertEquals(Main.valid,CheckValidateEvaluate.validate(input1)); 
		   assertEquals(Main.valid,CheckValidateEvaluate.validate(input2)); 
		   assertEquals(Main.valid,CheckValidateEvaluate.validate(input3)); 
		   assertEquals(Main.valid,CheckValidateEvaluate.validate(input4));
		   assertEquals(Main.valid,CheckValidateEvaluate.validate(input5));
		   
	}

}
