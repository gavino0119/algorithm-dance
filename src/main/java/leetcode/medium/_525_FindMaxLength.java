package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yanwg
 * @Date 2021/6/3 9:23
 * @Description: 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 0 010101
 * 000111 0
 *
 * 前缀和   将问题转化为：如何求得最长一段区间和为 0 的子数组。
 * 将0看做-1  ------->  求和为0
 */
public class _525_FindMaxLength {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        // 下标 0 之前的位置是 -1
        map.put(counter, -1);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 把数组中的 0 都看成 -1
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,1};
        // [0,-1] len = 0
        // [-1,0] len = 0
        // [0,1->-1] len = 1-(-1)=2
        // [-1,2->0] len = 2-0=2
        // [0,3->-1] len = 3-(-1)=4
        System.out.println(findMaxLength(arr));
    }
}


