package numbers;

/**
 * Date: 3/17/22
 *
 * @author Maxim Balan
 **/
public class IntegerToRoman {
    private static final String I = "I";
    private static final String V = "V";
    private static final String X = "X";
    private static final String L = "L";
    private static final String C = "C";
    private static final String D = "D";
    private static final String M = "M";

    public static void main(String[] args) {
        var i = new IntegerToRoman();
//        System.out.printf("RESPONSE: %s%n", i.solution(1));
//        System.out.printf("RESPONSE: %s%n", i.solution(2));
//        System.out.printf("RESPONSE: %s%n", i.solution(3));
//        System.out.printf("RESPONSE: %s%n", i.solution(4));
//        System.out.printf("RESPONSE: %s%n", i.solution(5));
//        System.out.printf("RESPONSE: %s%n", i.solution(6));
//        System.out.printf("RESPONSE: %s%n", i.solution(10));
//        System.out.printf("RESPONSE: %s%n", i.solution(11));
//        System.out.printf("RESPONSE: %s%n", i.solution(12));
//        System.out.printf("RESPONSE: %s%n", i.solution(13));
//        System.out.printf("RESPONSE: %s%n", i.solution(14));
//        System.out.printf("RESPONSE: %s%n", i.solution(15));
//        System.out.printf("RESPONSE: %s%n", i.solution(16));
//        System.out.printf("RESPONSE: %s%n", i.solution(58));
        System.out.printf("RESPONSE: %s%n", i.solution(1994));
    }

    public static String specialCase(int x) {
        return switch (x) {
            case 1 -> I;
            case 4 -> I + V;
            case 5 -> V;
            case 6 -> V + I;
            case 7 -> V + I + I;
            case 8 -> V + I + I + I;
            case 9 -> I + X;
            case 40 -> X + L;
            case 50 -> L;
            case 60 -> L + X;
            case 70 -> L + X + X;
            case 80 -> L + X + X + X;
            case 90 -> X + C;
            case 400 -> C + D;
            case 500 -> D;
            case 600 -> D + C;
            case 700 -> D + C + C;
            case 800 -> D + C + C + C;
            case 900 -> C + M;
            default -> "";
        };
    }

    public String solution(int num) {
        int r = num;
        int i = 1;
        var result = "";

        while (r > 0) {
            var s = r % (10 * i);
            if (s == 0) {
                i *= 10;
                continue;
            }

            var rom = specialCase(s);

            if (rom.length() == 0) {
                if (s < 4) {
                    result = combine(I, I, s - i) + result;
                } else if (s >= 1000) {
                    result = combine(M, M, s / (1000) - 1) + result;
                } else if (s >= 100) {
                    result = combine(C, C, s / (100) - 1) + result;
                } else if (s >= 10) {
                    result = combine(X, X, (s / 10) - 1) + result;
                }
            } else {
                result = rom + result;
            }

            r = r - s;
            i *= 10;
        }


        return result;
    }

    public String combine(String start, String add, int amount) {
        var s = start;
        while (amount > 0) {
            s = s + add;
            amount--;
        }

        return s;
    }
}
