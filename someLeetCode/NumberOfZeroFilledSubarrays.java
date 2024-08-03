package someLeetCode;

public class NumberOfZeroFilledSubarrays {

    public static long zeroFilledSubarray(int[] nums) {

        long ans = 0;
        int counter = 0;
        for (int num : nums) {
            if (num == 0) counter++;
            else {
                if (counter != 0) {
                    ans += (long) counter * (counter + 1) / 2;
                    counter = 0;
                }
            }
        }
        if (counter != 0) ans += (long) counter * (counter + 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));

    }
}
