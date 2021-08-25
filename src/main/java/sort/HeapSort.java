package sort;

import java.util.Arrays;

/**
 * @Author yanwg
 * @Date 2021/7/22 13:03
 * @Description: 堆排
 */
public class HeapSort {
    /**
     * 堆排序 大顶堆升序排列 *
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //开始位置是最后一个非叶子节点，即最后两个节点的父节点
        int start = (arr.length - 1) >> 1;// (arr.length-2)/2也行
        // 调整为大顶堆
        for (int i = start; i >= 0; i--) {
            maxHeap(arr, arr.length, i);// 不能是arr.length-1
        }
        //先把数组中的第0个和堆中的最后一个数交换位置，再把前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }

    /**
     * 求大顶堆
     *
     * @param arr
     * @param size
     * @param index 数组下标，用来找非叶子节点 (父节点)
     */
    public static void maxHeap(int[] arr, int size, int index) {
        //左子节点
        int leftNode = 2 * index + 1;
        //右子节点
        int rightNode = 2 * index + 2;
        int max = index;
        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        //交换位置
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //交换位置以后，可能会破坏之前排好的堆，所以，之前排好的堆需要重排
            maxHeap(arr, size, max);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 6, 3, 18, 4, 98, 1, 8, 0, 24, 6, 28, 2, 33, 5};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
