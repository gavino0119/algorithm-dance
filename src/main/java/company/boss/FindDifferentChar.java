package company.boss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2021/9/8 0:00
 */
public class FindDifferentChar {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<> ();
        char[] a1 = new char[]{'a','b','f','c','e'};
        char[] a2 = new char[]{'a','b','c','e'};
        
        int first = 0;
        int second = 0;
        int len = a2.length;
        
        while(second<len){
            if (a1[first]==a2[second]) {
                first++;
                second++;
            }else {
                list.add(a1[first]);
                first++;
            }
        }
        while (first < a1.length) {
            list.add(a1[first++]);
        }

        System.out.println(list);
    }
}
