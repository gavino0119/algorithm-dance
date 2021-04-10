package lcof;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author yanwg
 * @Date 2021/4/10 15:41
 * @Description: 剑指Offer 找数组中重复的数字
 */
public class _03_FindRepeatNumber {
    /**
     * 双指针+map
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        int l = 0, r = nums.length - 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (l < r) {
            if (map.keySet().contains(nums[l])) {
                return nums[l];
            } else {
                map.put(nums[l], 1);
            }
            if (map.keySet().contains(nums[r])) {
                return nums[r];
            } else {
                map.put(nums[r], 1);
            }
            l++;
            r--;
        }

        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        // 1. 初始化一个哈希表
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 2. 判断当前元素是否已经存在
            if (set.contains(nums[i])) {
                // 如果存在，则直接返回
                return nums[i];
            }

            // 否则的话，将当前元素放入到哈希表中，方便后续的查找判重
            set.add(nums[i]);
        }
        return -1;
    }

    /**
     * 数组代替hash表
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        // 1. 初始化一个数组
        int[] bucket = new int[nums.length];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < nums.length; i++) {
            // 2. 判断当前元素是否已经存在
            if (bucket[nums[i]] != -1) {
                // 如果存在，则直接返回
                return nums[i];
            }
            // 否则的话，将当前元素作为索引，当前元素的下标作为值，填入数组中，
            // 方便后续的查找判重
            bucket[nums[i]] = i;
        }
        return -1;
    }


    /**
     * 一个萝卜一个坑的思路(数与下标)
     * 优解
     * @param nums
     * @return
     */
    public int findRepeatNumber4(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 有重复
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 交换使萝卜入坑
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
