package leetcode.medium;

import java.util.*;

/**
 * @Author yanwg
 * @Date 2021/5/31 11:03
 * @Description:
 */
public class A {
    public static void main(String[] args) {
    Set<List<Integer>> set = new TreeSet<List<Integer>>(new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
//            return (o1.size()==o2.size()&&o1.containsAll(o2))?0:1;
            Collections.sort(o1);
            Collections.sort(o2);
            if(o1.equals(o2)){
                return 0;
            }else {
                if(o1.isEmpty()){
                    return 1;
                }
                if(o2.isEmpty()){
                    return -1;
                }
                int i =0 ;
                while (o1.get(i).equals(o2)){
                    i++;
                }
                if(o1.get(i)>o2.get(i)){
                    return 1;
                }else {
                    return -1;
                }
            }
        }
    });
    List<List<Integer>> list1 = new ArrayList<List<Integer>>();
    list1.add(Arrays.asList(new Integer[]{2,-2,0}));
    list1.add(Arrays.asList(new Integer[]{0,2,-2}));
    list1.add(Arrays.asList(new Integer[]{-4, 0, 4}));
    list1.add(Arrays.asList(new Integer[]{-1, -2, 3}));
    list1.add(Arrays.asList(new Integer[]{1, -4, 3}));
    list1.add(Arrays.asList(new Integer[]{1, -1, 0}));
    list1.add(Arrays.asList(new Integer[]{1, 2, -3}));
    list1.add(Arrays.asList(new Integer[]{0, -3, 3}));
    list1.add(Arrays.asList(new Integer[]{0, -4, 4}));
    list1.add(Arrays.asList(new Integer[]{0, 2, -2}));
    list1.add(Arrays.asList(new Integer[]{0, 1, -1}));
    list1.add(Arrays.asList(new Integer[]{-1, -3, 4}));
    list1.add(Arrays.asList(new Integer[]{-1, -2, 3}));
    list1.add(Arrays.asList(new Integer[]{-1, 2, -1}));
    list1.add(Arrays.asList(new Integer[]{-1, 0, 1}));

    set.addAll(list1);
    Iterator iterator = set.iterator();
    while (iterator.hasNext()){
        System.out.println(iterator.next());

    }
    System.out.println(set.size());
    System.out.println(Arrays.asList(new Integer[]{2,-2,0}).containsAll(Arrays.asList(new Integer[]{0,2,-2})));
}
}
