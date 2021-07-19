package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/6/10 9:14
 * @Description:  518. 零钱兑换 II
 * 凑成总金额的硬币组合数
 *
 * 比较爬楼梯--（组合和排列的不同）
 */
public class _518_ChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
