package String.Easy;

import java.util.Stack;

public class ValidParenthesis {

    /*

    Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:
    Input: "()"
    Output: true

    Example 2:
    Input: "()[]{}"
    Output: true

    Example 3:
    Input: "(]"
    Output: false

    Example 4:
    Input: "([)]"
    Output: false

    Example 5:
    Input: "{[]}"
    Output: true

    */


    /**
     * 
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     * Note: Even though we are using an external Stack, given that there can only be three types
     * of parenthesis, we would never reach a state where there would be more than 3 elements in the Stack.
     * Thus, the space required would be O(1) i.e. constant.
     * <p>
     * Runtime on LeetCode - 11ms
     * Runtime beats 55.07% of Java submissions
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (cArray[i] == '(') stack.push(')');
            else if (cArray[i] == '[') stack.push(']');
            else if (cArray[i] == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != cArray[i]) return false;
        }
        return stack.isEmpty();
    }
}
