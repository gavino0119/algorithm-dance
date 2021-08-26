package other;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/8/24 12:27
 * @Description: 求top K
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 6, 3, 18, 4, 98, 1, 8, 0, 24, 6, 28, 2, 33, 5,66,456,33,234,4564,7,123,86,9,66,443,234,86,34};
        System.out.println(Arrays.toString(arr));
        System.out.println(sortKnumByHeap(arr,10));

        int[] arr1 = new int[]{12, 6, 3, 18, 4, 98, 1, 8, 0, 24, 6, 28, 2, 33, 5,66,456,33,234,4564,7,123,86,9,66,443,234,86,34};
        System.out.println(sortKnumByQuick(arr1,10));
    }

    private static int sortKnumByQuick(int[] arr,int k){
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-k];
    }
    private static void quickSort(int[] arr, int start, int end){
        int flag = arr[start];
        int left = start;
        int right = end;
        if (start<end){
            while (left<right){
                while (left<right && arr[right]>=flag){
                    right--;
                }
                arr[left] = arr[right];
                while (left<right && arr[left]<=flag){
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = flag;
            quickSort(arr,start,left);
            quickSort(arr,left+1,end);
        }
    }
    private static int sortKnumByHeap(int[] arr,int k){
        int start = (arr.length-1)>>1;
        for(int index=start;index>=0;index--){
            maxHeap(arr,index,arr.length);
        }
        for(int i=arr.length-1;i>arr.length-k;i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeap(arr,0,i);
        }
        return arr[0];
    }
    private static void maxHeap(int[] arr,int index,int heapSize){
        int left = 2*index+1;
        int right = 2*index+2;

        int max = index;
        if(left<heapSize && arr[left]>arr[max]){
            max = left;
        }
        if(right<heapSize && arr[right]>arr[max]){
            max = right;
        }
        if(max!=index){
            int tmp = arr[max];
            arr[max] = arr[index];
            arr[index] = tmp;
            maxHeap(arr,max,heapSize);
        }
    }
}
