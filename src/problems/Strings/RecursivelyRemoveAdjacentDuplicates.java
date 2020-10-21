/**
 * 
 */
package problems.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class RecursivelyRemoveAdjacentDuplicates {

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
			String output = removeAdjacentDuplicates(input);
			System.out.println(output);
		}
	}

	private static String removeAdjacentDuplicates(String input) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == input.charAt(i)) {
				stack.push(input.charAt(i));
				count++;
			} else {
				stack.push(input.charAt(i));
				count = 1;
			}
			if (i != input.length() - 1 && !stack.isEmpty() && stack.peek() != input.charAt(i + 1) && count > 1) {
				while (count > 0) {
					stack.pop();
					count--;
				}
			}
		}
		if (count > 1)
			while (count > 0) {
				stack.pop();
				count--;
			}
		Character cache = 0;
		boolean flag = false;
		while (!stack.isEmpty()) {
			cache = stack.pop(); // for continuous same character in stack
			while (!stack.isEmpty() && cache == stack.peek()) {
				stack.pop();
				flag = true;
			}
			if (sb.length() > 0 && sb.charAt(0) == cache) { // for continuous same character in the new string and hence
															// not updating the cache
				sb.deleteCharAt(0);
				continue;
			}
			if (!flag)
				sb.insert(0, cache);
			else {
				cache = 0;
				flag = false;
			}
		}
		return sb.toString();
	}

}
