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
public class Merge2SortedArrays {

	/**
	 * @param args Cannot use extra space for sorting
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int length1, length2;
			String[] lengths = br.readLine().split(" ");
			length1 = Integer.parseInt(lengths[0]);
			length2 = Integer.parseInt(lengths[1]);
			if (length1 > length2) {
				length1 += length2;
			} else {
				length2 += length1;
			}
			int[] arr1 = new int[length1];
			int[] arr2 = new int[length2];
			String input1 = br.readLine();
			int j = 0;
			for (String no : input1.split(" "))
				arr1[j++] = Integer.parseInt(no);
			j = 0;
			input1 = br.readLine();
			for (String no : input1.split(" "))
				arr2[j++] = Integer.parseInt(no);
			mergeSortedArrays(arr1, arr2, length1, length2);
		}
		br.close();
	}

	private static void mergeSortedArrays(int[] arr1, int[] arr2, int length1, int length2) {
		// TODO Auto-generated method stub
		int j = 0;
		StringBuilder sb = new StringBuilder();
		if (length1 > length2) {
			for (int i = length1 - length2; i < length1; i++) {
				arr1[i] = arr2[j++];
			}
			Arrays.sort(arr1);
			for (int i = 0; i < arr1.length; i++) {
				sb.append(arr1[i] + " ");
			}
		} else {
			for (int i = length2 - length1; i < length2; i++) {
				arr2[i] = arr1[j++];
			}
			Arrays.sort(arr2);
			for (int i = 0; i < arr2.length; i++) {
				sb.append(arr2[i] + " ");
			}
		}
		System.out.println(sb.toString());
	}
}
