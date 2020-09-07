/**
 * 
 */
package problems.util;

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
}
