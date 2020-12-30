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
public class Add2Numbers {

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
			Node head1 = new Node(Integer.parseInt(input[0]));
			Node tail1 = head1;
			for (int i = 1; i < n; i++) {
				tail1.next = new Node(Integer.parseInt(input[i]));
				tail1 = tail1.next;
			}

			int m = Integer.parseInt(br.readLine());
			input = br.readLine().split("\\s+");
			Node head2 = new Node(Integer.parseInt(input[0]));
			Node tail2 = head2;
			for (int i = 1; i < m; i++) {
				tail2.next = new Node(Integer.parseInt(input[i]));
				tail2 = tail2.next;
			}

			Node solution = addLists(head1, head2);
			Utility.printList(solution);
		}
	}

	private static Node addLists(Node first, Node second) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		while (first != null) {
			sb.append(first.data + " ");
			first = first.next;
		}
		String[] num1 = sb.reverse().toString().trim().split("\\s+");
		sb.delete(0, sb.length());
		while (second != null) {
			sb.append(second.data + " ");
			second = second.next;
		}
		String[] num2 = sb.reverse().toString().trim().split("\\s+");
		int sum = 0;
		int carry = 0;
		StringBuilder finalSum = new StringBuilder();
		int i = 0;
		if (num1.length >= num2.length) {
			for (; i < num2.length; i++) {
				sum = Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + carry;
				if (sum >= 10) {
					carry = sum / 10;
					finalSum.append(sum % 10 + " ");
				} else {
					carry = 0;
					finalSum.append(sum % 10 + " ");
				}
			}
			for (; i < num1.length; i++) {
				sum = Integer.parseInt(num1[i]) + carry;
				if (sum >= 10) {
					carry = sum / 10;
					finalSum.append(sum % 10 + " ");
				} else {
					carry = 0;
					finalSum.append(sum % 10 + " ");
				}
			}
			if(carry > 0) {
				finalSum.append(carry + " ");
			}
		} else {
			for (; i < num1.length; i++) {
				sum = Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + carry;
				if (sum >= 10) {
					carry = sum / 10;
					finalSum.append(sum % 10 + " ");
				} else {
					carry = 0;
					finalSum.append(sum % 10 + " ");
				}
			}
			for (; i < num2.length; i++) {
				sum = Integer.parseInt(num2[i]) + carry;
				if (sum >= 10) {
					carry = sum / 10;
					finalSum.append(sum % 10 + " ");
				} else {
					carry = 0;
					finalSum.append(sum % 10 + " ");
				}
			}
			if(carry > 0) {
				finalSum.append(carry + " ");
			}
		}

		String[] arr = finalSum.reverse().toString().trim().split("\\s+");
		Node sol = new Node(Integer.parseInt(arr[0]));
		Node temp = sol;
		for (i = 1; i < arr.length; i++) {
			Node newNode = new Node(Integer.parseInt(arr[i]));
			temp.next = newNode;
			temp = temp.next;
		}
		return sol;
	}

}
