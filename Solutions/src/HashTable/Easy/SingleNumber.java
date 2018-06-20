package HashTable.Easy;

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

}
