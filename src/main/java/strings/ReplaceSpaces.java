package strings;

/**
 * 06/10/18
 **/
public class ReplaceSpaces {
    public static void main(String[] args) {
        // replace all white spaces of a string with %20, assume we are given the true length of the string and that
        // the string has enough spaces at the end to accommodate extra characters

        String a = "m n b    ";
        char[] b = a.toCharArray();
        int trueLength = a.trim().length();

//        System.out.println(b);
        replace(b, trueLength);
        System.out.println(b);
    }

    static void replace(char[] a, int trueLength) {
        // find spaces
        int spacesCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (a[i] == ' ') spacesCount++;
        }

        //calculate the final length
        int index = trueLength + (spacesCount * 2) - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (a[i] == ' ') {
                a[index] = '0';
                a[index - 1] = '2';
                a[index - 2] = '%';

                index -= 3;
            } else {
                a[index] = a[i];
                index--;
            }
        }
    }
}
