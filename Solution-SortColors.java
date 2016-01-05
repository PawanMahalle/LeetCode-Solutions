/**
 * Problem Description: https://leetcode.com/problems/sort-colors/
 * 
 * @author PawanMahalle
 *
 */
public class Solution {
    
	public void sortColors(int[] nums) {
        int[] colorCount = new int[3];
        
        for(int i = 0; i < nums.length; i++){
            colorCount[nums[i]]++;
        }
        
        int k = 0;
        for(int i = 0; i <= 2; i++){
            while(colorCount[i]-- > 0){
                nums[k++] = i;
            }
        }
        
    }
    
    public static void main(String[] args) {
    	new Solution().sortColors(new int[]{0,1,2,0,2,1,2,2});
	}
}