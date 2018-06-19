package String.Easy;

public class LongestCommonPrefix {

    /*

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"

    Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.

    Note:
    All given inputs are in lowercase letters a-z.

     */


    /**
     * We start by assuming that the first string is smallest and assigning it to variable min.
     * Then we check if min is fully contained in the next string. If it is, then min does not change.
     * If it is not fully contained, we reduce the size of min by 1 and check again.
     * We continue checking this until min is small enough to be fully contained or min is empty.
     * The value of min after it is compared with all the strings in such a way would be our final value.
     * <p>
     * Time Complexity - O(n * s) where s is the length of longest string
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 10ms
     * Runtime beats 95.30% of Java submissions
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String min = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(min) != 0) {
                min = min.substring(0, min.length() - 1);
                if (min.equals("")) return "";
            }
        }
        return min;
    }

}
