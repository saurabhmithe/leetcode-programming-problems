package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    // Given an array of integers, find if the array contains any duplicates.
    // Your function should return true if any value appears at least twice in the array,
    // and it should return false if every element is distinct.

    // Example 1:
    // Input: [1,2,3,1]
    // Output: true

    // Example 2:
    // Input: [1,2,3,4]
    // Output: false

    // Example 3:
    // Input: [1,1,1,3,3,4,3,2,4,2]
    // Output: true
    

    /**
     * For each element in the given array, if we are seeing it for the first time,
     * we put it in a HashMap (a HashSet can also be used). If an element is already
     * in the HashMap (meaning that we have seen it before), we return true.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 18ms
     * Runtime beats 58.01% of Java submissions
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], 1);
        }
        return false;
    }

}
