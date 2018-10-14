package String.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {

    /*

    Given a string, find the length of the longest substring without repeating characters.

    Example 1:
    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.

    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

    */

    public static void main(String[] args) {
        String s = "dvdf";
        LongestSubstringWithoutRepeating longestSubstring = new LongestSubstringWithoutRepeating();
        longestSubstring.lengthOfLongestSubstring(s);
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int currentLength = 0;
        int maxLength = 0;
        int i = 0;
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, currentLength);
                char c = s.charAt(i);
                i = map.get(c) + 1;
                currentLength = 0;
                map.clear();
                continue;
            } else {
                currentLength += 1;
                map.put(s.charAt(i), i);
                i += 1;
            }
        }
        return Math.max(maxLength, currentLength);
    }

}
