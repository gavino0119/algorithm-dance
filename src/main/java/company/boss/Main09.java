package company.boss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ywg
 * @version 1.0
 * @description   【找出两个数组中不一样的元素】
 * @date 2020/4/21 16:53
 */
public class Main09 {
    public static void main(String[] args) {
        int[] a1 = new int[]{1,5,2,6,10,9,3};
        int[] a2 = new int[]{1,2,5,9,6,3};
//        System.out.println(getRes(a1,a2));

        List<Integer> l = getRes1(new Integer[]{1, 2,5 ,9,6,3}, new Integer[]{1, 2, 3, 5,11,4});
        l.forEach(a-> System.out.println(a));

    }

    //我的
    public static List<Integer> getRes(int[] a1,int[] a2){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(a1);
        Arrays.sort(a2);

        int p1 = 0;
        int p2 = 0;
        while (p1< a1.length && p2<a2.length){
            if (a1[p1++]!=a2[p2++]){
                if (a1[p1] == a2[p2+1]){
                    list.add(a1[p1]);
                }else {
                    list.add(a2[p2]);
                }
            }
        }
        return list;
    }
    //网上
    public static <T> List<T> getRes1(T[] t1, T[] t2) {
        List<T> list1 = Arrays.asList(t1);
        List<T> list2 = new ArrayList<T>();
        for (T t : t2) {
            if (!list1.contains(t)) {
                list2.add(t);
            }
        }
        return list2;
    }

}
