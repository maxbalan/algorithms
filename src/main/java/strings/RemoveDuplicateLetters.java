package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Date: 3/17/22
 **/
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        var i = new RemoveDuplicateLetters();
        System.out.printf("RESPONSE: %s%n", i.solution("bcabca"));
    }

    public String solution(String s) {
        var indices = new HashMap<Character, Integer>();
        var stack = new Stack<Character>();
        var visited = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            indices.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (visited.contains(s.charAt(i))) {
                continue;
            }

            while (!stack.isEmpty() &&
                    stack.peek() > s.charAt(i) &&
                    indices.get(stack.peek()) > i) {
                visited.remove(stack.peek());
                stack.pop();
            }

            stack.push(s.charAt(i));
            visited.add(s.charAt(i));
        }

        var r = "";
        for (Character character : stack) {
            r = r + character;
        }

        return r;
    }
}
