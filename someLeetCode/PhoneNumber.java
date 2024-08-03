package someLeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PhoneNumber {

    static int[] ints = {2, 3, 4, 5, 6, 7, 8, 9};
    static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinationsRecursive(String digits) {
        if (digits.isEmpty()) return List.of();

        int len = digits.length();

        String subSt = digits.substring(0, len - 1);
        String permute = map[digits.charAt(len - 1) - 50];
        List<String> subProblem = letterCombinationsRecursive(subSt);

        return stMultiplier(subProblem, permute);
    }

    private static List<String> stMultiplier(List<String> list, String s) {

        if (list.isEmpty()) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                result.add(s.charAt(i) + "");
            }
            return result;
        }

        List<String> result = new ArrayList<>();
        char[] sChars = s.toCharArray();

        for (char c : sChars) {
            for (String toApp : list) {
                toApp += c;
                result.add(toApp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinationsIterative("234"));
    }

    public static List<String> letterCombinationsIterative(String digits) {

        int len = digits.length();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < len; i++) result = permutate(result, digits.charAt(i));

        return result;
    }

    private static List<String> permutate(List<String> list, char c) {
        StringBuilder sb = new StringBuilder(map2[c - 48]);
        List<String> result = new ArrayList<>();
        list = new ArrayList<>(list);
        if (list.isEmpty()) {
            for (int i = 0; i < sb.length(); i++) {
                result.add(sb.charAt(i) + "");
            }
            return result;
        }
        //umutsuz deneme
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            StringBuilder it = new StringBuilder(listIterator.next());
            listIterator.remove();
            for (int i = 0; i < sb.length(); i++) {
                StringBuilder copy = new StringBuilder(it);
                copy.append(sb.charAt(i));
                result.add(copy.toString());
            }
        }
        return result;
    }

    static String[] map2 = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
}
