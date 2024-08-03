package someLeetCode;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] freq = new char[26];
            char[] chars = s.toCharArray();
            for (char c : chars) {
                freq[c - 'a']++;
            }
            String key = new String(freq);
            if (map.containsKey(key)) map.get(key).add(s);
            else map.put(key, new ArrayList<>(List.of(s)));
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"}));
    }
}
