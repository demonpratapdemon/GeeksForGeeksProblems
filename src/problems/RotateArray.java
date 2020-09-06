/**
 * 
 */
package problems;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author PRATAP
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int length, rotations;
		for (int i = 1; i <= n; i++) {
			length = scan.nextInt();
			rotations = scan.nextInt();
			int[] arr = new int[length];
			for (int j = 0; j < length; j++) {
				arr[j] = scan.nextInt();
			}
			System.out.println();
			rotateArray(arr, rotations);

		}
		scan.close();
	}

	private static void rotateArray(int[] arr, int rotations) {
		// TODO Auto-generated method stub
		rotations = rotations % arr.length;
		if (rotations > 0) {
			for (int i = 0 + rotations; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			for (int i = 0; i < rotations; i++) {
				System.out.print(arr[i] + " ");
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

}
