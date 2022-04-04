package strings;

/**
 * 06/10/18
 *
 * @author Maxim Balan
 **/
public class PalindromePermutationV3 {
    // find if a string can be polindrome (a string that can be written forward and backward the same way)
//    string with even length cannot have chars with odd count
//  string with odd length cannot have all chars with even count
    public static void main(String[] args) {
        String a = "atac ata";

        System.out.println(isPolindrome(a.toCharArray()));
    }

    static boolean isPolindrome(char[] string) {
        int flagVector = 0;

        for (int i = 0; i < string.length; i++) {
            int x = getCharNumber(string[i]);

            if (x != -1) {
                int mask = 1 << x; // create a mask with existing hash index of the char

                //verify if the bit isn't set if true then then set it otherwise unset it
                if ((flagVector & mask) == 0) flagVector |= mask;
                else flagVector &= ~mask;
            }
        }

        return (flagVector & (flagVector - 1)) == 0;
    }

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);

        if (val >= a && val <= z) return val - a;
        else return -1;
    }

}
