package dp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author yanwg
 * @Date 2021/6/22 11:38
 * @Description:
 */
public class A {
    private static SimpleDateFormat SDF_YMD = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        String timeStr =String.valueOf(System.currentTimeMillis());
        String format = SDF_YMD.format(Long.parseLong(timeStr));
        System.out.println(timeStr);
        System.out.println(format);
    }
}
