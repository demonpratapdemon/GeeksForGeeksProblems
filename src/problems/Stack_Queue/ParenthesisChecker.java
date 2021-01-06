/**
 * 
 */
package problems.Stack_Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class ParenthesisChecker {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String input = br.readLine();
			if (parChecker(input))
				System.out.println("balanced");
			else
				System.out.println("not balanced");
		}
	}

	private static boolean parChecker(String input) {
		// TODO Auto-generated method stub
		if (input.length() == 0)
			return true;
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '[' || input.charAt(i) == '{' || input.charAt(i) == '(')
				stack.push(String.valueOf(input.charAt(i)));
			else {
				if (stack.isEmpty())
					return false;
				if(input.charAt(i) == ']' && stack.peek().equalsIgnoreCase("["))
					stack.pop();
				else if(input.charAt(i) == '}' && stack.peek().equalsIgnoreCase("{"))
					stack.pop();
				else if(input.charAt(i) == ')' && stack.peek().equalsIgnoreCase("("))
					stack.pop();
				else
					return false;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}

}
