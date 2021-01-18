/**
 * 
 */
package problems.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import problems.Entity.TreeNode;
import problems.util.Utility;

/**
 * @author PRATAP
 *
 */
public class VerticalOrderTraversal {

	public static class Pair {
		public TreeNode treeNode;
		public int col;

		public Pair(TreeNode treeNode, int col) {
			super();
			this.treeNode = treeNode;
			this.col = col;
		}

	}

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
			System.out.println(
					"Enter the node values of the tree space separated and whenever there is no node please enter N");
			String[] input = br.readLine().split("\\s+");
			TreeNode root = Utility.createBinaryTree(input);
			Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
			List<List<Integer>> verticalOrdList = verticalTraversal(root, map);
			StringBuilder sb = new StringBuilder();
			for (List<Integer> list : verticalOrdList) {
				for (Integer data : list) {
					sb.append(data + " ");
				}
			}
			System.out.println(sb.toString().trim());
		}
	}

	private static List<List<Integer>> verticalTraversal(TreeNode root, Map<Integer, List<Integer>> map) {
		// TODO Auto-generated method stub
		bfsTraversal(root, map);
		List<List<Integer>> list = new ArrayList<>();
		for(Entry<Integer, List<Integer>>  ls: map.entrySet()) {
			List<Integer> newlist = new ArrayList<Integer>();
			for(Integer in : ls.getValue()) {
				newlist.add(in);
			}
			list.add(newlist);
		}
		
		return list;
	}

	private static void bfsTraversal(TreeNode root, Map<Integer, List<Integer>> map) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(root, 0));
		Pair curr;
		int size;
		Map<Integer,Set<Integer>> temp = null;
		while (!queue.isEmpty()) {
			size = queue.size();
			Set<Integer> set = new TreeSet<Integer>();
			temp= new TreeMap<>();
			while (size-- > 0) {
				curr = queue.remove();
				temp.putIfAbsent(curr.col, new TreeSet<Integer>());
				set = temp.get(curr.col);
				set.add(curr.treeNode.val);
				temp.put(curr.col, set);
				if (curr.treeNode.left != null) {
					queue.add(new Pair(curr.treeNode.left, curr.col - 1));
				}
				if (curr.treeNode.right != null) {
					queue.add(new Pair(curr.treeNode.right, curr.col + 1));
				}
			}
			
			for(Integer key :temp.keySet()){
                map.putIfAbsent(key,new ArrayList<>());
                List<Integer> l= new ArrayList<>(temp.get(key));
                map.get(key).addAll(l);
            }
			
			
		}
	}
}
