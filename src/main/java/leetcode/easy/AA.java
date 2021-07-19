package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author yanwg
 * @Date 2021/6/11 14:59
 * @Description:
 */
public class AA {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "[参数名称:groupDesc--参数值:]\n" +
                "\n" +
                "[参数名称:enableOverflowToCustom--参数值:1]\n" +
                "\n" +
                "[参数名称:matchType--参数值:2]\n" +
                "\n" +
                "[参数名称:numbers--参数值:null]\n" +
                "\n" +
                "[参数名称:areas--参数值:[[\"北京/北京|010\",\"河北/保定|0312\"]]]\n" +
                "\n" +
                "[参数名称:updateTime--参数值:null]\n" +
                "\n" +
                "[参数名称:idList--参数值:null]\n" +
                "\n" +
                "[参数名称:numberPools--参数值:null]\n" +
                "\n" +
                "[参数名称:sort--参数值:null]\n" +
                "\n" +
                "[参数名称:rows--参数值:0]\n" +
                "\n" +
                "[参数名称:number--参数值:null]\n" +
                "\n" +
                "[参数名称:groupName--参数值:阿娇测试]\n" +
                "\n" +
                "[参数名称:numberChoiceType--参数值:1]\n" +
                "\n" +
                "[参数名称:enableOverflow--参数值:1]\n" +
                "\n" +
                "[参数名称:groupWithNotIn--参数值:null]\n" +
                "\n" +
                "[参数名称:startTime--参数值:null]\n" +
                "\n" +
                "[参数名称:endTime--参数值:null]\n" +
                "\n" +
                "[参数名称:enterpriseId--参数值:20200910]\n" +
                "\n" +
                "[参数名称:id--参数值:null]\n" +
                "\n" +
                "[参数名称:numberList--参数值:[\"0298765433\",\"010882\"]]\n" +
                "\n" +
                "[参数名称:page--参数值:0]\n" +
                "\n" +
                "[参数名称:order--参数值:null]\n" +
                "\n" +
                "[参数名称:poolName--参数值:null]\n" +
                "\n";
        String[] logList = s.split("\\]");
        for(String s1 : logList){
            if (s1.contains("numberList")) {
                String s2 = s1.split(":")[2];
                String sd = s2.substring(1);
                System.out.println(sd);
            }
        }
    }

}
