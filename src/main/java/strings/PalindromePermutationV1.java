package strings;

/**
 * 06/10/18
 **/
public class PalindromePermutationV1 {
    // find if a string can be palindrome (a string that can be written forward and backward the same way)
//    string with even length cannot have chars with odd count
//  string with odd length cannot have all chars with even count
    public static void main(String[] args) {
        String a = "atac ata";

        int[] table = stringToHashTable(a);
        boolean isPolindorome = checkMaxOneOdd(table);

        System.out.println("Is polindrome: " + isPolindorome);
    }

    static boolean checkMaxOneOdd(int[] table) {
        boolean oddFound = false;

        for (int i : table) {
            if (i % 2 == 1) {
                if (oddFound) {
                    return false;
                }
                oddFound = true;
            }
        }

        return true;
    }

    // convert a string into a hash table of counts of all unique chars
    static int[] stringToHashTable(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : str.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }

        return table;
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
