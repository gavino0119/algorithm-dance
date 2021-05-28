package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yanwg
 * @Date 2021/5/26 9:19
 * @Description: 1306. 跳跃游戏 III
 * 一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 */
public class _1306_CanReachIII {
    /**
     * bfs
     * @param arr
     * @param start
     * @return
     */
    public boolean canReachBFS(int[] arr, int start) {
        int len=arr.length;
        // 存放已搜位置
        boolean[] dp=new boolean[len];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int x=queue.poll();
            if(x+arr[x]<len&&!dp[x+arr[x]]){
                dp[x+arr[x]]=true;
                queue.add(x+arr[x]);
                if(arr[x+arr[x]]==0){
                    return true;
                }
            }
            if(x-arr[x]>=0&&!dp[x-arr[x]]){
                dp[x-arr[x]]=true;
                queue.add(x-arr[x]);
                if(arr[x-arr[x]]==0){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS
     * @param arr
     * @param start
     * @return
     */
    public boolean canReachDFS(int[] arr, int start) {
        // 初始化一个长度为arr的boolean数组，记录已访问过的位置
        boolean[] visited = new boolean[arr.length];
        // 深度优先遍历
        return dfs(arr,start,visited);
    }
    private boolean dfs(int[] arr, int start, boolean[] visited) {
        // 如果start位置直接就是0
        if (arr[start] == 0){
            return true;
        }

        // 记录start位置已被访问
        visited[start] = true;

        // 处理start左边的元素
        int left = start - arr[start];
        if (left >= 0 && !visited[left] && dfs(arr,left,visited)){
            return true;
        }
        // 处理start右边的元素
        int right = start + arr[start];
        if (right < arr.length && !visited[right] && dfs(arr,right,visited)){
            return true;
        }
        // 没有能达到0的位置
        return false;
    }
}
