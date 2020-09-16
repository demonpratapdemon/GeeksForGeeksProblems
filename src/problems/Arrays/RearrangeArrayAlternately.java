/**
 * 
 */
package problems.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class RearrangeArrayAlternately {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			int size = Integer.parseInt(br.readLine());
			int[] arr = new int[size];
			String[] inputs = br.readLine().split(" ");
			int i = 0;
			for (String str : inputs) {
				arr[i++] = Integer.parseInt(str);
			}
			alternates(arr);
		}
	}

	private static void alternates(int[] arr) {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder();
		int i = 0, j = arr.length - 1;
		for (; i < j; i++, j--) {
			result.append(String.valueOf(arr[j]) + " ");
			result.append(String.valueOf(arr[i]) + " ");
		}
		if (i == j) // in case of odd size of the array
			result.append(String.valueOf(arr[i]));
		System.out.println(result);
	}

}
