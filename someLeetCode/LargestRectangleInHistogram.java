package someLeetCode;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int[] prevSmaller = ps(heights);
        int[] nextSmaller = ns(heights);

        int max = -1;
        for (int i = 0; i < heights.length; i++) {
            int hei = heights[i];
            int left = prevSmaller[i];
            int right = (nextSmaller[i] == -1 ? heights.length : nextSmaller[i]);

            max = Math.max(max, hei * (right - left - 1));
        }
        return max;
    }

    private static int[] ps(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private static int[] ns(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
