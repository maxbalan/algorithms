package strings;

import java.util.Stack;

/**
 * Date: 3/17/22
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 *
 * @author Maxim Balan
 **/
public class ValidateParentheses {
    public static void main(String[] args) {
        var i = new ValidateParentheses();
        System.out.printf("RESPONSE: %s%n", i.solution("((())"));
    }

    public boolean solution(String s) {
        var open = new Stack<Character>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                open.add(c);
            } else if (open.size() > 0 &&
                    ((open.peek() == '(' && c == ')') ||
                            (open.peek() == '[' && c == ']') ||
                            (open.peek() == '{' && c == '}'))) {
                open.pop();
            } else {
                return false;
            }
        }

        return open.isEmpty();
    }
}
