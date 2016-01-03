/**
 * 
 * Problem Statement: https://leetcode.com/problems/sliding-window-maximum/
 * 
 * @author PawanMahalle
 *
 */
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums.length == 0) {
			return new int[] {};
		}

		Queue<Integer> queue = new PriorityQueue<Integer>(k + 1, Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			queue.add(nums[i]);
		}

		int result[] = new int[nums.length - k + 1];
		result[0] = queue.peek();

		for (int i = k; i < nums.length; i++) {
			queue.remove(nums[i - k]);
			queue.add(nums[i]);
			result[i - k + 1] = queue.peek();
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
	}
}
