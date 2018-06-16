package Arrays.Easy;

public class MergeSortedArray {

    /*

    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

    Note:
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is greater or equal to m + n)
    to hold additional elements from nums2.

    Example:
    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3
    Output: [1,2,2,3,5,6]

     */

    /**
     * We maintain a pointer that points to the last location of the larger array.
     * Then we start looking at the last filled elements of both the arrays.
     * We place the larger of those elements in the last position and then decrement
     * the pointer. We keep on doing this while going down both the arrays until we
     * have seen all the elements in the smaller array.
     * <p>
     * Time Complexity - O(m + n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 5ms
     * Runtime beats 99.91% Java submissions
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mPtr = m - 1;
        int nPtr = n - 1;
        int index = nums1.length - 1;
        while (nPtr >= 0) {
            if (mPtr >= 0 && nums1[mPtr] >= nums2[nPtr]) {
                nums1[index--] = nums1[mPtr--];
            } else {
                nums1[index--] = nums2[nPtr--];
            }
        }
    }
}
