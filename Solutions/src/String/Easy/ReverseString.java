package String.Easy;

public class ReverseString {

    /*

    Write a function that takes a string as input and returns the string reversed.

    Example:
    Given s = "hello", return "olleh".

    */

    /**
     * This approach is space efficient and reverses the array in place.
     * We swap the first element and the last element with each other.
     * Then we swap the second element and the second to last element.
     * We continue doing this until we reach the middle of the array.
     * This approach will work for both even and odd length arrays.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * <p>
     * Runtime on LeetCode - 4ms
     * Runtime beats 77.61% of Java submissions
     */
    public String reverseString(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length / 2; i++) {
            char temp = ca[i];
            ca[i] = ca[ca.length - i - 1];
            ca[ca.length - i - 1] = temp;
        }
        return String.valueOf(ca);
    }
    
}
