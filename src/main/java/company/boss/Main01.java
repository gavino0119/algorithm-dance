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
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = (start+end)>>>1;
            if(arr[mid]==n){
                return mid;
            }else if(arr[mid]<n){
                start = mid+1;
            }else if(arr[mid]>n){
                end = mid-1;
            }
        }
        return -1;
    }
}


