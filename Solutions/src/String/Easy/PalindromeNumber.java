package String.Easy;

public class PalindromeNumber {

    /*

    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

    Example 1:

    Input: 121
    Output: true
    Example 2:

    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    Follow up:

    Could you solve it without converting the integer to a string?

    */

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean isPalindrome = palindromeNumber.isPalindrome(123454321);
        System.out.println(isPalindrome);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false; // negative numbers can never be a pallindrome
        if (x % 10 == 0 && x != 0) return false; // single digit numbers are always a pallindrome

        int newNum = 0;
        while (newNum < x) {
            newNum *= 10;
            newNum += x % 10;
            x = x / 10;
        }
        return newNum == x || x == newNum / 10;
    }

}
