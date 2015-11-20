public class SolutionProductOfArray {
	public int[] productExceptSelf(int[] nums) {
		int left[] = new int[nums.length + 1];
		int right[] = new int[nums.length + 2];
		left[0] = 1;
		right[nums.length + 1] = 1;
		for (int i = 1; i <= nums.length; i++) {

			left[i] = left[i - 1] * nums[i - 1];

			right[nums.length - i + 1] = right[nums.length - i + 2] * nums[nums.length - i + 1 - 1];

		}

		int result[] = new int[nums.length];
		for (int i = 1; i <= nums.length; i++) {
			result[i - 1] = left[i - 1] * right[i + 1];
		}
		return result;
	}

	public static void main(String[] args) {
		int result[] = new SolutionProductOfArray().productExceptSelf(new int[] { 0, 0 });
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
