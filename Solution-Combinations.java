import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 */
public class Solution {
	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> list = new ArrayList();
		
		for(int  p = 1; p <= n; p++){
			populate(n, k, p, list, new ArrayList<Integer>());
		}

		return list;
	}

	private void populate(int n, int k, int pos, List<List<Integer>> list, List<Integer> ref) {
		
		List<Integer> subList = new ArrayList<>(ref);
		subList.add(pos);
		if(subList.size() == k){
			list.add(subList);
			return;
		}

		for(int nextPos = pos; nextPos < n; nextPos++){
			populate(n, k, nextPos+1, list, subList);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().combine(4, 3));
	}
}