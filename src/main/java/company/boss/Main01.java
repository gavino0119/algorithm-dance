package company.boss;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/8/23 9:48
 * @Description:
 */
public class Main01 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,6,2,3,8,6,9};
        System.out.println(binarySearch(arr,1));
        System.out.println(binarySearch(arr,3));
    }

    private static int binarySearch(int[] arr, int n){
        Arrays.sort(arr);
        int len = arr.length;
        int l = 0;
        int r = len-1;
        int mid = (l+r)>>1;
        return -1;
    }
}


