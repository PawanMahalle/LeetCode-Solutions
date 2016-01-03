/**
 * Problem Statement: https://leetcode.com/problems/balanced-binary-tree/
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
    public boolean isBalanced(TreeNode root) {
        
        if(checkHeight(root) == -1){
            return false;
        }
        
        return true;
        
    }
    
    private int checkHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftHeight = checkHeight(node.left);
        if(leftHeight == -1){
        	return -1;
        }
        
        int rightHeight = checkHeight(node.right); 
        if(rightHeight == -1){
        	return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
       
    }
    
}