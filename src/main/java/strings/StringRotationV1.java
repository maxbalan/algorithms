package strings;

import java.util.LinkedList;

/**
 * 23/10/18
 *
 * Question:
 *
 * write an algorithm which checks if one word is a substring of another. Given two strings, s1 and
 * s2, write a code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g. fightfirefi is a rotation
 * of firefight)
 *
 * solution 1:
 * Use linked list to rotate characters around get and remove first one and put at the end then convert the list to a
 * string and compare with the expected
 *
 * @author Maxim Balan
 **/
public class StringRotationV1 {

    public static void main(String[] args) {
        String s1 = "firefight";
        String s2 = "ghtfirefi";

        boolean r = isSubstring(s1, s2);
        System.out.println(String.format("S2 [ %s ] is a rotation of S1 [ %s ] is [ %b ]", s2, s1, r));

        s1 = "firefight";
        s2 = "ghtfire";

        r = isSubstring(s1, s2);
        System.out.println(String.format("S2 [ %s ] is a rotation of S1 [ %s ] is [ %b ]", s2, s1, r));
    }

    private static boolean isSubstring(String original, String check) {
        boolean result = false;

        //check if the current format is the same string
        if (original.equalsIgnoreCase(check)) return true;

        LinkedList<Character> ll = new LinkedList<>();
        for (char s : check.toCharArray()) {
            ll.add(s);
        }

        StringBuilder sb;
        char firstChar;
        int stringLength = ll.size();
        for (int i = 0; i < stringLength; i++) {

            sb = new StringBuilder();
            firstChar = ll.pollFirst(); //save first char so we can put it at the end
            ll.addLast(firstChar);

            for (int x = 0; x < stringLength; x++) {
                sb.append(ll.get(x));
            }

            if (sb.toString().equalsIgnoreCase(original)) {
                result = true;
                break;
            }
        }

        return result;
    }


}
