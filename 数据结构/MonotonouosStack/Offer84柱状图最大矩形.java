package 数据结构.MonotonouosStack;

import java.util.Stack;

/*
https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
84. 柱状图中最大的矩形
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class Offer84柱状图最大矩形 {

    /*
        按高度遍历柱形图
        对于每个柱子，找到左边第一个小于该柱子的柱子作为左边界；找到右边第一个小于该柱子的柱子作为右边界
        则左右边界围起来的部分，高度都大于当前柱子，即为当前柱子所能组成矩形的最大面积。
        e.g.
        1 6 5 4 5 7 9 1
        对柱子4来说，从6 - 9即为最大的宽度。
        而找到下一个更小元素，NEXT SMALLER ELEMENT问题，可以用单调栈/单调队列来解决
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n]; // 左边第一个小于当前h的柱子
        int[] right = new int[n];// 右边第一个小于当前h的柱子
        left[0] = -1;
        right[n- 1] = n;
        Stack<Integer> stack = new Stack<>();

        // 第一次遍历 求left[]
        stack.push(0);
        for (int i = 1; i < n; i ++){
            while (stack.size() != 0 && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if (stack.size() == 0)
                left[i] = -1;
            else
                left[i] = stack.peek();
            stack.push(i);
        }
        // 第二次遍历 求right[]
        stack.clear();
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i --){
            while (stack.size() != 0 && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if (stack.size() == 0)
                right[i] = n;
            else
                right[i] = stack.peek();
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i ++)
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        return max;

    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));

    }
}
