package Arrays.Easy;

public class MajorityElement {

    // Given an array of size n, find the majority element.
    // The majority element is the element that appears more than ⌊ n/2 ⌋ times.
    //You may assume that the array is non-empty and the majority element always exist in the array.

    // Example 1:
    // Input: [3,2,3]
    // Output: 3

    // Example 2:
    // Input: [2,2,1,1,1,2,2]
    // Output: 2


    /**
     * BOYER-MOORE Majority Voting Algorithm
     * <p>
     * The below approach provides you a candidate which might be the majority element.
     * Since in this problem, the majority element always exists, we can be sure that the candidate is the
     * majority element. However, there is a possibility that the given array might or might not contain
     * a majority element, then we would need another pass over the entire array that would count
     * the number of occurrences of the candidate element to check if count is greater than n / 2.
     * <p>
     * The approach itself is quite simple and intuitive. We assume that the first element is the majority element
     * and set the count as 1. We use the variable majorityElement to contain the value of the candidate.
     * We keep on incrementing the count as long as we keep seeing the same element. If we see a different element,
     * we decrement the count since there is now a new element that is negating the importance of the majority one.
     * If we see enough different elements to counter the majority candidate such that the count reaches 0,
     * we assign the current element as the majority element and reset the count to 1.
     * This continues until the end of the array. In the end, the majorityElement variable has the candidate
     * that is likely to be a majority element if one exists.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 3ms
     * Runtime beats 79.93% of Java submissions
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int majorityElement = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement) count += 1;
            else if (count == 0) {
                majorityElement = nums[i];
                count = 1;
            } else count -= 1;
        }
        return majorityElement;
    }

}
