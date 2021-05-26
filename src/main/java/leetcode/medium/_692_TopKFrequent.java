package leetcode.medium;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yanwg
 * @Date 2021/5/20 10:17
 * @Description:
 */
public class _692_TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> resList = new ArrayList();
        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.putIfAbsent(word,1);
        }

        // 排序
        return resList;
    }

    public static void main(String[] args) {
        String time = "2019-05-15 15:44:57";
        String time1 = "2019-05-15";

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime parse = LocalDateTime.parse(time,df);
        LocalDate parse1 = LocalDate.parse(time1,df1);

        System.out.println(time);
        System.out.println(parse);
        System.out.println(parse1);
    }
}
