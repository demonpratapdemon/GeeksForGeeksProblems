/**
 * 
 */
package problems.util;

import problems.Entity.Node;

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
			System.out.print (node.data +" ");
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
}
