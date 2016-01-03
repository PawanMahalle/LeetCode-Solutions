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
 * Problem Statement: https://leetcode.com/problems/path-sum-ii
 * 
 * @author PawanMahalle
 *
 */
public class Solution {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> listOfPath = new ArrayList<List<Integer>>();
		pathSumList(root, 0, sum, listOfPath, null);
		return listOfPath;
	}

	private void pathSumList(TreeNode root, int currentSum, int targetSum, List<List<Integer>> listOfPath,
			List<Integer> currentPath) {

		//Return when leaf of tree is reached
		if (root == null) {
			return;
		}

		//Add value of node to sum obtained so far for current path into currentSum
		currentSum += root.val;
		
		//Keep track of nodes visited in path into currentPath
		if (currentPath == null) {
			currentPath = new ArrayList<Integer>();
		}
		currentPath.add(root.val);

		//If sum of value equals the target sum, save the currentPath which gives desired sum
		if (currentSum == targetSum && root.left == null && root.right == null) {
			listOfPath.add(currentPath);
		}

		List<Integer> leftCurrentPath = new ArrayList<>(currentPath);
		if (root.left != null) {
			pathSumList(root.left, currentSum, targetSum, listOfPath, leftCurrentPath);
		}

		List<Integer> rightCurrentPath = new ArrayList<>(currentPath);
		if (root.right != null) {
			pathSumList(root.right, currentSum, targetSum, listOfPath, rightCurrentPath);
		}
	}
}