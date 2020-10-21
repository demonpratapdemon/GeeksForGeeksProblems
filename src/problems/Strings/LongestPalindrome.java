/**
 * 
 */
package problems.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class LongestPalindrome {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			String result = findLargestPalindromeSUbstring(str);
			System.out.println(result);
		}
	}

	private static String findLargestPalindromeSUbstring(String str) {
		// TODO Auto-generated method stub
		String palindromicSubstring = str.substring(0, 1);
		int[][] cache = new int[str.length()][str.length()]; // We only need the upper triangular matrix
		// base condition
		for (int i = 0; i < str.length(); i++) {
			cache[i][i] = 1; // filling diagonals with 1 as strings of length 1 are always Palindrome
		}
		// checking Palindrome for strings of length 2
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				cache[i][i + 1] = 1;
				if (palindromicSubstring.length() < 2)
					palindromicSubstring = str.substring(i, i + 2);
			} else
				cache[i][i + 1] = 0;
		}
		for (int i = 0; i < str.length() - 2; i++) {
			int k = str.length() - i - 2; // for keeping track of now of rows to be traversed in each iteration
			for (int j = 0; j < k; j++) { // for keeping track of rows and columns we need to check. Basically, they
											// rows indicate start index and column indicate end index
//				System.out.println("row = " + j + " col = " + (j + i + 2));
//				System.out.println("cache value = " + cache[j + 1][j + i + 1]);
				if (str.charAt(j) == str.charAt(j + i + 2) && cache[j + 1][j + i + 1] == 1) {
					cache[j][j + i + 2] = 1;
					if (palindromicSubstring.length() < i + 3) {
						/*
						 * for checking if the new palindromic substring we found is of greater length
						 * than the previous one or not. End index = j+i+2+(1) [substring(4,7] means 7
						 * is excluded and so substring 4 to 6 is considered] and Start index = j
						 */
						palindromicSubstring = str.substring(j, j + i + 3);
					}
				} else {
					cache[j][j + i + 2] = 0;
				}
			}
		}
		return palindromicSubstring;
	}

}
