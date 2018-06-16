package Arrays.Easy;

public class RemoveDuplicatesFromSortedArray {

     /*

     Given a sorted array nums, remove the duplicates in-place such that
     each element appear only once and return the new length.
     Do not allocate extra space for another array, you must do this
     by modifying the input array in-place with O(1) extra memory.

     Example 1:
     Given nums = [1,1,2],
     Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     It doesn't matter what you leave beyond the returned length.

     Example 2:
     Given nums = [0,0,1,1,1,2,2,3,3,4],
     Your function should return length = 5, with the first five elements
     of nums being modified to 0, 1, 2, 3, and 4 respectively.
     It doesn't matter what values are set beyond the returned length.

     Clarification:
     Confused why the returned value is an integer but your answer is an array?
     Note that the input array is passed in by reference, which means modification
     to the input array will be known to the caller as well.
     Internally you can think of this:

     nums is passed in by reference. (i.e., without making a copy)
     int len = removeDuplicates(nums);

     any modification to nums in your function would be known by the caller.
     using the length returned by your function, it prints the first len elements.
     for (int i = 0; i < len; i++) {
        print(nums[i]);
     }

     */


    /**
     * This is a linear time approach. The first element, by itself would be unique.
     * We use a variable prev to keep track of which was the last element we saw.
     * Since the array is sorted, we only need to keep track of the previous element we saw.
     * Additionally, we maintain a pointer ptr which will indicate the index at which next unique
     * element would be stored. We start from the first position and check if we have already seen
     * the current element. If this is true, it would be the same as the value of prev. If the element
     * is a new one i.e. we have not seen it before and thus, it is different from the value of prev,
     * we store this new element at the current ptr position and increment the ptr to point to next index.
     * In essence, we are shifting all the unique elements to the start of the array. We return ptr in the end.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 14ms
     * Runtime beats 64.80% of Java submissions
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int prev = nums[0];
        int ptr = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[ptr++] = nums[i];
                prev = nums[i];
            }
        }
        return ptr;
    }

}
