package leetcode.easy;

/**
 * @author ywg
 * @version 1.0
 * @description 删除有序数组中的重复项
 * @date 2021/4/18 10:54
 */
public class _26_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,4,5,5,5,6,6,7,7,8,9};
        System.out.println(removeDuplicates(arr));
    }
}
