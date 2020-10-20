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
public class FormaPalindrome {

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
			StringBuilder str = new StringBuilder(br.readLine());
			int characters = formPalindrome(str);
			System.out.println(characters);
		}
	}

	private static int formPalindrome(StringBuilder str) {
		// TODO Auto-generated method stub
		if (str.length() == 0 || str.length() == 1)
			return 0;
		int lcs = lcs(str.toString(), str.reverse().toString(), str.length(), str.length());
		return str.length() - lcs;
	}

	private static int lcs(String str1, String str2, int m, int n) {
		// TODO Auto-generated method stub
		// base condition
		if (m == 0 || n == 0)
			return 0;
		int[][] cache = new int[m + 1][n + 1];
		// for base condition
		for (int i = 0; i <= n; i++) {
			cache[0][i] = 0;
		}
		// for base condition
		for (int i = 1; i <= m; i++) {
			cache[i][0] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					cache[i][j] = 1 + cache[i - 1][j - 1];
				else {
					cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
				}
			}
		}
		return cache[m][n];
	}

}
