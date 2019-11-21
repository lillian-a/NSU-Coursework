import java.util.*;
/**
 * User Input - get response from user for boolean question
 * @author Lillian Arguelles
 *
 */
public class UserInput {
	
	public boolean getResponse() {
		// start scanner
		Scanner scan = new Scanner(System.in);
		// ask user a question
		System.out.println("Print Job Status? Enter Yes or No:");
		// bool variable to repeat
		boolean flag = true;
		while(flag) {
			// read in user answer and change it to lowercase
			String ans = scan.nextLine().toLowerCase();
			// set repeat to false
			flag = false;
			// check users answer
			// return true for yes
			//	  or false for no
			switch (ans) {
			case "yes" : case "y":
				return true;
			case "no" : case "n" :
				return false;
			default:
				// if bad answer, print message and loop again
				System.out.println("Answer not valid.");
				System.out.println("Enter: 'YES', 'NO', 'Y' or 'N'");
				System.out.println("Try again...");
				flag = true;
			}
		}
		// close scanner
		scan.close();
		return flag;
	}
}
