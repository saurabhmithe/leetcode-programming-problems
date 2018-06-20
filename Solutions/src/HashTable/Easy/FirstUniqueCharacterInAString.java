package HashTable.Easy;

import java.util.Hashtable;

public class FirstUniqueCharacterInAString {

    /*

    Given a string, find the first non-repeating character in it and return it's index.
    If it doesn't exist, return -1.

    Examples:

    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.

    Note: You may assume the string contain only lowercase letters.


     */


    /**
     * Here we use an integer array of size 26 to keep the counts of all the characters we have seen.
     * We can safely do this since we know that all the characters would be lowercase.
     * Then we iterate over the string to find the first element with a count of 1 in the count array.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 25ms
     * Runtime beats 80.77% of Java submissions
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


    /**
     * Here we use a HashTable to keep the counts of all the characters we have seen.
     * Then we iterate over the string to find the first element with a count of 1 in the HashTable.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 115ms
     * Runtime beats 15.09% of Java submissions.
     */
    public int firstUniqCharHashTable(String s) {
        Hashtable<Character, Integer> hashTable = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hashTable.containsKey(s.charAt(i))) hashTable.put(s.charAt(i), 1);
            else hashTable.put(s.charAt(i), hashTable.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashTable.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

}
