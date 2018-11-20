package String.Medium;

class MyAtoi {

    /*

    Implement atoi which converts a string to an integer. The function first discards as
    many whitespace characters as necessary until the first non-whitespace character is found.
    Then, starting from this character, takes an optional initial plus or minus sign followed
    by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the
    integral number, which are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid
    integral number, or if no such sequence exists because either str is empty
    or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    Note:
    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers
    within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical
    value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.

    */

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    public int myAtoi(String str) {
        if (str == null) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        int sign = 1;
        int sum = 0;
        int i = 0;
        if (str.charAt(0) == '-') {
            i = 1;
            sign = -1;
        } else if (str.charAt(0) == '+') i = 1;
        for (; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) break;
            int newNum = (sum * 10) + str.charAt(i) - '0';
            if (newNum / 10 != sum) {
                if (sign == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            sum = (sum * 10) + str.charAt(i) - '0'; // char to int
        }
        return sign * sum;
    }

}