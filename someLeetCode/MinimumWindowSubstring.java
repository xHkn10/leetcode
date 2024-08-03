package someLeetCode;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, start = -1, required = t.length();
        int[] needed = new int[128];
        int[] curr = new int[128];

        t.chars().forEach(c -> needed[c]++);

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            curr[rightChar]++;
            if (needed[rightChar] >= curr[rightChar]) {
                required--;
            }
            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                if (curr[s.charAt(left)] > needed[s.charAt(left)]) {
                    curr[s.charAt(left)]--;
                    left++;
                }
                else if (curr[s.charAt(left)] == needed[s.charAt(left)]) {
                    curr[s.charAt(left)]--;
                    left++;
                    required++;
                }
            }
            right++;
        }

        return (minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen));
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("bba", "ab"));
    }
}
