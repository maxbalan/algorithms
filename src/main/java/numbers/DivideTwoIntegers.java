package numbers;

/**
 * Date: 3/17/22
 **/
public class DivideTwoIntegers {

    public static void main(String[] args) {
        var i = new DivideTwoIntegers();
//        System.out.printf("RESPONSE: %d%n", i.solution("MCMXCIV"));
//        System.out.printf("RESPONSE: %d%n", i.solution(-12, 3));
        System.out.printf("RESPONSE: %d%n", i.solution(-2147483648, 1));
//        System.out.printf("RESPONSE: %d%n", i.solution(-1, 1));
    }

    public int solution(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 || divisor < 0) && !(dividend < 0 == divisor < 0);
        long a = dividend;
        long b = divisor;
        a = Math.abs(a);
        b = Math.abs(b);
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                a = a - 1;
            }
            return isNegative ? (int) -a : (int) a;
        }
        if (divisor == 1) {
            return isNegative ? (int) -a : (int) a;
        }

        int i = 0;

        while (a >= b) {
            a -= b;
            i++;
        }

        return isNegative ? -i : i;
    }
}
