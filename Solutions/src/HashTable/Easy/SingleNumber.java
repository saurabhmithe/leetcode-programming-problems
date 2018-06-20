package HashTable.Easy;

import java.util.Hashtable;

public class SingleNumber {

    /*

    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:
    Input: [2,2,1]
    Output: 1

    Example 2:
    Input: [4,1,2,1,2]
    Output: 4

    */


    /**
     * This is a neat trick. We use the associative properties of XOR operation.
     * The rules of XOR are - x ^ x = 0, x ^ 0 = x.
     * This means that a number gives 0 when XORed with itself.
     * Since all the numbers appear twice except for a single number,
     * they all would result in 0. The single number would XOR with this 0
     * and return itself. Thus, we would be able to find out the only single number.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 1ms
     * Runtime beats 100% of Java submissions
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }


    /**
     * This approach uses HashTable since it is one of the mainstream ways of dealing with counting problems.
     * HashTable allows constant time lookup which is a desirable property.
     * We store the element as the key and the number of times it appears as the value.
     * In the end, each element would have a value of 2 except for that one single element.
     * We would need another pass over the HashTable to figure out which one it was.
     * <p>
     * Time Complexity - O(2n) => O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 22ms
     * Runtime beats 11.68% of Java submissions
     */
    public int singleNumberHashTable(int[] nums) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        for (int num : nums) {
            if (!hashTable.containsKey(num)) {
                hashTable.put(num, 1);
            } else {
                hashTable.put(num, hashTable.get(num) + 1);
            }
        }
        for (int num : nums) {
            if (hashTable.get(num) == 1) return num;
        }
        return 0;
    }

}
