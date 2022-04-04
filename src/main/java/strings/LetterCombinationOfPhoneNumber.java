package strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Date: 3/17/22
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * Example 2:
 * <p>
 * Input: digits = ""
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 * @author Maxim Balan
 **/
public class LetterCombinationOfPhoneNumber {

    public static void main(String[] args) {
        var i = new LetterCombinationOfPhoneNumber();
        System.out.printf("RESPONSE: %s%n", i.solution("23"));
        System.out.printf("RESPONSE: %s%n", i.solution("23"));
        System.out.printf("RESPONSE: %s%n", i.solution("23"));
    }

    public List<String> solution(String digits) {
        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        var map = new HashMap<Character, List<String>>() {
            {
                put('2', List.of("a", "b", "c"));
                put('3', List.of("d", "e", "f"));
                put('4', List.of("g", "h", "i"));
                put('5', List.of("j", "k", "l"));
                put('6', List.of("m", "n", "o"));
                put('7', List.of("p", "q", "r", "s"));
                put('8', List.of("t", "u", "v"));
                put('9', List.of("w", "x", "y", "z"));
            }
        };
        var r = new Stack<String>();
        r.addAll(map.get(digits.charAt(0)));

        for (int i = 1; i < digits.length(); i++) {
            var l = map.get(digits.charAt(i));

            var ns = new Stack<String>();
            while (!r.isEmpty()) {
                var x = r.pop();
                for (String s : l) {
                    ns.add(x + s);
                }
            }
            r = ns;
        }

        return r.stream().toList();
    }
}
