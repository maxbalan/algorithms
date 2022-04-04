package numbers;

/**
 * Date: 3/17/22
 **/
public class NumberPalindrom {
    public static void main(String[] args) {
        var i = new NumberPalindrom();
        var s = i.solution(1563847412);
        System.out.printf("REVERSE: %d%n", s);
    }

    public boolean solution(int x) {
        if (x < 0) {
            return false;
        }

        String xs = x + "";
        char[] xca = xs.toCharArray();

        int start = 0;
        int end = xs.length() - 1;
        while (start <= end) {
            if (xca[start] == xca[end]) {
                start += 1;
                end -= 1;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
