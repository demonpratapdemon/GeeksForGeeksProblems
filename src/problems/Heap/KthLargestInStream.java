/**
 * 
 */
package problems.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class KthLargestInStream {

//	static int kLargest;

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
			String[] numbers = br.readLine().split("\\s+");
			int k = Integer.parseInt(numbers[0]);
			int n = Integer.parseInt(numbers[1]);
			String[] input = br.readLine().split("\\s+");
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			for (int i = 0; i < k - 1; i++) {
				System.out.print("-1 ");
			}
			findKthLargest(arr, n, k);
			System.out.println();
		}
	}

	private static void findKthLargest(int arr[], int n, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		int i = 0;
		for (i = 0; i < k; i++) {
			minHeap.add(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (i = k; i < n; i++) {
			sb.append(minHeap.peek() + " ");
			if (arr[i] > minHeap.peek()) {
				minHeap.remove();
				minHeap.add(arr[i]);
			}
		}
		sb.append(minHeap.peek() + " ");
		System.out.print(sb.toString().trim());
	}

}
