/**
 * 
 */
package problems.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author PRATAP
 *
 */
public class ReverseArrayInGroups {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine().trim());
		while (tc-- > 0) {
			String[] sizeAndGroup = br.readLine().split(" ");
			int size = Integer.parseInt(sizeAndGroup[0]);
			int group = Integer.parseInt(sizeAndGroup[1]);
			int[] arr = new int[size];
			String[] input = br.readLine().split(" ");
			int i = 0;
			for (String s : input)
				arr[i++] = Integer.parseInt(s);
			reverseArrayInGroup(arr, group);
		}
	}

	private static void reverseArrayInGroup(int[] arr, int group) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
			if (stack.size() == group) {
				while (!stack.isEmpty()) {
					str.append(String.valueOf(stack.pop()) + " ");
				}
			}
		}
		while (!stack.isEmpty()) {
			str.append(String.valueOf(stack.pop()) + " ");
		}
		System.out.println(str);
	}

}
