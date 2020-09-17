/**
 * 
 */
package problems.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class SpiralTraversalInMatrix {

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
			String[] colRow = br.readLine().split(" ");
			int rows = Integer.parseInt(colRow[0]);
			int cols = Integer.parseInt(colRow[1]);
			int[][] arr = new int[rows][cols];
			String[] input;
			input = br.readLine().split(" ");
			int k = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					arr[i][j] = Integer.parseInt(input[k++]);
				}
			}
			spiralTraversal(arr, rows, cols);
		}
	}

	private static void spiralTraversal(int[][] arr, int rows, int cols) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		int startRowIndex = 0, endRowIndex = rows - 1, startColIndex = 0, endColIndex = cols - 1;
		while (startRowIndex <= endRowIndex && startColIndex <= endColIndex) {
			for (int i = startColIndex; i <= endColIndex; i++) {
				sb.append(arr[startRowIndex][i] + " ");
			}
			startRowIndex++;
			for (int i = startRowIndex; i <= endRowIndex; i++) {
				sb.append(arr[i][endColIndex] + " ");
			}
			endColIndex--;
			if (startRowIndex <= endRowIndex) {
				for (int i = endColIndex; i >= startColIndex; i--) {
					sb.append(arr[endRowIndex][i] + " ");
				}
				endRowIndex--;
			}
			if (startColIndex <= endColIndex) {
				for (int i = endRowIndex; i >= startRowIndex; i--) {
					sb.append(arr[i][startColIndex] + " ");
				}
				startColIndex++;
			}
		}
		System.out.println(sb.toString().trim());
	}

}
