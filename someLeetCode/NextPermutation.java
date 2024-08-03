package someLeetCode;

import java.util.*;

class NextPermutation { //NEEDS HELLA OPTIMIZATION

    public static void nextPermutation(int[] nums) {
        Integer[] sorted = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted);
        ArrayList<Integer> sortedList = new ArrayList<>(Arrays.asList(sorted));

        int location = encode(sortedList, nums);
        ArrayList<Integer> code = decode(location, sorted);
        theAnswer(code, sorted, nums);


    }

    static int encode(ArrayList<Integer> sortedList, int[] nums) {
        int formula = 0;
        int len = sortedList.size();

        for (int num : nums) {
            ListIterator<Integer> it = sortedList.listIterator();
            while (it.hasNext()) { //use binary search
                if (num == it.next()) {
                    int s = it.nextIndex() - 1;
                    formula += s * fact(--len);
                    it.remove();
                    break;
                }
            }
        }
        return formula;
    }

    static int fact(int i) {
        int res = 1;
        for (; i > 0; i--) res *= i;
        return res;
    }

    static ArrayList<Integer> decode(int location, Integer[] sorted) {
        if (location == fact(sorted.length) - 1) {
            int[] zeros = new int[sorted.length];
            return new ArrayList<>(List.of(Arrays.stream(zeros).boxed().toArray(Integer[]::new)));
        }
        ArrayList<Integer> code = new ArrayList<>();

        for (int l = sorted.length - 1; l > 0; l--) {
            for (int k = l; k >= 0; k--) {
                if (k * fact(l) <= location + 1) {
                    code.add(k);
                    location -= k * fact(l);
                    break;
                }
            }
        }
        code.add(0);
        return code;
    }

    static void theAnswer(ArrayList<Integer> code, Integer[] sorted, int[] nums) {
        List<Integer> numsArrList = new ArrayList<>(Arrays.stream(sorted).toList());

        for (int i = 0; i < code.size(); i++) {
            int c = code.get(i);
            int num = numsArrList.get(c);
            numsArrList.remove(c);
            nums[i] = num;
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}