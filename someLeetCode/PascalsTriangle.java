package someLeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        List<Integer> add = List.of(1);
        for (int i = 0; i < numRows - 1; i++) {
            add = pascalify(add);
            res.add(add);
        }
        return res;
    }

    public static List<Integer> pascalify(List<Integer> ust) {
        List<Integer> alt = new ArrayList<>();

        alt.add(1);
        for (int i = 0; i < ust.size() - 1; i++) alt.add(ust.get(i) + ust.get(i + 1));
        alt.add(1);
        return alt;
    }


}
