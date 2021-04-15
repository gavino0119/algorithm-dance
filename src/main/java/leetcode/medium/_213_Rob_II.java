package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/4/15 9:48
 * @Description: 打家劫舍 II
 * dp[i]=max(dp[i−2]+nums[i],dp[i−1])
 * 1. 偷第一家，不偷最后一家[0,n-2]
 * 2. 偷最后一家，不偷第一家[1,n-1]
 */
public class _213_Rob_II {
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }else if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(doIt(0,nums.length-2,nums),doIt(1,nums.length-1,nums));
    }

    private static int doIt(int start,int end, int[] nums){
        int first = nums[start];
        int second = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end ; i++) {
            int tmp = second;
            second = Math.max(first+nums[i],second);
            first = tmp;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        System.out.println(rob(arr));
    }
}
