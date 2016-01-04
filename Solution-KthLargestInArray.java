/**
 * Problem Statement: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * @author PawanMahalle
 *
 */

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();        
        for(int i = 0; i < k; i++){
        	minHeap.add(nums[i]);
        }
        
        for(int i = k; i < nums.length; i++){
        	int minValue = minHeap.peek();
        	if(minValue < nums[i]){
        		minHeap.poll();
        		minHeap.add(nums[i]);
        	}
        }
        
        return minHeap.poll();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().findKthLargest(new int[]{3,2}, 1));
	}
}