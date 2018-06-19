package String.Easy;

public class ValidPallindrome {

    /*

    Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty string as valid palindrome.

    Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true
    Example 2:

    Input: "race a car"
    Output: false

     */


    /**
     * The approach is straight-forward. We have a helper function which tells us whether a given character
     * is an alphanumeric element or not. It does so by returning True for yes and False for no.
     * We maintain two pointers - one at the start and the other at the end.
     * If the characters at both pointers are alphanumeric and are same, we increment the first and decrement second.
     * If both are alphanumeric and are not same, we return false since this breaks the requirement.
     * If one or both of them are not alphanumeric, we ignore the character by incrementing or decrementing.
     * the respective pointers. In a nutshell, compare only alphanumeric characters for being a palindrome.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity = O(1)
     * <p>
     * Runtime on LeetCode - 18ms
     * Runtime beats 27.07% of Java submissions
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.equals("")) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (isAn(s.charAt(i)) && isAn(s.charAt(j))) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i += 1;
                j -= 1;
            } else {
                if (!isAn(s.charAt(i))) i += 1;
                if (!isAn(s.charAt(j))) j -= 1;
            }
        }
        return true;
    }

    public boolean isAn(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

}
