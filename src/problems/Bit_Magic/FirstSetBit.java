/**
 * 
 */
package problems.Bit_Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class FirstSetBit {

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
			int n = Integer.parseInt(br.readLine());
			System.out.println(getFirstSetBit(n));
		}
	}

	public static int getFirstSetBit(int n) {

		// Your code here
		if (n == 0)
			return 0;
		if (n % 2 != 0)
			return 1;
		int pos = 1;
		while (n > 0) {
			n /= 2;
			if (n % 2 != 0) {
				pos++;
				break;
			}
			pos++;
		}
		return pos;
	}

}
