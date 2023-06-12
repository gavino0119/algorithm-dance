package hot;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 */
public class SubarraySum_560 {
    /**
     * 前缀和
     */
    private static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + hash 优化
     */
    private static int subarraySumOpt(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumMap = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumMap.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumMap.containsKey(preSum - k)) {
                count += preSumMap.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1};
        System.out.println(subarraySum(arr, 2));
        System.out.println(subarraySumOpt(arr, 2));
    }
}
