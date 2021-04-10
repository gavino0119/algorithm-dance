package company.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author yanwg
 * @Date 2021/4/10 12:16
 * @Description: 某比赛已经进入了淘汰赛阶段, 已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,
 * 小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。
 * 但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。
 * 显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线
 * https://www.nowcoder.com/test/question/done?tid=43370127&qid=1371127
 */
public class LowestScore {
    private int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int left = scanner.nextInt();
        int right = scanner.nextInt();
        int[] core = new int[count];
        for (int i = 0; i < count; i++) {
            core[i] = scanner.nextInt();
        }
        Arrays.sort(core);
        for (int i = 0; i < count; i++) {
            int curRight = count - i - 1;
            int curLeft = count - curRight;
            if ((left <= curRight && curRight <= right) && (left <= curLeft && curLeft <= right)) {
                System.out.println(core[i]);
                return;
            }
        }
        System.out.println(-1);

    }
}

