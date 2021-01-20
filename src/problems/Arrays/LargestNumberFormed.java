/**
 * 
 */
package problems.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author PRATAP
 *
 */
public class LargestNumberFormed {

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
			String[] input = br.readLine().split("\\s+");
			String output = printLargest(input, n);
			System.out.println(output);
		}
	}

	private static String printLargest(String[] arr, int n) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
            	return (s2+s1).compareTo(s1+s2);
            }
        });
		for(String in :arr)
			sb.append(in);
		int leadZeros = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) != '0')
                break;
            if(sb.charAt(i) == '0') {
                leadZeros++;
            }
        }
        sb.delete(0, leadZeros);
        if(sb.length() == 0)
        	return String.valueOf(0);
		return sb.toString();
	}

}
