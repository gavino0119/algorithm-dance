package sort;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/7/20 9:37
 * @Description: 快速排序
 */
public class QuickSort {
    private static void quickSort1(int[] arr, int start, int end){
        int flag = arr[start];
        int l = start;
        int r = end;
        if (start<end){
            while (l<r){
                while (l<r && flag<=arr[r]){
                    r--;
                }
                arr[l] = arr[r];
                while (l<r && flag>=arr[l]){
                    l++;
                }
                arr[r] = arr[l];
//                swap(arr[l],arr[r]);
            }
            arr[l] = flag;
            quickSort1(arr,start,l);
            quickSort1(arr,l+1,end);

        }
    }
    private static void swap(int a,int b){
        int tmp = a;
        a = b;
        b = tmp;
    }
    private static void testSort(int[] arr){
        quickSort1(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,90,7,6,9,2,0,3,5454,34,1,2,8,3,0,8,6,14,26};
        System.out.println(Arrays.toString(arr));
        testSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
