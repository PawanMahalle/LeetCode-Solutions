/**
 * Problem Statement: https://leetcode.com/problems/find-the-duplicate-number
 * 
 * @author PawanMahalle
 *
 */

public class Solution {
    public int findDuplicate(int[] nums) {
       
   for(int i = 0 ; i < nums.length; i++){
            int value = Math.abs(nums[i]);
            if(nums[value] < 0){
                return value;
            }else{
                nums[value] *= -1;
             }
        }
        return -1;
    }
}
