/**
 * Class for just getting user input for a yes/no questuib
 * @author Lillian Arguelles
 */
import java.util.*;

public class UserInput {
	public UserInput() { }
	/**
	 * Get the answer to a yes or no question
	 * @param msg	question message to print to get answer from user
	 * @return boolean - True for Yes, False for No
	 */
	public boolean getAnswer(String msg) {
		Scanner in = new Scanner(System.in);
		System.out.println(msg);
		System.out.println("Type Y or N, then click Enter.");
		String ans = in.next();
		
		while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) {
		  System.out.println("\nInvalid response. Try again.");
		  System.out.println("Type Y or N, then click Enter.");
		  ans = in.next();
		} 
		
		if (ans.equalsIgnoreCase("n")) {
		  return false;
		} else {
		  return true;
		}
		
	}	
	
}
