import java.util.ArrayList;
import java.util.List;

/**
 * Problem statement: https://leetcode.com/problems/combinations/
 * 
 * Description: Return all possible combinations of size k of n integers.
 *
 * @author PawanMahalle
 *
 */
public class Solution {
	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> listOfCombinations = new ArrayList<List<Integer>>();
		
		for(int  position = 1; position <= n; position++){
			populate(n, k, position, listOfCombinations, new ArrayList<Integer>());
		}

		return listOfCombinations;
	}

	private void populate(int n, int k, int pos, List<List<Integer>> list, List<Integer> ref) {
		
		List<Integer> subList = new ArrayList<>(ref);
		subList.add(pos);
		if(subList.size() == k){
			list.add(subList);
			return;
		}

		for(int nextPos = pos +1 ; nextPos <= n; nextPos++){
			populate(n, k, nextPos, list, subList);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().combine(4, 2));
	}
}