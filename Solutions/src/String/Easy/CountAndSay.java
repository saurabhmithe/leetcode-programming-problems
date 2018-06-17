package String.Easy;

public class CountAndSay {

    /*

    The count-and-say sequence is the sequence of integers with the first five terms as following:

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    1 is read off as "one 1" or 11.
    11 is read off as "two 1s" or 21.
    21 is read off as "one 2, then one 1" or 1211.

    Given an integer n, generate the nth term of the count-and-say sequence.

    Note: Each term of the sequence of integers will be represented as a string.

    Example 1:
    Input: 1
    Output: "1"

    Example 2:
    Input: 4
    Output: "1211"

    */

    /**
     * Just like the Fibonacci series, we hard code the first two values and build up on them.
     * The idea is to keep a count of the same elements appearing contiguously.
     * Once the same element sequence ends, append the element and its count to the result string.
     * Do this for all the elements until we reach the end of the array.
     * One more thing to note here is that in the end, we would have a leftover element and its
     * count which we would need to add to the result string after the end of the loop.
     * <p>
     * Time Complexity - O(n * k) where k is the max length of string up to nth level
     * Space Complexity - O(k)
     * Runtime on LeetCode 15ms
     * Runtime beats 28.34% of Java submissions
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        StringBuilder res = new StringBuilder();
        String prevString = "11";
        for (int j = 3; j <= n; j++) {
            int prev = Integer.parseInt(prevString.charAt(0) + "");
            int count = 1;
            res.delete(0, res.length());
            for (int i = 1; i < prevString.length(); i++) {
                if (Integer.parseInt(prevString.charAt(i) + "") == prev) count += 1;
                else {
                    res.append("" + count + prev);
                    prev = Integer.parseInt(prevString.charAt(i) + "");
                    count = 1;
                }
            }
            res.append("" + count + prev);
            prevString = res.toString();
        }
        return res.toString();
    }

}
