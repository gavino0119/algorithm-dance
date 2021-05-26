package leetcode.medium;

/**
 * @Author yanwg
 * @Date 2021/5/21 9:11
 * @Description: 不相交的线
 * 最长公共子序列
 */
public class _1035_MaxUncrossedLines {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int res = 0;
        int[] numa = null;
        int[] numb = null;
        if(nums1.length==nums2.length){
            numa = nums1;
            numb = nums2;
        }else {
            numa = nums1.length<nums2.length ? nums1 : nums2;
            numb = nums1.length>nums2.length ? nums1 : nums2;
        }

        int index = 0;
        for (int i = 0; i < numa.length ; i++) {
            for (int j=index;j<numb.length;j++){
                if (numa[i] == numb[j]) {
                    index ++;
                    res++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2,5};
        int[] arr2 = {1, 2, 4,5};

        System.out.println(maxUncrossedLines(arr1,arr2));

    }
}
