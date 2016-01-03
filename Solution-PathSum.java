/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Problem Statement: https://leetcode.com/problems/path-sum
 * 
 * @author PawanMahalle
 *
 */
public class Solution {

	public boolean hasPathSum(TreeNode root, int sum) {
		return hasPathSum(root, 0, sum);
	}

	private boolean hasPathSum(TreeNode root, int currentSum, int targetSum) {

		// If tree itself is null. Recurrsive call will never pass null to
		// pathSum()
		if (root == null) {
			return false;
		}

		currentSum += root.val;

		if (currentSum == targetSum && root.left == null && root.right == null) {
			return true;
		}

		if (root.left != null) {
			if (hasPathSum(root.left, currentSum, targetSum)) {
				return true;
			}
		}
		if (root.right != null) {
			if (hasPathSum(root.right, currentSum, targetSum)) {
				return true;
			}
		}
		return false;
	}

}