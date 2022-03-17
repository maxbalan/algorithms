package strings;

/**
 * Date: 3/17/22
 *
 * @author Maxim Balan
 **/
public class StringToInteger {
    public static void main(String[] args) {
        var i = new StringToInteger();
        System.out.printf("RESULT: %d%n", i.solution_1("+-12"));
        System.out.printf("RESULT: %d%n", i.solution_1("9223372036854775808"));
        System.out.printf("RESULT: %d%n", i.solution_1("-9223372036854775809"));
        System.out.printf("RESULT: %d%n", i.solution_1("18446744073709551617"));
        System.out.printf("RESULT: %d%n", i.solution_1("2147483646"));
    }

    public int solution_1(String s) {
        char spaceChar = ' ';
        char minusChar = '-';
        char plusChar = '+';
        long response = 0;
        var multiplier = 1;

        var escape = false;
        for (char c : s.toCharArray()) {
            if (c == spaceChar && !escape) {
                continue;
            }

            if (Character.isDigit(c)) {
                escape = true;
                var digit = c - '0';

                if ((response > Integer.MAX_VALUE / 10) ||
                        (response == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return multiplier == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                response = response * 10 + digit % 10;
            } else {
                if (!escape) {
                    if (c == minusChar) {
                        multiplier = -1;
                        escape = true;
                        continue;
                    } else if (c == plusChar) {
                        escape = true;
                        continue;
                    }
                }
                break;
            }
        }

        return (int) response * multiplier;
    }
}
