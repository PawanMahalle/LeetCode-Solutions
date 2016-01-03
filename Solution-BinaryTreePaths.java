/**
 * 
 * Problem Statement: https://leetcode.com/problems/binary-tree-paths/
 * 
 * Descripton: Returns all path from root to leaf in binary tree
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        generatePath(root, list, "");
        return list;
    }
    
    public void generatePath(TreeNode node, List<String> list, String prefix){
        
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right == null){
            if("".equals(prefix.toString())){
                prefix += String.valueOf(node.val); 
            }else{
                prefix += "->" + String.valueOf(node.val);
            }
            list.add(prefix.toString());
            return;
        }
        
        if("".equals(prefix.toString())){
            prefix += String.valueOf(node.val); 
        }else{
            prefix += "->" + String.valueOf(node.val);
        }
        
        generatePath(node.left, list, prefix);
        generatePath(node.right, list, prefix);
    }
}