/**
 * Problem Statement: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return insertFromArray(nums, 0, nums.length-1, null);
    }
    
    private TreeNode insertFromArray(int[] arr, int start, int end, TreeNode rootBST) {
		
		if(start > end){
			return null;
		}
		
		int mid = start + (end-start)/2;
		rootBST = insertIntoBST(rootBST, arr[mid]);
		
		insertFromArray(arr, start, mid - 1, rootBST);
		insertFromArray(arr, mid + 1, end, rootBST);

		return rootBST;
	}

	
	private TreeNode insertIntoBST(TreeNode rootBST, int data) {
		
		if(rootBST == null){
			return new TreeNode(data);
		}
		
		if(data > rootBST.val){
			rootBST.right = insertIntoBST(rootBST.right, data);
		}else{
			rootBST.left = insertIntoBST(rootBST.left, data);
		}
		return rootBST;
	}
}