import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionSlidingWindow {
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	
    	if(nums.length == 0){
    		return new int[]{};
    	}
    	
    	Queue<Integer> queue = new PriorityQueue(k+1,Collections.reverseOrder());
    	
    	for(int i = 0; i <k ; i++){
    		queue.add(nums[i]);
    	}
    	
    	int result[] = new int[nums.length - k + 1];
    	result[0] = queue.peek();
    	System.out.println(result[0]);
    	for(int i = k; i < nums.length; i++){
    		queue.remove(nums[i-k]);
    		queue.add(nums[i]);
    		result[i-k+1] = queue.peek();
    		System.out.println(result[i-k+1]);
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		new SolutionSlidingWindow().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
	}
}