package problems.Arrays;

import java.util.Scanner;

/**
 * @author PRATAP
 *
 */
public class GivenSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int size, sum;
		for (int i = 1; i <= t; i++) {
			size = scanner.nextInt();
			sum = scanner.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = scanner.nextInt();
			}
			checkForGivenSum(arr, sum);
		}
		scanner.close();
	}

	private static void checkForGivenSum(int[] arr, int sum) {
		// TODO Auto-generated method stub
		int currentSum = 0;
		for (int i = 0; i < arr.length; i++) {
			currentSum = 0;
			currentSum += arr[i];
			if (currentSum == sum) {
				System.out.println((i + 1) + " " + (i + 1));
				return;
			}
			if (currentSum > sum)
				continue;
			for (int j = i + 1; j < arr.length; j++) {
				currentSum += arr[j];
				if (currentSum > sum)
					break;
				if (currentSum == sum) {
					System.out.println((i + 1) + " " + (j + 1));
					return;
				}
			}
		}
		System.out.println("-1");
	}
}
