package leetcode.competition._237;

import java.util.HashSet;

/**
 * @author ywg
 * @version 1.0
 * @description
 * @date 2021/4/18 10:30
 */
public class Main01 {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (charSet.size() == 26) {
                return true;
            }
            charSet.add(sentence.charAt(i));
        }
        return charSet.size()==26;
    }
}
