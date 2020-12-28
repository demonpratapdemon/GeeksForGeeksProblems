/**
 * 
 */
package problems.LinkedList;

/**
 * @author PRATAP
 *
 */

class Node {
	int data;
	Node next, bottom;
	
	Node(int d) {
		this.data = d;
		this.bottom = null;
		this.next = null;
	}
}

public class FlatteningaLL {

	Node merged = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 Node flatten(Node root)
	    {
		    // Your code here
		    if(root == null)
		        return root;
		    Node temp = root;
		    while(temp != null) {
		        merge(temp);
		        temp = temp.next;
		    }
		    return merged;
	    }
	    
	    void merge(Node temp) {
	        if(merged == null){
	            merged = temp;
	            return;
	        }
	        Node newMerged = new Node(Integer.MIN_VALUE);
	        Node newNode;
	        Node head = newMerged;
	        while(merged!= null && temp!=null) {
	            if(merged.data <= temp.data) {
	                newNode = new Node(merged.data);
	                merged = merged.bottom;
	            } else {
	                newNode = new Node(temp.data);
	                temp = temp.bottom;
	            }
	            newMerged.bottom = newNode;
	            newMerged = newMerged.bottom;
	        }
	        if(merged!=null) {
	            newMerged.bottom = merged;
	        }
	        if(temp!=null){
	            newMerged.bottom = temp;
	        }
	        newMerged = head.bottom;
	        merged = newMerged;
	    }

}
