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
public class NoOfPairs {

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
			String[] inputline;
			inputline = br.readLine().split(" ");
			int m = Integer.parseInt(inputline[0]);
			int n = Integer.parseInt(inputline[1]);
			int[] X = new int[m], Y = new int[n];
			inputline = br.readLine().split(" ");
			for (int i = 0; i < m; i++) {
				X[i] = Integer.parseInt(inputline[i]);
			}
			inputline = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				Y[i] = Integer.parseInt(inputline[i]);
			}

			long ans = new Solution().countPairs(X, Y, m, n);
			System.out.println(ans);
		}
	}

}

class Solution {
	long countPairs(int[] X, int[] Y, int m, int n) {
		// code here
		long count = 0;
		int[] numbersInY = new int[5]; // to store the count of 0,1,2,3,4
		for (int i = 0; i < n; i++) {
			if (Y[i] < 5) {
				numbersInY[Y[i]]++;
			}
		}
		Arrays.sort(Y);
		for (int i = 0; i < m; i++) {
			count += count(X[i], Y, n, numbersInY);
		}
		return count;
	}

	private long count(int x, int[] Y, int n, int[] numbersInY) {
		// TODO Auto-generated method stub
		if (x == 0)
			return 0;
		if (x == 1)
			return numbersInY[0];

		int pos = Arrays.binarySearch(Y, x);
		int totalPairs = 0;
		if (pos < 0) {
			pos = Math.abs(pos + 1); // it will give the position where x has to be inserted
			totalPairs += n - pos; // it will give the numbers >x
		} else { // x is found but we want >x and not >=x
			while (pos < n && Y[pos] == x) { // if same no exists multiple times in Y
				pos++;
			}
			totalPairs += n - pos;
		}

		totalPairs += numbersInY[0] + numbersInY[1]; // no of 0's and 1's in Y will be skipped and hence included
														// because
														// they also satisfy (x^y > y^x)

		if (x == 2)
			totalPairs -= numbersInY[3] - numbersInY[4];

		if (x == 3)
			totalPairs += numbersInY[2];

		return totalPairs;
	}
}
