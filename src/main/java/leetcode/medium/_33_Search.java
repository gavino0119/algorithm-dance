package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yanwg
 * @Date 2021/10/8 9:36
 * @Description:
 * 4,5,6,7,0,1,2
 */
public class _33_Search {

    public static void main(String[] args) {
        A1 a = new B1();
        System.out.println(a.a);
        a.m();
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
class A1{
    int a = 0;
    public void m(){
        System.out.println("---A---");
    }
}

class B1 extends A1{
    int a = 1;
    @Override
    public void m(){
        System.out.println("---B---");
    }
}