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
public class ReverseLinkedList {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
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
			Node reverse = reverseLinkedList(head);
			Utility.printLis(reverse);
		}
	}

	private static Node reverseLinkedList(Node head) {
		// TODO Auto-generated method stub
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		Node next = head;
		Node prev = null;
		Node temp;
		while (next != null) {
			temp = next.next;
			next.next = prev;
			prev = next;
			next = temp;
		}
		return prev;
	}

}
