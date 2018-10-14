package String.Medium;

public class LongestPalindromicSubstring {

    /*

    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:
    Input: "babad"
    Output: "bab"

    Note: "aba" is also a valid answer.

    Example 2:
    Input: "cbbd"
    Output: "bb"

    */

    public static void main(String[] args) {
        String s = "ccc";
        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        palindromicSubstring.longestPalindrome(s);
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int maxL = 0, maxR = 0, maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1, k = i + 1;
            while (j >= 0 && k < s.length()) {
                if (s.charAt(j) == s.charAt(k)) {
                    maxL = j;
                    maxR = k;
                    maxLength = Math.max(maxLength, k - j + 1);
                    j--;
                    k++;
                    continue;
                }

                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int j = i, k = i + 1;
            while (j >= 0 && k < s.length()) {
                if (s.charAt(j) == s.charAt(k)) {
                    maxL = j;
                    maxR = k;
                    maxLength = Math.max(maxLength, k - j + 1);
                    j--;
                    k++;
                    continue;
                }

                break;
            }
        }

        return s.substring(maxL, maxR + 1);
    }

}
