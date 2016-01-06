/**
 * Problem Statement: https://leetcode.com/problems/two-sum
 * 
 * @author PawanMahalle
 *
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> numberPosition = new HashMap<Integer, Integer>();
        
        for(int i = 0 ; i < nums.length; i++){
            int otherNumber = target - nums[i];
            
            Integer otherPosition = numberPosition.get(otherNumber);
            if(otherPosition != null){
                return new int[]{otherPosition, i + 1 };
            }else{
                numberPosition.put(nums[i], i + 1);
            }
        }
        return null;
    }
}