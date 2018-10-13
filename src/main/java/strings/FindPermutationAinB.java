package strings;

/**
 * 06/10/18
 *
 * @author Maxim Balan
 **/
public class FindPermutationAinB {
    public static void main(String[] args) {
        String s = "abc";
        String b = "abcdabccbac"; // 6 permutations

        int counter = 0;

        int expected = 1;
        int window = s.length();

        int bCount = 1;
//        System.out.println("Expected = " + expected);

        for (int i = 0; i < b.length(); i++) {

            if (i < s.length()) {
                expected = calculate(s.charAt(i), expected, 1);
            }

            if (i <= s.length() - 1)
                bCount = calculate(b.charAt(i), bCount, 1);
            else
                bCount = calculate(b.charAt(i), bCount, b.charAt(i - s.length()));

            if ((i >= s.length() - 1) && bCount == expected) counter++;
        }

        System.out.println(counter);
    }


    private static int calculate(char s, int acc, int dev) {
        int result;
        result = (acc * (int) s) / dev;
        return result;
    }

}