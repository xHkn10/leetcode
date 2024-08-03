package someLeetCode;

import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] mem = new int[triangle.size()][triangle.getLast().size()];

        mem[0][0] = triangle.getFirst().getFirst();

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    mem[i][0] = mem[i - 1][0] + triangle.get(i).getFirst();
                } else if (j == triangle.get(i).size() - 1) {
                    mem[i][j] = mem[i - 1][j - 1] + triangle.get(i).getLast();
                } else {
                    mem[i][j] = Math.min(mem[i - 1][j - 1], mem[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : mem[mem.length - 1]) ans = Math.min(ans, i);
        return ans;
    }

    private static void arrayCopy(int[] source, int[] dest) {
        System.arraycopy(source, 0, dest, 0, source.length);
    }


    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
        System.out.println(minimumTotal(List.of(List.of(1), List.of(2, 3))));

    }
}
