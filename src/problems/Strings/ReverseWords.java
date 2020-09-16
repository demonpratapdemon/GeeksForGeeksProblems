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
public class ReverseWords {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			String[] input = br.readLine().split("\\.");
			StringBuilder str = new StringBuilder();
			for (int i = input.length - 1; i >= 0; i--) {
				str.append(input[i] + ".");
			}
			str.deleteCharAt(str.length() - 1);
			System.out.println(str);
		}
		br.close();
	}

}
