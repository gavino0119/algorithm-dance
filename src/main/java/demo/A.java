package demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author yanwg
 * @Date 2021/8/31 14:49
 * @Description:
 */
public class A {
    public Date endTimeD;

    public static void main(String[] args) {
        A info = new A();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for(int i=0;i<1000;i++){
            info.endTimeD = Calendar.getInstance().getTime();
            System.out.println(new Date());
//            if(null != info.endTimeD){
//
//                String format = sdf.format(info.endTimeD);
//                System.out.println(format);
//            }
        }
    }
}
