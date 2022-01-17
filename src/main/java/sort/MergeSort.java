package sort;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/7/21 8:54
 * @Description: 归并排序
 */
public class MergeSort {
    private static void mergeSort(int[] arr, int start, int end){
        int mid = (start+end)>>1;
        if(start<end){
            // 处理左边
            mergeSort(arr,start,mid);
            // 处理右边
            mergeSort(arr,mid+1,end);
            // 归并
            merge(arr,start,mid,end);
        }
    }
    /**
     * 合并的方法
     * @param arr
     * @param start 起始位置
     * @param mid 分割位置--两个数组 [start--mid][mid+1--end]
     * @param end 结束位置
     */
    private static void merge(int[] arr, int start, int mid, int end){
        // 用于存储归并后的临时数组
        int[] tmp = new int[end-start+1];
        // 记录第一个数组中需要遍历的下标
        int i = start;
        // 记录第二个数组中需要遍历的下标
        int j = mid+1;
        // 临时数组下标
        int index = 0;
        // 遍历两个数组，取出小的数放入临时数组中
        while (i<=mid && j<=end){
            if (arr[i]<=arr[j]) {
                tmp[index++] = arr[i];
                i++;
            } else {
                tmp[index++] = arr[j];
                j++;
            }
        }
        // 处理多余的数据
        while (i<=mid){
            tmp[index++] = arr[i];
            i++;
        }
        while (j<=end){
            tmp[index++] = arr[j];
            j++;
        }
        // 将临时数组中的数存回原数组
        for (int k=0;k<tmp.length;k++){
            arr[k+start] = tmp[k];
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,6,2,1,8,0};
        System.out.println(Arrays.toString(arr));
//        merge(arr,0,3,arr.length-1);
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
