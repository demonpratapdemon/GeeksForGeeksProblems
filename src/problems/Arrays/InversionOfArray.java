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
public class InversionOfArray {

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
			long count = countInversions(arr, 0, arr.length - 1);
			System.out.println(count);
		}
		br.close();
	}

	private static long countInversions(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			int mid = (left + right) / 2;
			return countInversions(arr, left, mid) + countInversions(arr, mid + 1, right)
					+ merge(arr, left, mid, right);
		}
		return 0;
	}

	private static long merge(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int[] b = new int[right - left + 1];
		int i = left, j = mid + 1;
		long countInversions = 0;
		int p = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				b[p++] = arr[i++];
			} else {
				b[p++] = arr[j++];
				countInversions += (mid - i + 1);
			}
		}
		while (i <= mid)
			b[p++] = arr[i++];
		while (j <= right)
			b[p++] = arr[j++];
		p = 0;
		for (int k = left; k <= right; k++) {
			arr[k] = b[p++];
		}
		return countInversions;
	}

}
