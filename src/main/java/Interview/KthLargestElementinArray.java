package Interview;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/4/27 12:50
 * @Description: 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class KthLargestElementinArray {
    /**
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    /**
     * 本类题扩展，在未排序数组中寻找中位数
     * @return
     */
    private int findMidInUnSortedArr(){
        return 0;
    }
}
