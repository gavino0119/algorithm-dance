package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author yanwg
 * @Date 2021/6/2 11:10
 * @Description: 连续的子数组和
 *
    子数组大小 至少为 2 ，且
    子数组元素总和为 k 的倍数。
 */
public class _523_CheckSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2){
            return false;
        }
        int l=0;
        int r=l+1;
        while (l<nums.length-1){
            int sum = nums[l];
            while (r<nums.length){
                sum += nums[r];
                if (sum % k == 0) {
                    return true;
                }
                r++;
            }
            l++;

        }
        return false;
    }

    /**
     * 前缀和+hashset
     * @param nums
     * @param k
     * @return
     */
    private static boolean sanye(int[] nums, int k){
        int n = nums.length;
        // 前缀和数组
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();

        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 同余定理
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumGuanFang(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,0,0,0};
        int k = 3;
        System.out.println(checkSubarraySum(arr,k));
        System.out.println(sanye(arr,k));

        System.out.println(0%3);
    }
}
