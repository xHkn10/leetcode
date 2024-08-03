package someLeetCode;

import java.util.Arrays;

class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.length() > num2.length()) return multiply(num2, num1);

        char[] chars1 = num1.toCharArray();
        int[] ints1 = new int[chars1.length];
        char[] chars2 = num2.toCharArray();
        int[] ints2 = new int[chars2.length];
        int[][] products = new int[chars1.length][chars2.length + 1];

        for (int i = 0; i < chars1.length; i++) ints1[i] = chars1[i] - 48;
        for (int i = 0; i < chars2.length; i++) ints2[i] = chars2[i] - 48;

        int pY = 0;
        for (int i = ints1.length - 1; i >= 0; i--) {
            int elde = 0;
            int pX = ints2.length;
            for (int j = ints2.length - 1; j >= 0; j--) {
                String res = String.valueOf(ints1[i] * ints2[j] + elde);
                elde = res.length() == 2 ? res.charAt(0) - 48 : 0;
                products[pY][pX] = res.length() == 2 ? res.charAt(1) - 48 : ints1[i] * ints2[j];
                pX--;
            }
            products[pY][pX] = elde;
            pY++;
        }

        System.out.println(Arrays.deepToString(products));
        return null;
    }

    public static void main(String[] args) {
        multiply("987", "56");
        multiply("123", "12");
        multiply("213472", "820164321");
    }
}

class leet {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("987", "98"));
    }
}
