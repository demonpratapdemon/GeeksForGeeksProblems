/**
 * 
 */
package problems.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author PRATAP
 *
 */
class Node {
	String character;
	int count;

	Node(String character, int count) {
		this.character = character;
		this.count = count;
	}
}

public class RearrangeCharacters {

	private static Map<String, Integer> map;
	static PriorityQueue<Node> maxHeap;

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
			String input = br.readLine();
			maxHeap = new PriorityQueue<Node>(new Comparator<Node>() {
					@Override
					public int compare(Node s1, Node s2) {
						if (s1.count == s2.count)
							return 0;
						else if (s1.count > s2.count)
							return -1;
						else
							return 1;
					}
				});
			map = new HashMap<String, Integer>();
			String solution = rearrangeCharacters(input);
			System.out.println(solution);
		}
	}

	private static String rearrangeCharacters(String str) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(String.valueOf(str.charAt(i)))) {
				map.put(String.valueOf(str.charAt(i)), 1);
			} else {
				count = map.get(String.valueOf(str.charAt(i)));
				count++;
				map.put(String.valueOf(str.charAt(i)), count);
			}
		}
		for (Entry<String, Integer> s : map.entrySet()) {
			Node node = new Node(s.getKey(), s.getValue());
			maxHeap.add(node);
		}
		String newStr = formRearrangedString();
		if (newStr.length() == str.length())
			return String.valueOf(1);
		else
			return String.valueOf(0);
	}

	private static String formRearrangedString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Node curr = null, prev = null;
		while (maxHeap.size() > 0) {
			if (curr != null) {
				prev = curr;
			}
			curr = maxHeap.remove();
			if (prev != null && curr.character.equalsIgnoreCase(prev.character))
				break;
			sb.append(curr.character);
			curr.count--;
			if (prev != null && prev.count > 0) {
				maxHeap.add(prev);
			}
		}
		return sb.toString().trim();
	}

}
