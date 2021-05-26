package leetcode.competition._241;

/**
 * @Author yanwg
 * @Date 2021/5/16 10:26
 * @Description: 5760. 构成交替字符串需要的最小交换次数
 */
public class Main02 {
    public static int minSwaps(String s) {
        if (s == null || s.length()<2) {
            return 0;
        }
        int cnt = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        int c0 =0 ;
        int c1 =0 ;
        for (int i = 1; i < length ; i++) {
            if (chars[i]==chars[i-1]) {
                if (chars[i] == '0') {
                    c0++;
                } else {
                    c1++;
                }
            }
        }
        if (c0 == c1 && c0 == 0) {
            return 0;
        }
        int len = length - c0*2;
        if (c0==c1 && (len&1)==0){
            return c0;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "11000011";
        System.out.println(minSwaps(s));
    }
}
