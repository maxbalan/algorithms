package strings;

import java.util.ArrayDeque;

/**
 * Date: 3/17/22
 **/
public class LongestValidParentheses {
    public static void main(String[] args) {
        var i = new LongestValidParentheses();
//        System.out.printf("RESPONSE: %s%n", i.solution("((())"));
//        System.out.printf("RESPONSE: %s%n", i.solution("(()"));
        System.out.printf("RESPONSE: %s%n", i.solution("()(()"));
    }

    public int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }

        var q = new ArrayDeque<Integer>();
        var maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                q.addFirst(i);
            } else {
                q.pop();
                if (q.isEmpty()) {
                    q.addFirst(i);
                } else {
                    maxLen = Math.max(maxLen, i - q.peek());
                }
            }
        }

        return maxLen;
    }
}
