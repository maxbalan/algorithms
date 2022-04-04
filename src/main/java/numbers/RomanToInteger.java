package numbers;

import java.util.HashMap;
import java.util.Stack;

/**
 * Date: 3/17/22
 **/
public class RomanToInteger {

    public static void main(String[] args) {
        var i = new RomanToInteger();
//        System.out.printf("RESPONSE: %d%n", i.solution("MCMXCIV"));
        System.out.printf("RESPONSE: %d%n", i.solution("DCXXI"));
    }

    public int solution(String s) {
        var caseMap = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("IV", 4);
                put("V", 5);
                put("IX", 9);
                put("X", 10);
                put("XL", 40);
                put("L", 50);
                put("XC", 90);
                put("C", 100);
                put("CD", 400);
                put("D", 500);
                put("CM", 900);
                put("M", 1000);
            }
        };

        var sStack = new Stack<String>();

        for (int i = s.length() - 1; i >= 0; i--) {
            sStack.push(s.charAt(i) + "");
        }

        var result = 0;
        var current = sStack.pop();
        while (!sStack.isEmpty()) {
            var r = caseMap.get(current + sStack.peek());
            if (r == null) {
                result += caseMap.get(current);
                current = sStack.pop();
                continue;
            }

            current = current + sStack.pop();
        }

        result += caseMap.get(current);

        return result;
    }
}
