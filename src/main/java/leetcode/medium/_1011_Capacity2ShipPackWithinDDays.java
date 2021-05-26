package leetcode.medium;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/4/26 13:21
 * @Description:
 */
public class _1011_Capacity2ShipPackWithinDDays {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,7,2,44,7,99,65,4,36,7,8};
        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        System.out.println("最大值"+max);
        System.out.println("和"+sum);
    }
}
