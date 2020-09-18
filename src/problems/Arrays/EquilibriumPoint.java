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
public class EquilibriumPoint {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			int size = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[size];
			int i = 0;
			for (String s : input)
				arr[i++] = Integer.parseInt(s);
			int pos = equilibriumPoint(arr);
			System.out.println(pos);
		}
	}

	private static int equilibriumPoint(int[] arr) {
		// TODO Auto-generated method stub
		if (arr.length == 1)
			return 1;
		int sum = arr[0];
		int pos = -1;
		int currentSum = 0;
		for (int j = 2; j < arr.length; j++) {
			currentSum += arr[j];
		}
		for (int i = 1; i < arr.length; i++) {
			if (currentSum == sum) {
				pos = i + 1;
				break;
			}
			sum += arr[i];
			if((i + 1) < arr.length)
			    currentSum -= arr[i + 1];
		}
		return pos;
	}

}
