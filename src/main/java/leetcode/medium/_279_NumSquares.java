package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/6/11 9:14
 * @Description: 完全平方数
 * 完全平方数：对于一个正整数n,找出若干个完全平方数使其和为n,返回完全平方数最少数量
 * 完全背包的最值问题：完全平方数最小为1,最大为sqrt(n),故题目转换为在nums=[1,2.....sqrt(n)]中选任意数平方和为target=n
 * 外循环nums,内循环target正序,应用转移方程dp[i] = max/min(dp[i], dp[i-nums]+1)或dp[i] = max/min(dp[i], dp[i-num]+nums);
 */
public class _279_NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int num = 1; num <= Math.sqrt(n) ; num++) {
            for (int target = 0; target <= n; target++) {
                if (target >= num * num) {
                    dp[target] = Math.min(dp[target],dp[target-num*num]+1);
                }
            }
        }
        return dp[n];
    }
}
