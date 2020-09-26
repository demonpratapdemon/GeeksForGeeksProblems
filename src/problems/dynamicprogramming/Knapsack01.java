/**
 * 
 */
package problems.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class Knapsack01 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- != 0) {
			/*
			 * Input: ------- 1. no of items 2. weight array of each item 3. profit array of
			 * each item
			 */
			int n = Integer.parseInt(br.readLine());
			int w = Integer.parseInt(br.readLine());
			int[] profits = new int[n];
			String[] input = br.readLine().split("\\s+");
			int p = 0;
			for (String s : input)
				profits[p++] = Integer.parseInt(s);
			int[] weights = new int[n];
			input = br.readLine().split("\\s+");
			p = 0;
			for (String s : input)
				weights[p++] = Integer.parseInt(s);
//			int profit = knapsackTopDown(0, w, profits, weights);
			int profit = knapsackBottomUp(n, w, profits, weights);
			System.out.println(profit);
		}
	}

	private static int knapsackBottomUp(int n, int w, int[] profits, int[] weights) {
		// TODO Auto-generated method stub
		int[][] cache = new int[n + 1][w + 1];
		for (int i = 0; i <= w; i++)
			cache[0][i] = 0;
		for (int i = 1; i <= n; i++)
			cache[i][0] = 0;
		int i=0, j = 0;
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= w; j++) {
				if (weights[i - 1] > j) {
					cache[i][j] = cache[i - 1][j];
				} else {
					cache[i][j] = Math.max(cache[i - 1][j], profits[i - 1] + cache[i - 1][j - weights[i - 1]]);
				}
			}
		}
		return cache[i - 1][j - 1];

	}

	@SuppressWarnings("unused")
	private static int knapsackTopDown(int n, int w, int[] profits, int[] weights) { // Top Down Memoization
		// TODO Auto-generated method stub
		int profit1 = 0, profit2 = 0;
		if (n > weights.length - 1 || w == 0)
			return 0;
		else if (weights[n] > w)
			return knapsackTopDown(n + 1, w, profits, weights);
		else {
			profit1 += profits[n] + knapsackTopDown(n + 1, w - weights[n], profits, weights);
			profit2 += knapsackTopDown(n + 1, w, profits, weights);
			return Math.max(profit1, profit2);
		}
	}

}
