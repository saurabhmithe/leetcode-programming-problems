package HashTable.Easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    /*

    Given an array of integers, find if the array contains any duplicates.

    Your function should return true if any value appears at least twice in the array,
    and it should return false if every element is distinct.

    Example 1:
    Input: [1,2,3,1]
    Output: true

    Example 2:
    Input: [1,2,3,4]
    Output: false

    Example 3:
    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true

     */


    /**
     * We are using HashMap to maintain the number as key with value as 1 if it appears in the array.
     * We store this key-value pair in a HashMap. Next time, while the number re-appears,
     * if there is already an entry for that key, we return false since it is a duplicate.
     * Else, if we reach the end of the array, we return true since no number got repeated.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 18ms
     * Runtime beats 58.01% of Java submissions
     */
    public boolean containsDuplicateHashMap(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], 1);
        }
        return false;
    }

}
