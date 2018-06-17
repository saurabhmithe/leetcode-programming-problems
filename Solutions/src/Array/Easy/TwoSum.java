package Array.Easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

     /*

     Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     You may assume that each input would have exactly one solution, and you may not use the same element twice.

     Example:
     Given nums = [2, 7, 11, 15], target = 9,
     Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].

     */


    /**
     * In the below approach, we are trying to find the counterpart of the current element in the given
     * array such that their sum would add up to the target. For each element, if we find a counterpart in
     * the HashMap, we return an array containing index of current element as well as the index of the counterpart.
     * If the counterpart is not present in the HashMap, we put the current element in the HashMap as a counterpart
     * with value as the index. This element could serve as a counterpart of some other element down the line.
     * We are using HashMap since it allows constant time lookup as well as allows us to store the index of the
     * element which could not have been possible with a HashSet.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 8ms
     * Runtime beats 93.27% of Java submissions.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (map.containsKey(delta)) {
                return new int[]{map.get(delta), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
