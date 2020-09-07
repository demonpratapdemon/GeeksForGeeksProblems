/**
 * 
 */
package problems.Arrays;

import java.util.Arrays;
import java.util.Scanner;

import problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class CountTriplets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 1; i <= t; i++) {
			int size = scanner.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = scanner.nextInt();
			}
			checkTriplets(arr);
		}
		scanner.close();
	}

	private static void checkTriplets(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		int count = 0, currentSum;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				currentSum = arr[i] + arr[j];
				if (Utility.binarySearch(arr, currentSum)) {
					count++;
				}
			}
		}
		if (count > 0)
			System.out.println(count);
		else
			System.out.println(-1);

	}

}
