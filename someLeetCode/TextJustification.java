package someLeetCode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int[] letterCounts = new int[words.length];
        for (int i = 0; i < words.length; i++) letterCounts[i] = words[i].length();
        List<String> ans = new ArrayList<>();

        int i = 0;
        while (i < words.length) {
            int totalChars = 0;
            int wordsInTheLine = 0;
            int start = i;
            while (i < words.length && maxWidth - totalChars - wordsInTheLine >= letterCounts[i]) {
                totalChars += letterCounts[i++];
                wordsInTheLine++;
            }
            int blanksLeft = maxWidth - totalChars;

            StringBuilder oneAns = new StringBuilder();
            int j = start;
            oneAns.append(words[j++]);
            wordsInTheLine--;
            while (wordsInTheLine > 0) {
                while (wordsInTheLine > 0 && blanksLeft % wordsInTheLine == 0) {
                    int space = blanksLeft / wordsInTheLine;
                    wordsInTheLine--;
                    oneAns.append(space(space));
                    oneAns.append(words[j++]);
                    blanksLeft -= space;
                }
                if (wordsInTheLine > 0 && blanksLeft % wordsInTheLine != 0) {
                    int space = blanksLeft / wordsInTheLine + 1;
                    wordsInTheLine--;
                    oneAns.append(space(space));
                    oneAns.append(words[j++]);
                    blanksLeft -= space;
                }
            }
            if (blanksLeft != 0) for (; blanksLeft > 0; blanksLeft--) oneAns.append(" ");
            ans.add(oneAns.toString());
        }
        fixLast(ans, maxWidth);
        return ans;
    }

    private static StringBuilder space(int n) {
        StringBuilder sb = new StringBuilder();
        for (; n > 0; n--) sb.append(" ");
        return sb;
    }

    private static void fixLast(List<String> ans, int maxWidth) {
        StringBuilder s = new StringBuilder(ans.removeLast());
        s = new StringBuilder(s.toString().replaceAll("\\s+", " "));
        s.append(" ".repeat(maxWidth - s.length()));
        ans.add(s.toString());
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(words, 16));

        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        System.out.println(fullJustify(words2, 16));

        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
                "computer.", "Art", "is", "everything", "else", "we", "do"};
        System.out.println(fullJustify(words3, 20));
    }
}
