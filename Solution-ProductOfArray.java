/**
 * 
 * Problem Statement: https://leetcode.com/problems/product-of-array-except-self/
 * 
 * @author PawanMahalle
 *
 */
public class Solution {

	public int[] productExceptSelf(int[] nums) {
		
		//Declare left array that hold product of all elements left to a position.
		int leftProduct[] = new int[nums.length + 1];
		
		//Declare right array that hold product of all elements right to a position.
		int rightProduct[] = new int[nums.length + 2];
		
		//Initialize product of extreme left and extreme right to 1
		leftProduct[0] = 1;
		rightProduct[nums.length + 1] = 1;
		
		//For each element at position i, calculate left product and right product of i
		for (int i = 1; i <= nums.length; i++) {

			leftProduct[i] = leftProduct[i - 1] * nums[i - 1];

			rightProduct[nums.length - i + 1] = rightProduct[nums.length - i + 2] * nums[nums.length - i + 1 - 1];

		}

		int result[] = new int[nums.length];
		for (int i = 1; i <= nums.length; i++) {
			result[i - 1] = leftProduct[i - 1] * rightProduct[i + 1];
		}
		return result;
	}

	/*
	 * Driver code for testing
	 */
	public static void main(String[] args) {
		int result[] = new Solution().productExceptSelf(new int[] { 0, 0 });
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
