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
public class IntersectionInYShapedLL {

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
			String[] sizes = br.readLine().split("\\s+");
			int n1 = Integer.parseInt(sizes[0]);
			int n2 = Integer.parseInt(sizes[1]);
			int n3 = Integer.parseInt(sizes[2]);

			String[] input = br.readLine().split("\\s+");
			Node head1 = new Node(Integer.parseInt(input[0]));
			Node tail1 = head1;
			for (int i = 1; i < n1; i++) {
				tail1.next = new Node(Integer.parseInt(input[i]));
				tail1 = tail1.next;
			}

			input = br.readLine().split("\\s+");
			Node head2 = new Node(Integer.parseInt(input[0]));
			Node tail2 = head2;
			for (int i = 1; i < n2; i++) {
				tail2.next = new Node(Integer.parseInt(input[i]));
				tail2 = tail2.next;
			}

			input = br.readLine().split("\\s+");
			Node head3 = new Node(Integer.parseInt(input[0]));
			Node tail3 = head3;
			tail1.next = head3;
			tail2.next = head3;
			
			for (int i = 1; i < n3; i++) {
				tail3.next = new Node(Integer.parseInt(input[i]));
				tail3 = tail3.next;
			}

			int intersect = intersectPoint(head1, head2);
			System.out.println(intersect);
		}
	}

	private static int intersectPoint(Node head1, Node head2) {
		// code here
		int len1 = 0, len2 = 0;
		Node temp1 = head1, temp2 = head2;
		while (temp1 != null) {
			len1++;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			len2++;
			temp2 = temp2.next;
		}
		int diff = Math.abs(len1 - len2);
		temp1 = head1;
		temp2 = head2;
		if (len1 > len2) {
			while (diff-- > 0) {
				temp1 = temp1.next;
			}
			while (temp1 != null) {
				if (temp1 == temp2)
					return temp1.data;
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		} else {
			while (diff-- > 0) {
				temp2 = temp2.next;
			}
			while (temp1 != null) {
				if (temp1 == temp2)
					return temp1.data;
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
		}
		return -1;
	}

}
