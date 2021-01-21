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
public class RightMostDifferentBit {

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
			String input[] = br.readLine().split("\\s+");
			int m = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			System.out.println(posOfRightMostDiffBit(m, n));
		}
	}

	private static int posOfRightMostDiffBit(int m, int n) {
		// TODO Auto-generated method stub
//		XOR will give only the bits where there is difference
//		Then we use the logic to find the first set bit from right
		return getFirstSetBit(m ^ n);
	}

	public static int getFirstSetBit(int n) {

		// Your code here
		if (n == 0)
			return 0;
		return (int) (Math.log(n & -n) / Math.log(2)) + 1;
	}

}
