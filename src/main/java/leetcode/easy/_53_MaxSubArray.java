package leetcode.easy;

/**
 * @Author yanwg
 * @Date 2021/8/17 9:32
 * @Description:
 */
public class _53_MaxSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(arr));

        System.out.println(maxSubArray2(arr));
    }

    /**
     * dp  f(i)=max{f(i−1)+nums[i],nums[i]}
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    /**
     * 分治
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        return 0;
    }
}
