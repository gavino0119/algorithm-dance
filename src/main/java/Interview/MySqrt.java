package Interview;

/**
 * @author ywg
 * @version 1.0
 * @description LeetCode 69 x 的平方根
 * 精确到小数点xxx位
 * @date 2022/5/22 18:38
 */
public class MySqrt {
    private static double mySqrt(int x, int n) {
        double e = 1.0;
        while (n > 0) {
            e /= 10.0;
            n--;
        }

        System.out.println(e);
        double res = getMySqrt(x, e);
        return res;
    }

    private static double getMySqrt(int x, double e) {
        double left = 1;
        double right = x;
        double res = 0.0;

        if (x < 1) {
            left = x;
            right = 1;
        }

        while (left <= right) {
            double mid = left + (right - left) / 2.0;

            if (Math.abs(mid * mid - x) <= e) {
                return mid;
            } else if (mid * mid < x) {
                left = mid;
            } else if (mid * mid > x) {
                right = mid;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8, 10));

        double sqrt = Math.sqrt(8);
        System.out.println(sqrt);
    }
}
