package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 08/10/18
 *
 * @author Maxim Balan
 **/
public class FindPermutationNumber {
    public static void main(String[] args) {
        int n = 5500;

//        Formula used for permutations: n!/[a!*r1! * r2!... ]
//        To calculate leading zeros count: [(n-1)! / (a-1)! * r1! * r2!]
//        Similar number count: permutations - leading zeros count
//
//        where
//        n = number of digits
//        a = number of zeros
//        r1, r2 - Frequency of the repeated digits

        System.out.println(getSimilarNumbersCount(getDigit(n)));
    }

//    get the digit length of a number
    static List<Integer> getDigit(int n) {
        List<Integer> digit = new ArrayList<>();

        while(n > 0) {
            digit.add(n % 10);
            n /= 10;
        }

        return digit;
    }

//    calculate the factorial of a number
    static int getFactorial(int number) {
        int result = 1;
        for (int i = 1 ; i <= number ; i++) {
            result = result*i;
        }
        return result;
    }

    static int getSimilarNumbersCount(List<Integer> digits) {
        int n = digits.size();
        int a = Collections.frequency(digits, 0); //count how many zeros are in the supplied number
        List<Integer> distinctDigits = new ArrayList<> (new HashSet<>(digits)); // create a copy of the array with only distinct digits

        int denominator = 1;

        for (int i = 0 ; i < distinctDigits.size() ; i++) {
            denominator = denominator * getFactorial(
                Collections.frequency(digits, distinctDigits.get(i))
                                                    );
        }

//        System.out.println(denominator);

        int permutation = getFactorial(n)/denominator;
        if (a > 0) { // If there are zeros in the number
            denominator = 1;

            for (int i = 0 ; i < distinctDigits.size() ; i++) {
                if (distinctDigits.get(i) == 0) {
                    denominator = denominator * getFactorial(Collections.frequency(digits, distinctDigits.get(i))-1);
                } else {
                    denominator = denominator * getFactorial(Collections.frequency(digits, distinctDigits.get(i)));
                }
            }
            int leadingZeroCount = getFactorial(n-1)/denominator;
            permutation = permutation - leadingZeroCount;
        }
        return permutation;
    }
}
