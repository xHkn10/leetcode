package someLeetCode;

import java.util.ArrayList;

public class GeneratingSubsets {

    private static void starter(int n) {
        generate(n, new ArrayList<>());
    }
    private static void generate(int n, ArrayList<Integer> subset) {
        if (n == 0) {
            System.out.println(subset);
            return;
        }
        generate(n - 1, subset);
        subset.add(n);
        generate(n - 1, subset);
        subset.removeLast();
    }

    public static void main(String[] args) {
        starter(5);
    }
}
