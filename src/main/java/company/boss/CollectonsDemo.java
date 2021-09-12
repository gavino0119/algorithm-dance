package company.boss;

import java.util.*;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2021/9/12 21:06
 */
public class CollectonsDemo {

    public static void main(String[] args) {
        final Map<String,Integer> map = new HashMap<>();
        map.put("1",1);//不报错  可修改值
//        map = new HashMap<>();// 报错，不能修改引用


        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }


        // lambda 修改外部变量
        final int a = 1;
        int b =2;
        //将变量定义为数组就好了
        int[] c = new int[]{3};
        final int[] d = new int[]{3};
        List<Integer> list = new ArrayList<>();
        list.forEach(l->{
                l = 1;
//                b=3; 报错
//                a=2; 报错
                c[0] = 1;
                d[0] = 1;
        });
    }
}
