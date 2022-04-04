package strings;

/**
 * Date: 3/17/22
 **/
public class RegularExpressionMatching {
    public static void main(String[] args) {
        var i = new RegularExpressionMatching();
        System.out.printf("RESPONSE: [ %s ] == [ %s ] > %b%n", "as", ".*", i.solution("as", ".*"));
//        System.out.printf("RESPONSE: [ %s ] == [ %s ] > %b%n", "as", "a.", i.solution("as", "a."));
//        System.out.printf("RESPONSE: [ %s ] == [ %s ] > %b%n", "ass", "a.", i.solution("ass", "a."));
//        System.out.printf("RESPONSE: [ %s ] == [ %s ] > %b%n", "ass", "as*", i.solution("ass", "as*"));
//        System.out.printf("RESPONSE: [ %s ] == [ %s ] > %b%n", "ass", "a.*", i.solution("ass", "a.*"));
//        System.out.printf("RESPONSE: [ %s ] == [ %s ] > %b%n", "aab", "c*a*b", i.solution("aab", "c*a*b"));
    }

    //******** Solution 1 top down approach using brute force **********************
/*
    the idea is to do recursive calls and move each index along the way until we hit the end of the string

 */
    public boolean solution(String s, String p) {
        return processing(0, 0, s, p);
    }

    public boolean processing(int i, int j, String s, String p) {
        //if both indexes are out of bound then we know we matched the string
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        // if only pattern index is out of bound then we did not match
        if (j >= p.length()) {
            return false;
        }

        // so take the char at index i and j (string and pattern) and compare them
        // they both match if the pattern is a dot or both are identical
        var match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // if we are still inbound at next index and its a star
        if (((j + 1) < p.length()) && (p.charAt(j + 1) == '*')) {
            return processing(i, j + 2, s, p) ||           //ignore star (zero occurrences)
                    (match && processing(i + 1, j, s, p)); // use the star (1 or multiple occurrences)
        }

        // if we matched the chars then go to next index
        if (match) {
            return processing(i + 1, j + 1, s, p);
        }

        return false;
    }
}
