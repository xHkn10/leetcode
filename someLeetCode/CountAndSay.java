package someLeetCode;

public class CountAndSay {
    public static String countAndSay(int n) {
        String s = "1";
        while (--n > 0) {
            s = rle(s);
        }
        return s;
    }

    private static String rle(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            int counter = 1;
            while (i != chars.length - 1 && chars[i] == chars[i + 1]) {
                counter++;
                i++;
            }
            sb.append(counter);
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

}
