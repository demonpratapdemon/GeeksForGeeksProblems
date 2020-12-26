/**
 * 
 */
package problems.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import problems.Entity.Node;

/**
 * @author PRATAP
 *
 */
public class FindMiddleElement {

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
			int ans = getMiddle(head);
			System.out.println(ans);
		}
	}

	private static int getMiddle(Node head) {
		// Your code here.
		Node faster = head, slower = head;
		if (head == null)
			return 0;
		else if (head.next == null)
			return head.data;
		else {
			slower = head.next;
			if (head.next != null)
				faster = head.next.next;
			while (faster != null && faster.next != null) {
				slower = slower.next;
				faster = faster.next.next;
			}
			return slower.data;
		}
	}

}
