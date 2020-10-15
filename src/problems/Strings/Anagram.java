/**
 * 
 */
package problems.Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author PRATAP
 *
 */
public class Anagram {

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
			String[] input = br.readLine().split("\\s+");
			String output = checkAnagram(input);
			System.out.println(output);
		}
	}

	private static String checkAnagram(String[] input) {
		// TODO Auto-generated method stub
		if (input[0].length() != input[1].length())
			return "NO";
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		for (int i = 0; i < input[0].length(); i++) {
			if (hashMap.containsKey(input[0].charAt(i))) {
				int value = hashMap.get(input[0].charAt(i)).intValue();
				hashMap.put(input[0].charAt(i), --value);
			} else {
				hashMap.put(input[0].charAt(i), 1);
			}
			if (hashMap.containsKey(input[1].charAt(i))) {
				int value = hashMap.get(input[1].charAt(i)).intValue();
				hashMap.put(input[1].charAt(i), --value);
			} else {
				hashMap.put(input[1].charAt(i), 1);
			}
			if (hashMap.get(input[0].charAt(i)) == 0)
				hashMap.remove(input[0].charAt(i));
			if (hashMap.get(input[1].charAt(i)) != null && hashMap.get(input[1].charAt(i)) == 0)
				hashMap.remove(input[1].charAt(i));
		}
		if (hashMap.size() > 0)
			return "NO";
		else
			return "YES";
	}
}
