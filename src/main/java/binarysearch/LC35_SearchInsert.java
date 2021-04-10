package binarysearch;

/**
 * @Author yanwg
 * @Date 2021/4/10 16:46
 * @Description: 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class LC35_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        //注意循环条件
        while (left <= right) {
            //求mid
            int mid = left + ((right - left ) >> 1);
            //查询成功
            if (target == nums[mid]) {
                return mid;
                //右区间
            } else if (nums[mid] < target) {
                left = mid + 1;
                //左区间
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        //返回插入位置
        return left;
    }
}
