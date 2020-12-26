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
public class RotateLinkedList {

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
			Node reverse = rotateLinkedList(head, k);
			Utility.printLis(reverse);
		}
	}

	private static Node rotateLinkedList(Node head, int k) {
		// TODO Auto-generated method stub
		if (head == null || head.next == null)
			return head;
		int n = 0;
		Node tail = head;
		while (tail.next != null) {
			n++;
			tail = tail.next;
		}
		n++;
		if (k == n)
			return head;
		else {
			Node temp;
			while (k-- > 0) {
				temp = head.next;
				tail.next = new Node(head.data);
				tail = tail.next;
				head = null;
				head = temp;
			}
		}
		return head;
	}

}
