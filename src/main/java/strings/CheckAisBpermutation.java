package strings;

/**
 * 06/10/18
 **/
public class CheckAisBpermutation {

    public static void main(String[] args) {
        String a = "asd ";
        String b = "sda";

        System.out.printf("is b [ %s ] permutation of a [ %s ]: %b%n", b, a, check(a, b));
    }


    //    time complexity is O(n) where "n" is the length of any of the strings
//    space complexity is O(1)
    static boolean check(String a, String b) {
        if (a.length() != b.length()) return false;

        int sumA = 0, sumB = 0;
        for (int i = 0; i < a.length(); i++) {
            sumA += a.charAt(i);
            sumB += b.charAt(i);
        }

        return sumA == sumB;
    }


}
