package someLeetCode;

public class MonotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int n) {
        char[] num = String.valueOf(n).toCharArray();

        for (int i = 0; i < num.length - 1 && i >= 0; i++) {
            if (num[i] <= num[i + 1]) continue;
            num[i]--;
            for (int j = i + 1; j < num.length; j++) {
                num[j] = '9';
            }
            i -= 2;
        }
        return Integer.parseInt(new String(num));
    }

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(1234));
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(33332));
    }
}
