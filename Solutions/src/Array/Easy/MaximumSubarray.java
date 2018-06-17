package Array.Easy;

public class MaximumSubarray {

     /*

     Given an integer array nums, find the contiguous subarray (containing at least one number)
     which has the largest sum and return its sum.

     Example:
     Input: [-2,1,-3,4,-1,2,1,-5,4],
     Output: 6
     Explanation: [4,-1,2,1] has the largest sum = 6.

     Follow up:
     If you have figured out the O(n) solution, try coding another solution using the
     divide and conquer approach, which is more subtle.

     */


    /**
     * The following solution uses Kadane's algorithms which is a pretty clever approach.
     * It assumes that the first elements is the maxSum so far.
     * Starting from the second element, if the second element is increasing the max sum,
     * we include that element in the max sum. If it is greater than the max sum, we forget
     * the previous max sum and start from that element assigning max sum as the value of that element.
     * In each iteration, we remember the maximum sum we have seen so far.
     * In the end, we return the max sum so far.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode = 17ms
     * Runtime beats 47.36% of Java submissions
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }

}
