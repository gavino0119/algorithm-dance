package hot;

public class FindDuplicate_287 {
    /**
     * Solution1 一个萝卜一个坑
     *
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        return 0;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * Solution2 类似链表成环，判圈
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 2};
        int res = findDuplicate1(arr);
        System.out.println(res);
    }
}
