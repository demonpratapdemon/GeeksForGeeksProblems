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
public class KthSmallestElement {

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
			int size = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[size];
			int i = 0;
			for (String s : input)
				arr[i++] = Integer.parseInt(s);
			int kthsmallest = Integer.parseInt(br.readLine());
			System.out.println(findKthSmallest(arr, kthsmallest));
		}
	}

	private static int findKthSmallest(int[] arr, int kthsmallest) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		if (kthsmallest > arr.length)
			return 0;
		return arr[kthsmallest - 1];
	}

}
