/**
 * 
 */
package problems.util;

import java.util.LinkedList;
import java.util.Queue;

import problems.Entity.Node;
import problems.Entity.TreeNode;

/**
 * @author PRATAP
 *
 */
public class Utility {

	public static boolean binarySearch(int[] newArr, int item) {

		int start = 0;
		int end = newArr.length - 1;
		int mid;
		if (item > newArr[end] || item < newArr[start])
			return false;
		while (start <= end) {
			mid = (start + end) / 2;
			if (newArr[mid] == item)
				return true;
			if (newArr[mid] < item)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return false;
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void makeloop(Node head, Node tail, int x) {
		// TODO Auto-generated method stub
		if (x == 0)
			return;
		Node curr = head;
		for (int i = 1; i < x; i++) {
			curr = curr.next;
		}
		tail.next = curr;
	}

	public static TreeNode createBinaryTree(String[] input) {
		// TODO Auto-generated method stub
		if (input.length == 0 || input[0].equalsIgnoreCase("N"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(input[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int i = 1;
		String currval;
		while (q.size() > 0 && i < input.length) {
			TreeNode curr = q.remove();
			currval = input[i];
			if (!currval.equalsIgnoreCase("N")) {
				curr.left = new TreeNode(Integer.parseInt(currval));
				q.add(curr.left);
			}
			i++;
			if (i >= input.length)
				break;
			currval = input[i];
			if (!currval.equalsIgnoreCase("N")) {
				curr.right = new TreeNode(Integer.parseInt(currval));
				q.add(curr.right);
			}
			i++;
		}
		return root;
	}
}
