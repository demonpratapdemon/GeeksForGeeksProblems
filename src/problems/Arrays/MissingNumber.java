/**
 * 
 */
package problems.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author PRATAP
 *
 */
public class MissingNumber {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int length = Integer.parseInt(br.readLine());
			int[] arr = new int[length - 1];
			String input = br.readLine();
			int j = 0;
			for (String no : input.split(" "))
				arr[j++] = Integer.parseInt(no);
			findMissingNumber(arr, length);
		}
	}

	private static void findMissingNumber(int[] arr, int length) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int missing = 1;
		for (int i = length - 2; i >= 0; i--) {
			if (arr[i] != length) {
				missing = length;
				break;
			}
			length--;
		}
		System.out.println(missing);
	}

}
