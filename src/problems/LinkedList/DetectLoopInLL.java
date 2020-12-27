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
public class DetectLoopInLL {

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
			int x = Integer.parseInt(br.readLine());
			Utility.makeloop(head, tail, x);

			boolean ans = detectLoop(head);
			System.out.println(ans);
		}
	}

	private static boolean detectLoop(Node head) {
		// Add code here
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

}
