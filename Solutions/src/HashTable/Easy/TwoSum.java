package HashTable.Easy;

import java.util.Hashtable;

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
     * the HashTable, we return an array containing index of current element as well as the index of the counterpart.
     * If the counterpart is not present in the HashTable, we put the current element in the HashMap as a counterpart
     * with value as the index. This element could serve as a counterpart of some other element down the line.
     * We are using HashTable since it allows constant time lookup as well as allows us to store the index of the
     * element which could not have been possible with a HashSet.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 8ms
     * Runtime beats 93.27% of Java submissions.
     */
    public int[] twoSumHashTable(int[] nums, int target) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
        int index = 0;
        for (int num : nums) {
            int delta = target - num;
            if (hashTable.containsKey(delta)) {
                return new int[]{hashTable.get(delta), index};
            }
            hashTable.put(num, index);
            index += 1;
        }
        return null;
    }

}
