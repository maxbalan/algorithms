package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 09/10/18
 *
 * @author Maxim Balan
 **/
public class StringCompression {
    /**
     * Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3 . If the
     * "compressed" string would not become smaller than the original string, your method should return
     * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     */

    public static void main(String[] args) {
        String a = "aaaaabbbbbbcccccddddd";

        String result = compression(a);

        System.out.println(String.format("String [ %s ] compressed to [ %s ]", a, result));

        a = "absdcef";
        result = compression(a);
        System.out.println(String.format("String [ %s ] compressed to [ %s ]", a, result));

        a = "absdceff";
        result = compression(a);
        System.out.println(String.format("String [ %s ] compressed to [ %s ]", a, result));

        a = "absdcefff";
        result = compression(a);
        System.out.println(String.format("String [ %s ] compressed to [ %s ]", a, result));
    }

    static String compression(String str) {
        List<Character> characters = new ArrayList<>();

        //dump each char into the list
        for (char c : str.toCharArray())
            characters.add(c);

        //now create a hash set of the unique chars
        List<Character> hashed = new ArrayList<>(new HashSet<>(characters));

        //if unique length is the same as string length there is no point in compressing according to requirements
        if (hashed.size() == characters.size()) return str;

        StringBuilder sb = new StringBuilder();

        for (char c : hashed) {
            if (sb.length() > characters.size()) return str;

            sb.append(c);
            sb.append(Collections.frequency(characters, c));
        }

        return sb.toString();
    }
}
