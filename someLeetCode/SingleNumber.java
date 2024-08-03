package someLeetCode;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int[] result = new int[60_001];
        for (int num : nums) result[num + 30_000]++;
        for (int i = 0; ; i++) if (result[i] == 1) return i - 30_000;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }
}
