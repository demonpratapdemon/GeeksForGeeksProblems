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
public class RemoveDuplicates {

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
			String s = br.readLine();
			String result = removeDups(s);
			System.out.println(result);
		}
	}

	static String removeDups(String S) {
		// code here
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (sb.lastIndexOf(String.valueOf(S.charAt(i))) < 0)
				sb.append(S.charAt(i));
		}
		return sb.toString();
	}

}
