package strings;

/**
 * 08/10/18
 *
 * @author Maxim Balan
 **/
public class OneAwayEditV2 {
    public static void main(String[] args) {
        /**
         * There are three types of edits that can be performed on strings: insert a character,
         * remove a character, or replace a character. Given two strings, write a function to check if they are
         * one edit (or zero edits) away.
         * EXAMPLE
         * pale, ple -> true
         * pales, pale -> true
         * pale, bale -> true
         * pale, bae -> false
         */


        String init = "ab";
        String next = "abc";

        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));
        init = "ab";
        next = "abcc";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));
        init = "abdf";
        next = "adf";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));

        init = "abdf";
        next = "acdf";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));
    }

    static boolean isOneEditAway(String a, String b) {
        if (a.length() - b.length() > 1 ||
            a.length() - b.length() < -1) return false;

        int vectA = getFlagVector(a);
        int vectB = getFlagVector(a);

        int tempA = vectA & ~vectB;
        int tempB = ~vectA & vectB;
        int temp = tempA | tempB;
        return (temp & (temp -1)) == 0;
    }

    static int getFlagVector(String str) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int vector = 0;

        for (Character c : str.toCharArray()) {
            int mask = 1 << Character.getNumericValue(c);

            if ((vector & mask) == 0) vector |= mask;
            else vector &= ~mask;
        }

        return vector;
    }

}
