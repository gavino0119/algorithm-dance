package company.boss;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ywg
 * @version 1.0
 * @description  【手写二分查找】
 * @date 2020/4/16 7:06
 */
public class Main02 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 6, 9, 15, 65, 78, 100};
        System.out.println(binarySearch(arr,3));
        System.out.println(binarySearch(arr,5));
    }

    public static int binarySearch(int[] srcArray, int des) {
        //定义初始最小、最大索引
        int start = 0;
        int end = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (start <= end) {
            //计算出中间索引值
            int middle = (end + start)>>>1 ;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                end = middle - 1;
                //判断上限
            } else {
                start = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }
}
