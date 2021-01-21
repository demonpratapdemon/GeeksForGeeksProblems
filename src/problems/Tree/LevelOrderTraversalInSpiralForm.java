/**
 * 
 */
package problems.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

import problems.Entity.TreeNode;
import problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class LevelOrderTraversalInSpiralForm {

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
			TreeNode root = Utility.createBinaryTree(input);
			ArrayList<Integer> list = findSpiral(root);
			StringBuilder sb = new StringBuilder();
			for (int i : list)
				sb.append(i + " ");
			System.out.println(sb.toString());
		}
	}

	private static ArrayList<Integer> findSpiral(TreeNode root) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> s1 = new Stack<TreeNode>(); // from left to right --> push right then left
		Stack<TreeNode> s2 = new Stack<TreeNode>(); // from right to left --> push left then right
		s1.push(root);
		TreeNode curr;
		int size;
		int temp = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			size = s1.size();
			if (size == 0)
				size = s2.size();
			while (size-- > 0) {
				if (temp == 0) {
					curr = s1.pop();
					if (curr.right != null)
						s2.push(curr.right);
					if (curr.left != null)
						s2.push(curr.left);
				} else {
					curr = s2.pop();
					if (curr.left != null)
						s1.push(curr.left);
					if (curr.right != null)
						s1.push(curr.right);
				}
				list.add(curr.val);
			}
			temp = 1 - temp;
		}
		return list;
	}

}
