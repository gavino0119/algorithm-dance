package other;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/8/25 13:17
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,90,7,6,9,2,0,3,5454,34,1,2,8,3,0,8,6,14,26};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void sort(int[] arr,int start,int end){

        if(start<end){
            int flag = arr[start];
            int l = start;
            int r = end;
            while (l<r){
                while (l<r && arr[r]>=flag){
                    r--;
                }
                arr[l] = arr[r];
                while (l<r && arr[l]<=flag){
                    l++;
                }
                arr[r] = arr[l];
            }
            arr[l] = flag;
            sort(arr,start,l);
            sort(arr,l+1,end);

        }

    }
}
