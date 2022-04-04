package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 3/17/22
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 *
 * @author Maxim Balan
 **/
public class GenerateParentheses {
    public static void main(String[] args) {
        var i = new GenerateParentheses();
        System.out.printf("RESPONSE: %s%n", i.solution(3));
    }

    public List<String> solution(int n) {
        var r = new ArrayList<String>();
        generate(r, "", 0, n);
        return r;
    }

    public void generate(List<String> result, String s, int open, int remain) {
        if (remain <= 0) {
            int i = open;
            var r = s;
            while (i > 0) {
                r = r + ")";
                i--;
            }
            result.add(r);
        }

        if (remain > 0) {
            generate(result, s + "(", open + 1, remain - 1);

            if (open > 0) {
                generate(result, s + ")", open - 1, remain);
            }
        }
    }
}
