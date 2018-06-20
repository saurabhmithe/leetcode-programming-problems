package HashTable.Easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*

    Given two strings s and t , write a function to determine if t is an anagram of s.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Note:
    You may assume the string contains only lowercase alphabets.

    Follow up:
    What if the inputs contain unicode characters? How would you adapt your solution to such case?

     */


    /**
     * This is yet another common approach for counting where we have an integer array.
     * Such approach works best when we are aware of the input range (here it is a - z lowercase)
     * So we maintain an array of 26 elements. For each character seen in the input string s,
     * we increment the count for the respective position of that character in the array.
     * Similarly, for each character seen in the input string t, we decrement the count.
     * If the two strings are in fact, anagrams, the the count array would have all 0s
     * since the two strings would cancel each other's counts. It is is all 0s, we return
     * true, else we return false.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 4ms
     * Runtime beats 94.75% of Java submissions
     */
    public boolean isAnagram(String s, String t) {
        int[] checker = new int[26];
        for (char c : s.toCharArray()) {
            checker[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            checker[c - 'a'] -= 1;
        }
        for (int i = 0; i < checker.length; i++) {
            if (checker[i] != 0) return false;
        }
        return true;
    }


    /**
     * This approach uses HashMap for counting characters in the given strings.
     * If both the strings have exact same characters with same counts, they are anagrams.
     * We create two HashMaps for each string and then compare those HashMaps.
     * If they are same, we return true. Else, we return false.
     * <p>
     * Time Complexity - O(3n) => O(n)
     * Space Complexity - O(2n) => O(n)
     * <p>
     * Runtime on LeetCode - 42ms
     * Runtime beats 17.22% of Java submissions
     */
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (mapS.containsKey(c)) {
                mapS.put(c, mapS.get(c) + 1);
            } else {
                mapS.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (mapT.containsKey(c)) {
                mapT.put(c, mapT.get(c) + 1);
            } else {
                mapT.put(c, 1);
            }
        }
        if (mapS.equals(mapT)) {
            return true;
        }
        return false;
    }

}
