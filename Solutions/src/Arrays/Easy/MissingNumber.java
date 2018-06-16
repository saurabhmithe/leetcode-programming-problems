package Arrays.Easy;

public class MissingNumber {

    // Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
    // find the one that is missing from the array.

    // Example 1:
    // Input: [3,0,1]
    // Output: 2

    // Example 2:
    // Input: [9,6,4,2,3,5,7,0,1]
    // Output: 8

    // Note:
    // Your algorithm should run in linear runtime complexity.
    // Could you implement it using only constant extra space complexity?


    /**
     * Since the numbers are in the range 0 - n, we can use
     * the series sum property n(n + 1) / 2 in our solution.
     * Find out what the sum of series would be and find
     * the actual sum of the given elements. The two sums would
     * differ by the number which is missing.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 1ms
     * Runtime beats 100% of Java submissions
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfSequence = (n * (n + 1)) / 2;

        int actualSum = 0;
        for (int i = 0; i < n; i++) {
            actualSum = actualSum + nums[i];
        }

        return sumOfSequence - actualSum;
    }
    
}
