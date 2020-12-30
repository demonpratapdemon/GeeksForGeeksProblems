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
public class ReverseLinkedListInGroup {

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
			int k = Integer.parseInt(br.readLine());
			Node reverse = reverseLinkedListInGroup(head, k);
			Utility.printList(reverse);
		}
	}

	private static Node reverseLinkedListInGroup(Node node, int k) {
		// TODO Auto-generated method stub
		if (node == null || node.next == null)
			return node;
		int count = 0;
		Node temp = node;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		if (k > count)
			return node;
		else {
			Node prev = null;
			Node next = node;
			Node finalHead = null;
			Node x = null;
			for (int i = 1; i <= count; i += k) {
				prev = null;
				for (int j = 1; j <= k; j++) {
					if (next == null)
						break;
					temp = next.next;
					next.next = prev;
					prev = next;
					next = temp;
				}
				if (finalHead == null) {
					finalHead = prev;
					x = finalHead;
				} else {
					x.next = prev;
				}

				while (x.next != null)
					x = x.next;

			}
			return finalHead;
		}
	}

}
