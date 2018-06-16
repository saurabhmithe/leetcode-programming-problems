package Arrays.Easy;

public class RotateArray {

    /*

    Given an array, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
    Input: [1,2,3,4,5,6,7] and k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:
    Input: [-1,-100,3,99] and k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

    Note:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

    */


    /**
     * The below mentioned algorithm is so simple that it almost seems like magic.
     * We can do the rotation in linear time by using the reversal technique.
     * This algorithm performs right rotation but similar approach can be used for left rotation as well.
     * If we wish to rotate the array to right by d places, we reverse the last d elements.
     * Similarly, we reverse the first n - d elements where n is the total number of elements in the array.
     * Now, to finish it off, we reverse the entire array.
     * Note: For left rotation, instead of reversing the last d elements, reverse the first d elements
     * and then reverse the last n - d elements. Everything else remains the same.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 1ms
     * Runtime beats 98.09% of Java submissions
     */
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) return;
        if (k > nums.length) k = k % nums.length;
        reverse(nums, nums.length - k, nums.length);
        reverse(nums, 0, nums.length - k);
        reverse(nums, 0, nums.length);
    }

    public void reverse(int[] nums, int a, int b) {
        for (int i = 0; i < (b - a) / 2; i++) {
            int tmp = nums[a + i];
            nums[a + i] = nums[b - i - 1];
            nums[b - i - 1] = tmp;
        }
    }
    
}
