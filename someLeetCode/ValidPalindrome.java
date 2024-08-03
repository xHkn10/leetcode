package someLeetCode;

import java.util.Vector;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 1) return true;

        char[] str = s.toCharArray();

        int i = 0;
        int j = str.length - 1;

        while (true) {
            while (i < str.length && !Character.isLetterOrDigit(str[i])) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(str[j])) {
                j--;
            }
            if (j < i) break;

            if (Character.toLowerCase(str[i]) != Character.toLowerCase(str[j])) return false;

            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("  a       a"));

    }


}
