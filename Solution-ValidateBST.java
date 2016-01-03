/**
 * 
 * Problem Statement: https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * @author PawanMahalle
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return (checkBST(root, null)==null)?false:true;
    }
    
    private TreeNode checkBST(TreeNode root, TreeNode prev) {

		// Return prev when null leaf is reached
		if (root == null) {
			return prev;
		}

		// Keep currentPrev to maintain the prev obtained in left subtree
		TreeNode currentPrev = null;
		currentPrev = checkBST(root.left, prev);
		
		// checkBST() returns null when tree is not BST. Propogate the null to
		// all parent calls when pcurrentPrev is null while left sub tree is not empty
		if (root.left != null && currentPrev == null) {
			return null;
		}

		// If root data is smaller than prev data from left subtree, we know
		// tree cannot be a BST
		if (currentPrev != null && currentPrev.val >= root.val) {
			// WE are sure here that tree is not BST
			return null;
		}

		currentPrev = root;

		currentPrev = checkBST(root.right, currentPrev);
		return currentPrev;
	}

}