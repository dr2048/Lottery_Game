package lab1;

import java.util.Scanner;

public class CS234_Lab_1_DavidRomero {
	/**
	 * Generates a random integer between lowerLimit and upperLimit
	 * @param lowerLimit the lower limit on the random integer
	 * @param upperLimit the upper limit on the random integer 
	 * @return the random number between lowerLimit and upperLimit
	 */
	public static int GetRandomNumber(int lowerLimit, int upperLimit){
		
		int randomInteger = (int) ((upperLimit - lowerLimit + 1) * Math.random()) + lowerLimit; // (10 * Math.random()) + 1 
		
		return randomInteger;// returns randomInteger 

	}
	/**
	 * Check a number is in between two limits 
	 * @param n is an an integer number
	 * @param lowerLimit number that is the lower bound
	 * @param upperLimit number that is the upper bound
	 * @return boolean value whether the number is between the limits
	 */
	public static boolean checkDigitLen(int n, int lowerLimit, int upperLimit) {
		if (n >= lowerLimit && n <= upperLimit) {
			return true;
			
		}else {
			return false;
		}
	}
	/**
	 * Divide the number by 100 to get first digit of a three digit number
	 * @param n is an an integer number
	 * @return integer value for the first digit 
	 */
	public static int divBy100 (int n){
		
		int result = n / 100;		
		return result;// returns result 

	}
	/**
	 * It gets the second digit of a three digit number
	 * @param n is an an integer number
	 * @return integer value for the second digit
	 */
	public static int divBy10 (int n){
		
		int result = n % 100 / 10;	
		return result;// returns result

	}
	/**
	 * It gets the third digit of a three digit number
	 * @param n is an an integer number
	 * @return integer value for the third digit 
	 */
	public static int modBy10 (int n){ 
		
		int result = n % 100 % 10;
		return result;// returns result

	}
	/**
	 * Checks the digits for duplicate numbers
	 * @param d1 digit one
	 * @param d2 digit two
	 * @param d3 digit three
	 * @return boolean value for whether duplicates are present 
	 */
	public static boolean checkDupes (int d1, int d2, int d3){
		
		if(d1 == d2 || d2 == d3 || d1 == d3)
			return true; // dupes are present
		else
			return false; // dupes not present 
	}
	
	
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.print("Enter a three digit number: ");
		int userinput = reader.nextInt();
		
		boolean check = checkDigitLen(userinput, 100, 999); //Method to check if number is three 

		int userdigit1 = divBy100(userinput);//Method for integer division of 100
		int userdigit2 = divBy10(userinput); //Method for integer division of 10
		int userdigit3 = modBy10(userinput);//Method for Mod division of 10
		
		boolean userdupes = checkDupes(userdigit1,userdigit2,userdigit3); //method for dupes
		
		boolean enter = false;
		if (check == true && userdupes == false) {
			enter = true;
		}
		else {
			System.out.println("The number needs to be three unique digits.");
		}
		
		//Random Number
		int LotteryNum = 0;
		int digit1 = 0;
		int digit2 = 0;
		int digit3 = 0;
		boolean dupes = true;
		while(dupes) {
			LotteryNum = GetRandomNumber(100,999); 
			digit1 = divBy100(LotteryNum);//Method for inter division of 100
			digit2 = divBy10(LotteryNum);//Method for inter division of 10
			digit3 = modBy10(LotteryNum);//Method for Mod division of 10
			dupes = checkDupes(digit1,digit2,digit3);//method for dupes
		}
		
		//If numbers are fine then compare
		if (enter) { 
			System.out.println("The lottery number is: " + LotteryNum);
			//prize comparisons
			if(userinput == LotteryNum) {
				System.out.println("1st prize: three digits match in exact order. ");
			}
			else if((userdigit1 == digit1 || userdigit1 == digit2 || userdigit1 == digit3) &&
					(userdigit2 == digit1 || userdigit2 == digit2 || userdigit2 == digit3) &&
					(userdigit3 == digit1 || userdigit3 == digit2 || userdigit3 == digit3)) {
				System.out.println("2nd prize: three digits match, but not in exact order.");
			}
			else if((userdigit1 == digit1 && userdigit1 == digit2) || 
					(userdigit1 == digit1 && userdigit3 == digit3) ||
					(userdigit2 ==digit2 && userdigit3 == digit3)){
				System.out.println("3rd prize: two digits match in exact order.");
			}else if (((userdigit1 == digit1 || userdigit1 == digit2 || userdigit1 == digit3) &&
					   (userdigit2 == digit1 || userdigit2 == digit2 || userdigit2 == digit3)) ||
					  ((userdigit1 == digit1 || userdigit1 == digit2 || userdigit1 == digit3) &&
					   (userdigit3 == digit1 || userdigit3 == digit2 || userdigit3 == digit3)) ||
					  ((userdigit2 == digit1 || userdigit2 == digit2 || userdigit2 == digit3) &&
					  (userdigit3 == digit1 || userdigit3 == digit2 || userdigit3 == digit3))) {
				System.out.println("4th prize: two digits match, but not in exact order.");
			}else if(userdigit1 == digit1 || userdigit2 == digit2 || userdigit3 == digit3) {
				System.out.println("5th prize: one digit matches in exact positions");
			}else if((userdigit1 == digit1 || userdigit1 == digit2 || userdigit1 == digit3) ||
					 (userdigit2 == digit1 || userdigit2 == digit2 || userdigit2 == digit3) ||
					 (userdigit3 == digit1 || userdigit3 == digit2 || userdigit3 == digit3)) {
				System.out.println("6th prize: one digit matches, but not in the exact position");
			}else
				System.out.println("Sorry, you win nothing.");		
		}
		//once finished
		reader.close();
	}

}
