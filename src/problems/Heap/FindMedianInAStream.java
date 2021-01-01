/**
 * 
 */
package problems.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
public class FindMedianInAStream {

//	Heaps are implemented using Priority Queues
	static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); // Comparator to implement max
																							// heap
	static PriorityQueue<Integer> min = new PriorityQueue<>();

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
			int x;
			for (int i = 1; i <= n; i++) {
				x = Integer.parseInt(br.readLine());
				inserHeap(x);
				System.out.println(getMedian());
			}
		}
	}

	private static double getMedian() {
		// TODO Auto-generated method stub
		if (max.size() == min.size())
			return (max.peek() + min.peek()) / 2;
		else if (max.size() > min.size())
			return max.peek();
		else
			return min.peek();
	}

	private static void inserHeap(int x) {
		// TODO Auto-generated method stub
		if (max.isEmpty() || max.peek() > x) {
			max.add(x);
		} else {
			min.add(x);
		}
		balanceHeaps();
	}

	private static void balanceHeaps() {
		// TODO Auto-generated method stub
		if (max.size() > min.size() + 1) {
			min.add(max.remove());
		} else if (min.size() > max.size() + 1) {
			max.add(min.remove());
		}
	}

}
