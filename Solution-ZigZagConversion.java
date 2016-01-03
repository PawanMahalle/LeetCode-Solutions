/**
 * 
 * Problem Statement: https://leetcode.com/problems/zigzag-conversion
 * 
 * @author PawanMahalle
 *
 */

public class Solution {
	
	public String convert(String str, int n) {

		StringBuilder result = new StringBuilder();

		// If n == 1, result is same as input string
		if (n == 1) {
			return str;
		}

		for (int row = 0; row < n; row++) {

			for (int i = row; i < str.length();) {

				// Append the character at i to result
				result.append(str.charAt(i));

				if (row == 0 || row == n - 1) {
					// If row is even like 0, 2 and so on. Jump the string by n
					// + (n/2) length
					i += (2 * n - 2);
				} else {
					i += (2 * n - 2);
					int middle = i - 2 * row;
					if (middle >= str.length()) {
						break;
					}
					result.append(str.charAt(middle));
				}

			}
		}

		return result.toString();

	}
}