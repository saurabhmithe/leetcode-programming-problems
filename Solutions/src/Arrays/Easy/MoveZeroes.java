package Arrays.Easy;

public class MoveZeroes {

    // Given an array nums, write a function to move all 0's to the end of
    // it while maintaining the relative order of the non-zero elements.

    // Example:
    // Input: [0,1,0,3,12]
    // Output: [1,3,12,0,0]

    // Note:
    // You must do this in-place without making a copy of the array.
    // Minimize the total number of operations.


    /**
     * Maintain two pointers - the currentPointer and i.
     * currentPointer will point to the first element of the array.
     * Starting from the first element, if you find a non-zero element,
     * swap it with the value at currentPointer. By doing this, we are
     * simply shifting the non-zero values in the front of the array
     * and incrementing the current pointer where the next non-zero
     * element would go. This would also preserve the order of elements.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 3ms
     * Runtime beats 85.91% of Java submissions.
     */
    public void moveZeroes(int[] nums) {
        int currentPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[currentPointer];
                nums[currentPointer++] = nums[i];
                nums[i] = temp;
            }
        }
    }

}
