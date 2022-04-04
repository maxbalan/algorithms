package strings;

/**
 * 23/10/18
 * <p>
 * Question:
 * <p>
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and
 * s2, write a code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g. fightfirefi is a rotation
 * of firefight)
 * <p>
 * solution 1:
 * now consider that xy = s1 and yx = s2, so now to find s2 we need to cut s1 into to so basically into x and y and rearrange
 * them in order to get s2(yx) so in other words if we do s1+s1 = xyxy as you can se the s2(yx) is in there
 **/
public class StringSubstringV1 {

    public static void main(String[] args) {
        String s1 = "firefight";
        String s2 = "ghtfirefi";

        boolean r = isRotation(s1, s2);
        System.out.println(String.format("S2 [ %s ] is a rotation of S1 [ %s ] is [ %b ]", s2, s1, r));

        s1 = "firefight";
        s2 = "ghtfire";

        r = isRotation(s1, s2);
        System.out.println(String.format("S2 [ %s ] is a rotation of S1 [ %s ] is [ %b ]", s2, s1, r));
    }

    private static boolean isRotation(String original, String check) {
        // if any of the strings is null then return false

        if (original == null || check == null) return false;

        //if their lengths is different then it makes no sense to go further, its not a rotation
        int ol = original.length();
        int cl = check.length();

        if (ol != cl && ol > 0 && cl > 0) return false;


        return isSubstring(original + original, check);
    }

    //assume you have no idea what is going on inside here, this just for the test
    private static boolean isSubstring(String original, String check) {
        int cl = check.length();

        if (original.length() == cl * 2)
            return original.contains(check);
        else
            return false;
    }

}
