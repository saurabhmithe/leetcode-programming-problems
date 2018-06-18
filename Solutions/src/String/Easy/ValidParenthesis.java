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
     * The approach is simple but not so apparent in the first glance.
     * Whenever we encounter an opening parenthesis, instead of storing it directly in
     * the stack like we do in conventional approaches, we store the counterpart of that parenthesis
     * i.e. we store the closing parenthesis for the seen parenthesis. By doing this, whenever we see
     * a closing parenthesis while going over the string, we can pop from the stack and check if
     * the popped element and the current element are the same. If they mismatch we can return false
     * since the rule has been broken. Additionally, if we see a closing parenthesis in the string and
     * the stack is empty, we return false since there is no opening parenthesis to balance it.
     * In the end, is the stack is empty, we return true since all the parenthesis have been balanced.
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
