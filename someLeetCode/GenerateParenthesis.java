package someLeetCode;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParenthesis {
    private static class Eleman {
        StringBuilder sb;
        int len;
        boolean everBeenNeg;

        Eleman(Eleman ata) {
            this.sb = new StringBuilder(ata.sb);
            this.len = ata.len;
            this.everBeenNeg = ata.everBeenNeg;
        }

        Eleman() {
            sb = new StringBuilder();
            len = 0;
            everBeenNeg = false;
        }

        Eleman ekle(int n) {
            Eleman yeni = new Eleman(this);
            if (n == -1) {
                yeni.sb.append('(');
                yeni.len++;
            } else {
                yeni.sb.append(')');
                yeni.len--;
                if (yeni.len < 0) yeni.everBeenNeg = true;
            }
            return yeni;
        }
    }

    public static List<String> generateParenthesisBFS(int n) {
        List<String> ans = new ArrayList<>();

        Queue<Eleman> queue = new LinkedList<>();

        queue.offer(new Eleman());

        while (!queue.isEmpty()) {
            Eleman ata = queue.poll();
            if (ata.len == 0 && ata.sb.length() == 2 * n) ans.add(ata.sb.toString());

            Eleman sol = ata.ekle(-1);
            Eleman sag = ata.ekle(1);

            if (!sol.everBeenNeg && sol.len <= 2 * n - sol.sb.length()) queue.offer(sol);
            if (!sag.everBeenNeg) queue.offer(sag);
        }

        return ans;
    }

    public static void main(String[] args) {
        long one = System.nanoTime();
        generateParenthesisBFS(5);
        long two = System.nanoTime();
        generateParenthesisDFS(5);
        long three = System.nanoTime();
        System.out.println(generateParenthesis(5));
        long four = System.nanoTime();

        System.out.println("BFS approach: " + (two - one) + ", " + String.valueOf(two - one).length());
        System.out.println("my DFS approach: " + (three - two) + ", " + String.valueOf(three - two).length());
        System.out.println("other DFS approach: " + (four - three + ", " + String.valueOf(four - three).length()));
    }

    public static List<String> generateParenthesisDFS(int n) {
        if (n == 0) return List.of();

        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    private static void backtrack(StringBuilder paranthesis, int left, int right, int n, List<String> ans) {
        if (left + right == 2 * n) {
            ans.add(paranthesis.toString());
            return;
        }

        if (left >= right && left - right < 2 * n - left - right) {
            backtrack(new StringBuilder(paranthesis).append('('), left + 1, right, n, ans);
        }
        if (left >= right) {
            backtrack(new StringBuilder(paranthesis).append(')'), left, right + 1, n, ans);
        }

    }


    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        realBacktrackingByDeletion(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void realBacktrackingByDeletion(List<String> res, StringBuilder sb, int openN, int closedN, int n) {
        if (openN == n && closedN == n) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append('(');
            realBacktrackingByDeletion(res, sb, openN + 1, closedN, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closedN < openN) {
            sb.append(')');
            realBacktrackingByDeletion(res, sb, openN, closedN + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
