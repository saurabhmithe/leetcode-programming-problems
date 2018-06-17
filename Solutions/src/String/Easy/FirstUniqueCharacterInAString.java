package String.Easy;

public class FirstUniqueCharacterInAString {

    /*

    Given a string, find the first non-repeating character in it
    and return it's index. If it doesn't exist, return -1.

    Examples:
    s = "leetcode"
            return 0.
    s = "loveleetcode",
            return 2.

    Note: You may assume the string contain only lowercase letters.

    */


    /**
     * The below mentioned algorithm takes two passes.
     * In the first pass, we calculate the number of occurrences of each character.
     * In the second pass, we see which character appears just once and return its index.
     * In case no character appears just once, we return -1.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 25ms
     * Runtime beats 80.77%
     */
    public int firstUniqChar(String s) {
        int[] seen = new int[26];
        for (int i = 0; i < s.length(); i++) {
            seen[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((seen[s.charAt(i) - 'a']) == 1)
                return i;
        }
        return -1;
    }

}
