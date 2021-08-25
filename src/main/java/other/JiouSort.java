package other;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/8/16 9:24
 * @Description: 一个数组中都是乱序的正整数，  要求进行数据整理
 * 1.奇数在前，偶数在后
 * 2.奇数与奇数，偶数和偶数的相对顺序不能乱
 */
public class JiouSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,8,4,3,7,9,2,14,11,0};
        System.out.println(Arrays.toString(arr));
        jiOuSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 采用队列
     * @param arr
     * @return
     */
    private static int[] a(int[] arr){
        Deque<Integer> queue = new LinkedList<>();
        int len = arr.length;
        for(int i=0;i<len;i++) {
            // 偶数放队尾
            if((arr[i] & 1) == 0) {
                queue.addLast(arr[i]);
            }
            // 奇数放队头
            if((arr[len-i-1] & 1) == 1){
                queue.addFirst(arr[len-i-1]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.pollFirst();
        }
        return arr;
    }
    private static void jiOuSort(int[] arr){
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if((arr[i]&1)==0){
                queue.addLast(arr[i]);
            }
            if ((arr[arr.length-1-i]&1)==1) {
                queue.addFirst(arr[arr.length-1-i]);
            }
        }
        int i = 0;
        while (!queue.isEmpty()){
            arr[i] = queue.pollFirst();
            i++;
        }
    }
}
