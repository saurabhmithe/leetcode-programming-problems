package DynamicProgramming.Hard;

public class EditDistance {

    /*

    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
    Example 1:

    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    Example 2:

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')

    */

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        EditDistance editDistance = new EditDistance();
        int distance = editDistance.minDistance(s1, s2);
        System.out.println(distance);
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(n^2)
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word1 == null || word1.length() == 0) return word2.length();

        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();

        int[][] mem = new int[s1.length + 1][s2.length + 1];

        for (int row = 0; row < s1.length + 1; row++) {
            mem[row][0] = row;
        }
        for (int col = 0; col < s2.length + 1; col++) {
            mem[0][col] = col;
        }

        for (int row = 1; row < s1.length + 1; row++) {
            for (int col = 1; col < s2.length + 1; col++) {
                if (s1[row - 1] == s2[col - 1]) mem[row][col] = mem[row - 1][col - 1];
                else
                    mem[row][col] = 1 + Math.min(mem[row - 1][col - 1], Math.min(mem[row - 1][col], mem[row][col - 1]));
            }
        }

        return mem[s1.length][s2.length];
    }

}
