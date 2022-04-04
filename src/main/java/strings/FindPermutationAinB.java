package strings;

/**
 * 06/10/18
 * <p>
 * Question:
 * <p>
 * Find all permutation of A in B string.
 * <p>
 * Solution:
 * <p>
 * not really an obvious one but convert the B string into a number which is the multiplication of each character
 * then take a character from A string and multiply to previous ones and devide by the one eliminated and if this 2 are
 * the same then it means we found a permutation
 *
 * @author Maxim Balan
 **/
public class FindPermutationAinB {
    public static void main(String[] args) {
        String s = "abc";
        String b = "abcdabccbac"; // 4 permutations

        int counter = 0;
        int expected = 1;

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
