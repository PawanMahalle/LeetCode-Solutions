/**
 * Problem Statement: https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * Description: Finds total number of unique BSTs possible for n numbers from 1 to n
 * 
 * @author PawanMahalle
 *
 */
public class Solution {
	
    public int numTrees(int n) {
    	
        //Special case when n = 0
    	if(n == 0){
    		return 0;
    	}
    	
    	int[] treeCount = new int[n+1];
        
    	treeCount[0] = 1;
    	treeCount[1] = 1;
    	
    	for(int treeSize = 2; treeSize <= n; treeSize++){
    		treeCount[treeSize] = 0;
    		for(int leftTreeSize = 0; leftTreeSize < treeSize; leftTreeSize++){
    			treeCount[treeSize] += (treeCount[leftTreeSize] * treeCount[treeSize - leftTreeSize - 1]);
    		}
    	}
    	return treeCount[n];
    }
}