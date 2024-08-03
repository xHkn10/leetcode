package someLeetCode;

import java.util.*;

class permutate {
    static boolean[] chosen;

    static void generatePermutations(ArrayList<Integer> arr) {
        chosen = new boolean[arr.size()];
        generatePermutations(arr, new ArrayList<>());
    }

    static void generatePermutations(ArrayList<Integer> arr, ArrayList<Integer> permutation) {
        if (permutation.size() == arr.size()) System.out.println(permutation);
        else {
            for (int i = 0; i < arr.size(); i++) {
                Integer x = arr.get(i);
                if (chosen[i]) continue;
                permutation.add(x);
                chosen[i] = true;
                generatePermutations(arr, permutation);
                permutation.remove(x);
                chosen[i] = false;
            }
        }
    }



    public static void main(String[] args) {
        generatePermutations(new ArrayList<>(Arrays.asList(1, 1, 3)));
    }
}
