package dp;

/**
 * @Author yanwg
 * @Date 2021/4/15 15:27
 * @Description: 打家劫舍
 * 要么抢上一家   要么抢上上家
 * dp[n] = Max(dp[n-2]+nums[n],dp[n-1])
 */
public class Rob {
    /**
     * 使用数组存储结
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 优化
     * 考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关
     * 因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println(rob(arr));
    }
}
