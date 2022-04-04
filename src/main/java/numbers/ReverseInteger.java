package numbers;

/**
 * Date: 3/17/22
 **/
public class ReverseInteger {
    public static void main(String[] args) {
        var i = new ReverseInteger();
        var s = i.reverse(1563847412);
        System.out.printf("REVERSE: %d%n", s);
    }

    public int reverse(int x) {
//        2147483647
//        -2147483648
        var multiplier = 1;
        if (x < 0) {
            multiplier = -1;
            x = x * multiplier;
        }

        var response = 0;
        while (x > 0) {

            if (response * multiplier > Integer.MAX_VALUE / 10 ||
                    response * multiplier < Integer.MIN_VALUE / 10) {
                return 0;
            }
            response = response * 10 + x % 10;
            x = x / 10;
        }

        return response * multiplier;
    }
}
