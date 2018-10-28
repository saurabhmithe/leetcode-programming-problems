package String.Medium;

public class ZigZagConversion {

    /*

    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);
    Example 1:

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"
    Example 2:

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    P     I    N
    A   L S  I G
    Y A   H R
    P     I

    */

    public static void main(String[] args) {
        String s = "AB";
        int n = 1;
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        int length = s.length();
        if (numRows == 1) return s;
        if (length == 1) return s;
        int gap = (2 * numRows) - 2;
        int gapOffset = 0;
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int start = row;

            while (start < length) {
                result.append(s.charAt(start));
                start = start + gap - gapOffset;
                if (gapOffset != 0 && start < length) result.append(s.charAt(start));
                start = start + gapOffset;
            }

            gapOffset = (gapOffset + 2) % gap;
        }

        return new String(result);
    }

}
