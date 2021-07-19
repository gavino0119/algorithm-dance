package javademo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author yanwg
 * @Date 2021/6/21 11:18
 * @Description:
 */

public class HelloController {
    private static SimpleDateFormat SDF_YMD = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws ParseException {
        String now =String.valueOf(System.currentTimeMillis());
        Date parse = SDF_YMD.parse(now);
        System.out.println(now);
        System.out.println(parse);
    }
}
