package leetcode.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author yanwg
 * @Date 2021/6/1 9:39
 * @Description: 一个数组中都是乱序的正整数，  要求进行数据整理
 * 1.奇数在前，偶数在后
 * 2.奇数与奇数，偶数和偶数的相对顺序不能乱
 */
public class B {
    public static void main(String[] args) {
        int[] arr = new int[]{6,1,4,8,3,5,12,7,16,0,2};

//        int[] a = a(arr);
        int[] b = b(arr);
//        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));


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

    /**
     * 双指针
     * @param arr
     * @return
     */
    private static int[] b(int[] arr){
        int left = 0,right = arr.length-1;
        while (left<right){
            if ((arr[left]&1)==0 && (arr[right]&1)==1) {
                int tmp = arr[left];
                arr[left] = tmp;
                tmp = arr[right];
            }
            if ((arr[left]&1)==1) {
                left++;
            }
            if ((arr[right]&1)==0) {
                right--;
            }
        }
        return arr;
    }
}
