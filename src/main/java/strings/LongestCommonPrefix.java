package strings;

/**
 * Date: 3/17/22
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        var i = new LongestCommonPrefix();
        System.out.printf("RESPONSE: %s%n", i.solution(new String[]{"a", "fasdasd", "as"}));
    }

    public String solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        var r = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (r.length() > 0) {
                if (strs[i].indexOf(r) == 0) {
                    break;
                } else {
                    r = r.substring(0, r.length() - 1);
                }
            }

            if (r.length() == 0) {
                return "";
            }
        }

        return r;
    }
}
