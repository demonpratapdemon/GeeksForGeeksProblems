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
public class ChocolateDistribution {

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
			String[] input = br.readLine().split(" ");
			int[] arr = new int[size];
			int i = 0;
			for (String s : input)
				arr[i++] = Integer.parseInt(s);
			int noOfStudents = Integer.parseInt(br.readLine());
			int minimumDiff = distributeChocolates(arr, noOfStudents);
			System.out.println(minimumDiff);
		}
	}

	private static int distributeChocolates(int[] arr, int noOfStudents) {
		// TODO Auto-generated method stub
		if (noOfStudents > arr.length)
			return 0;
		Arrays.sort(arr);
		Integer currentMinimum = 999999999;
		for (int i = 0; i < arr.length; i++) {
			if ((i + noOfStudents - 1) < arr.length) {
				if ((arr[i + noOfStudents - 1] - arr[i]) < currentMinimum) {
					currentMinimum = arr[i + noOfStudents - 1] - arr[i];
				}
			}
		}
		return currentMinimum;
	}

}
