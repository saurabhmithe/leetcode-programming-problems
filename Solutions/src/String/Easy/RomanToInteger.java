package String.Easy;

public class RomanToInteger {

    /*

    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

      Symbol        Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
    For example, two is written as II in Roman numeral, just two one's added together.
    Twelve is written as, XII, which is simply X + II.
    The number twenty seven is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII. Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:

    Input: "III"
    Output: 3
    Example 2:

    Input: "IV"
    Output: 4
    Example 3:

    Input: "IX"
    Output: 9
    Example 4:

    Input: "LVIII"
    Output: 58
    Explanation: C = 100, L = 50, XXX = 30 and III = 3.
    Example 5:

    Input: "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    */


    /**
     * First of all, we created a method which returns the integer value of a particular roman literal.
     * Here, it is done using switch cases, but it can also be done using HashMap.
     * The approach is straight-forward where we start from the rightmost literal and add its
     * value to the sum. However, there is a special case where if a literal with smaller value
     * appears after a literal with larger value (from right to left) as in IV i.e. four, then we
     * subtract the value to the left from the value to the right. e.g. IV where 5 - 1 = 4.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 125ms
     * Runtime beats 60.65% of Java submissions
     */
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i + 1 < s.length() && getIntFromRomanLiteral(s.charAt(i)) < getIntFromRomanLiteral(s.charAt(i + 1))) {
                sum -= getIntFromRomanLiteral(s.charAt(i));
                continue;
            }
            sum += getIntFromRomanLiteral(s.charAt(i));
        }
        return sum;
    }

    public int getIntFromRomanLiteral(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

}
