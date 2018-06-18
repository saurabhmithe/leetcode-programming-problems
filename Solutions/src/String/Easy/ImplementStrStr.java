package String.Easy;

public class ImplementStrStr {

    /*

    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Example 1:
    Input: haystack = "hello", needle = "ll"
    Output: 2

    Example 2:
    Input: haystack = "aaaaa", needle = "bba"
    Output: -1

    Clarification:
    What should we return when needle is an empty string? This is a great question to ask during an interview.
    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to
    C's strstr() and Java's indexOf().

    */

    /**
     * We would be using the substring method of String class.
     * Starting from the first index of haystack, we check if there is any substring with
     * current index that matches the needle. If we find such a string, we return the index.
     * If there is no needle at all i.e. the needle string is empty, we return 0.
     * In case needle is present and we are not able to find it, we return -1.
     * There is a special case that we need to keep in mind which is that needle cannot
     * be greater than the haystack. If this happens, return -1.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 7ms
     * Runtime beats 90.09% of Java submissions
     */
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (needle.length() > haystack.length()) return -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
        }
        return -1;
    }

}
