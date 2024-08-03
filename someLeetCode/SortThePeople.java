package someLeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> heiName = new HashMap<>();

        for (int i = 0; i < names.length; i++) heiName.put(heights[i], names[i]);

        Integer[] reverseSortedHeights = Arrays.stream(heights).boxed().toArray(Integer[]::new);
        Arrays.sort(reverseSortedHeights, Collections.reverseOrder());

        String[] ans = new String[names.length];

        for (int i = 0; i < names.length; i++) ans[i] = heiName.get(reverseSortedHeights[i]);

        return ans;
    }
}
