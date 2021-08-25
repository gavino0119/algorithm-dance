package other;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/8/24 12:27
 * @Description:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 6, 3, 18, 4, 98, 1, 8, 0, 24, 6, 28, 2, 33, 5,66,456,33,234,4564,7,123,86,9,66,443,234,86,34};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[5-1]);
        System.out.println(arr[0]);
    }

    private static void sort(int[] arr){
        int index = (arr.length-1)>>1;
        for(int i=index;i>=0;i--){
            makeHeap(arr,arr.length,i);
        }

        for(int i=arr.length-1;i>arr.length-5;i--){
            int tem = arr[0];
            arr[0] = arr[i];
            arr[i] = tem;
            makeHeap(arr,i,0);
        }
    }

    private static void makeHeap(int[] arr, int size, int index){
        int left = 2*index+1;
        int right = 2*index+2;
        int min = index;

        if(left<size && arr[left]>arr[min]){
            min = left;
        }
        if(right<size && arr[right]>arr[min]){
            min = right;
        }
        if(index!=min){
            int tem = arr[min];
            arr[min] = arr[index];
            arr[index] = tem;
            makeHeap(arr,size,min);
        }
    }
}
