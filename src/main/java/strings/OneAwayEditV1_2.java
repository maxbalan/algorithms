package strings;

/**
 * 08/10/18
 *
 * @author Maxim Balan
 **/
public class OneAwayEditV1_2 {
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

        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: expect [ true ] [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));
        init = "ab";
        next = "abcc";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: expect [ false ] [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));
        init = "abdf";
        next = "adf";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: expect [ true ] [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));

        init = "abdf";
        next = "acdf";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: expect [ true ] [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));

        init = "abdf";
        next = "acff";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: expect [ false ] [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));

        init = "abdff";
        next = "acdf";
        System.out.println(String.format("is [ %s ] one edit away from [ %s ] ::: expect [ false ] [ %b ]",
                                         init,
                                         next,
                                         isOneEditAway(init, next)));
    }

    static boolean isOneEditAway(String a, String b) {
        String longest = a.length() > b.length() ? a : b;
        String shortest = a.length() > b.length() ? b : a;

        //there is no way we are one edit away we need to have a discrepancy of 1 or 0
        if (longest.length() - shortest.length() > 1) return false;

        if (longest.length() == shortest.length())
            return isOneInsertRemoveAway(a, b);
        else
            return isOneInsertRemoveAway(longest, shortest);
    }

    static boolean isOneInsertRemoveAway(String longest, String shortest) {
        int index1 = 0;
        int index2 = 0;
        boolean isDiscrepancy = false;
        while(index1 <longest.length() && index2 < shortest.length()) {
            if (longest.charAt(index1) != shortest.charAt(index2)) {
                if (isDiscrepancy) return false;
                else isDiscrepancy = true;

                if (longest.length() == shortest.length())
                    index2 ++;
            } else {
                index2++;
            }

            index1++;
        }

        return true;
    }

    static boolean isOneReplaceAway(String a, String b) {
        boolean isDiscrepancy = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                if (isDiscrepancy) return false;
                else isDiscrepancy = true;
        }

        return true;
    }



}
