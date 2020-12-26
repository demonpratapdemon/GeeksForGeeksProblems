/**
 * 
 */
package problems.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class StockBuyAndSell {

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
			int arr[] = new int[n];
			int p = 0;
			for (String in : input) {
				arr[p++] = Integer.parseInt(in);
			}
			ArrayList<ArrayList<Integer>> solution = stockBuySell(arr, n);
			if (solution == null || solution.size() == 0)
				System.out.println("No Profit");
			else {
				for (int i = 0; i < solution.size(); i++)
					System.out.print("(" + solution.get(i).get(0) + " " + solution.get(i).get(1) + ") ");
			}
		}
	}

	private static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
		// TODO Auto-generated method stub
		if (A.length == 1)
			return null;
		int count = 0;
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		int min = -1, max = -1;
		for (int i = 0; i < n - 1; i++) {
		    if(A[i] == A[i+1])
		        continue;
			min = -1;
			max = -1;
			min = i;
			i++;
			while ((i < n) && (A[i] >= A[i - 1])) {
				i++;
			}
			max = --i;
			if (min != -1 && max != -1 && min != max) {
				solution.add(new ArrayList<Integer>());
				solution.get(count).add(min);
				solution.get(count).add(max);
				count++;
			}			
		}
		return solution;
	}

}
