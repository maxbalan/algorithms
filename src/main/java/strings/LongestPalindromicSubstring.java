package strings;

/**
 * Date: 3/17/22
 *
 * @author Maxim Balan
 **/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        var i = new LongestPalindromicSubstring();
        System.out.printf("RESPONSE: %s%n", i.solution("bb"));
    }

    public String solution(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        var p = "";
        var len = 0;

        for (int i = 0; i < s.length(); i++) {
            var l = i;
            var r = i;

//            check even len string
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    p = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

//            check odd len string
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > len) {
                    len = r - l + 1;
                    p = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        return p;
    }
}
