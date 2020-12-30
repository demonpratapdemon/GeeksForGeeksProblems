/**
 * 
 */
package problems.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import problems.Entity.Node;
import problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class PairwiseSwap {

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
			Node head = new Node(Integer.parseInt(input[0]));
			Node tail = head;
			for (int i = 1; i < n; i++) {
				tail.next = new Node(Integer.parseInt(input[i]));
				tail = tail.next;
			}

			Node solution = pairwiseSwap(head);
			Utility.printList(solution);

		}
	}

	private static Node pairwiseSwap(Node head) {
		// TODO Auto-generated method stub
		if (head == null || head.next == null)
			return head;
		Node prev = head;
		Node next = head.next;
		int temp;
		while (next != null) {
			temp = next.data;
			next.data = prev.data;
			prev.data = temp;
			if (next.next != null) {
				prev = next.next;
				next = prev.next;
			} else {
				next = next.next;
			}
		}
		return head;
	}

}
