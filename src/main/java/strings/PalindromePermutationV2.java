package strings;

/**
 * 06/10/18
 **/
public class PalindromePermutationV2 {
    // find if a string can be polindrome (a string that can be written forward and backward the same way)
//    string with even length cannot have chars with odd count
//  string with odd length cannot have all chars with even count
    public static void main(String[] args) {
        String a = "atac ata";

        boolean isPolindorome = stringToHashTable(a);

        System.out.println("Is polindrome: " + isPolindorome);
    }

    // convert a string into a hash table of counts of all unique chars
    static boolean stringToHashTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int countOdd = 0;

        for (int i = 0; i < str.length(); i++) {
            int x = getCharNumber(str.charAt(i));

            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) countOdd++;
                else countOdd--;
            }
        }
        return countOdd <= 1;
    }

    // get a numeric value for a char and -1 for any other char that is not in the range [a to z]
    // it is case insensitive
    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int input = Character.getNumericValue(c);

        if (a <= input && input <= z) {
            return input - a;
        }

        return -1;
    }


}
