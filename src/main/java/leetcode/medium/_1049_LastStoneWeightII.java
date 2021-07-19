package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/6/8 9:25
 * @Description: 1049. 最后一块石头的重量 II
 */
public class _1049_LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        if (stones.length < 2) {
            return 0;
        }
        int minW = 0;
        // dp[i] = max(dp[i],dp[i-x]+x)
        return minW;
    }
}
