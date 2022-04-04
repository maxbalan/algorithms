package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 08/10/18
 *
 * @author Maxim Balan
 **/
public class FindAllPermutations {
    List<String> results = new ArrayList<>();
    int counter = 0;

    public static void main(String[] args) {
        int n = 3320000;

        FindAllPermutations a = new FindAllPermutations();
        a.permutation("" + n);

        System.out.println(a.counter);
    }

    void permutation(String str) {
        permutation(str, "");
        System.out.println("Counter = $counter");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            boolean a = prefix.charAt(0) == '0';
            if (!a) {
                if (!results.contains(prefix)) {
                    results.add(prefix);
                    this.counter++;
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                String a = str.substring(0, i);
                String b = str.substring(i + 1);
                String rem = a + b;

                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
