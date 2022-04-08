package strings;

/**
 * 23/10/18
 * Implement strStr().
 * <p>
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 **/
public class NeedleInHaystack {

    public static void main(String[] args) {
        var i = new NeedleInHaystack();
        System.out.printf("RESPONSE: %s%n", i.solution("asdaaa", "aaa"));
    }

    private static int solution(String haystack, String needle) {
        if (needle == null || needle.isBlank()) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }

            var x = i;
            var y = 0;
            var found = true;
            while (x < haystack.length() && y < needle.length()) {
                if (haystack.charAt(x) == needle.charAt(y)) {
                    y++;
                    x++;
                } else {
                    found = false;
                    break;
                }
            }

            if (found && y == needle.length()) {
                return i;
            }
        }

        return -1;
    }

}
