package com.example.email_validator_ui;
public class validEmail {
	
	//3-1 Rules Declared Here
	
	//Method to check for the two specified rules in 3-1
	public static int validate(String address){
		//Integer to count the number of rules address has passed
		int rulesPassed = 0;
		//First check if an @ exists in the String
		if(address.indexOf("@") != -1){
			//Check if there DOESN'T exist another @ in the String
			if(address.indexOf("@", address.indexOf("@") + 1) == -1)
				//One @ only exists, increment the # of rules passed by 1
				rulesPassed++;
		}
		//Simply check if a . has an index position in the String
		//This means at least one . is present in the String
		if(address.indexOf(".") != -1)
			//Increment the # of rules passed by 1
			rulesPassed++;
		///////////////////////////////////////////////////////////
		//3-2 Rules Declared Here
		
		//A valid address cannot have any blank spaces present to be valid
		//If no blank spaces are present, increment the # of passed rules by 1
		if(address.indexOf(" ") == -1)
			rulesPassed++;
		
		//A valid address cannot have a number digit present as the first character
		//Using regex, if the address doesn't contain a digit as its first char, increment the # of passed rules by 1
		if(!address.matches("\\d.*"))
			rulesPassed++;	
		
		//Return the total # of rules address passed
		return rulesPassed;
	}
	
}
