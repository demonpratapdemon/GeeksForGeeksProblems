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
public class KadanesAlgorithm {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int length = Integer.parseInt(br.readLine());
			int[] arr = new int[length];
			String input = br.readLine();
			int j = 0;
			for (String no : input.split(" "))
				arr[j++] = Integer.parseInt(no);
			findMaxSumSubArray(arr);
		}
		br.close();
	}

	private static void findMaxSumSubArray(int[] arr) {
		// TODO Auto-generated method stub
		int localSum = arr[0], globalSum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			localSum = Math.max(localSum + arr[i], arr[i]);
			globalSum = Math.max(localSum, globalSum);
		}
		System.out.println(globalSum);
	}

}
