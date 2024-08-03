package someLeetCode;

public class MaxChunksToMakeSorted {
    public static int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int chunk = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != arr[i] && arr[i] > chunk) chunk = arr[i];
            else if (i == arr[i] && chunk < i) ans++;
            if (i == chunk) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(maxChunksToSorted(new int[]{2, 3, 1, 0}));
    }
}
