package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/6/10 9:23
 * @Description: 322. 零钱兑换
 * 可以凑成总金额所需的最少的硬币个数
 */
public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            //
            dp[i] = Integer.MAX_VALUE;
        }
        //dp[i]:换到面值i所用的最小数量
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
