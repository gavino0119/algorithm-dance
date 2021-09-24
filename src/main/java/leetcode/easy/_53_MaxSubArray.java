package leetcode.easy;

import java.util.Arrays;

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

        int[] nums = maxSubArray(arr);
        System.out.println(Arrays.toString(nums));
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

    /**
     * 变种题，返回最大和的子序列
     * 返回最大子序和以及起始索引和结束索引
     * @param nums
     * @return
     */
    public static int[] maxSubArray(int[] nums) {
        {
            int sum = 0;
            int res = Integer.MIN_VALUE;
            int start = 0, end = 0;
            int finS = 0, finE = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > 0) {
                    end = i;
                    nums[i] += nums[i - 1];
                } else {
                    start = end = i;
                }
                if (res < nums[i]) {
                    finS = start;
                    finE = end;
                    res = nums[i];
                }
            }
            return new int[]{finS, finE, res};
        }
    }
}
