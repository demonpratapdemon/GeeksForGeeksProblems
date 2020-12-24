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
public class PythagoreanTriplet {

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
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] input = br.readLine().split("\\s+");
			int p = 0;
			for (String in : input)
				arr[p++] = Integer.parseInt(in);
			boolean output = checkTriplet(arr, n);
			System.out.println(output ? "Yes" : "No");
		}
	}

	private static boolean checkTriplet(int[] arr, int n) {
		// TODO Auto-generated method stub
		int[] sqarr = new int[n];
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			sqarr[i] = (int) Math.pow(arr[i], 2);
		}
		Arrays.sort(sqarr);
		int pos = -1;
		int x = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				x = (int) Math.pow(arr[i], 2) + (int) Math.pow(arr[j], 2);
				pos = Arrays.binarySearch(sqarr, x);
				if (pos >= 0) {
					flag = true;
					break;
				}
				if (flag)
					break;
			}
		}
		return flag;
	}

}
