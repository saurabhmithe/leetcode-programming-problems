package Arrays.Easy;

public class PlusOne {

     /*

     Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     The digits are stored such that the most significant digit is at the head of the list, and each
     element in the array contain a single digit.

     You may assume the integer does not contain any leading zero, except the number 0 itself.

     Example 1:
     Input: [1,2,3]
     Output: [1,2,4]
     Explanation: The array represents the integer 123.

     Example 2:
     Input: [4,3,2,1]
     Output: [4,3,2,2]
     Explanation: The array represents the integer 4321.

     */


    /**
     * This is as simple as incrementing the element at the last position in the given array unless it generates
     * a carry. When it does, we increment all the previous elements starting from the least significant digit
     * all the way up to the most significant digit as long as a carry is being generated. If it continues all the
     * way to the end, we would need an additional digit space to accommodate the overflow. In this situation,
     * we create a new array and copy all the elements calculated until now with an additional 1 in the first
     * position. If we are using a dynamic data structure like a list, we can just append a 1 in the front of
     * the original list and return the list thereby making the space complexity constant.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * Note: The space complexity is O(n) since we are using arrays and we cannot dynamically change the size.
     * However, if we use something like a list, the space complexity would be O(1) since we would just append
     * a 1 in the front of the list and return the original list with this modification.
     * <p>
     * Runtime on LeetCode - 1ms
     * Runtime beats 68.51% of Java submissions.
     */
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int i = digits.length - 1;
        int carry = 0;
        while (i >= 0) {
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
                i -= 1;
                carry = 1;
            } else {
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (i = 0; i < digits.length; i++) {
                newArray[i + 1] = digits[i];
            }
            return newArray;
        }
        return digits;
    }

}
