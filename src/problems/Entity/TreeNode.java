/**
 * 
 */
package problems.Entity;

/**
 * @author PRATAP
 *
 */
public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
		super();
	}

	public TreeNode(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
