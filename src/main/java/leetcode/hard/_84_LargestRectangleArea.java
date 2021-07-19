package leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/6/18 15:19
 * @Description: 柱状图中最大的矩形
 * 单调栈
 */
public class _84_LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && heights[stack.peekFirst()]>=heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.push(i);

        }
        stack.clear();
        for (int i=n-1;i>=0;i--){
            while (!stack.isEmpty() && heights[stack.peekFirst()]>=heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? -1 : stack.peekFirst();
            stack.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }

        return ans;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,6,2,3};// 10
        System.out.println(largestRectangleArea(arr));
    }
}
