package top;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yanwg
 * @Date 2021/11/12 14:36
 * @Description: 复原IP地址（回溯）
 */
public class RestoreIpAddresses {
    List<String> result = new ArrayList<>();

    static final int SEG_COUNT = 4;
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
/*        search(s, 1, "");
        return result;*/

        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return result;
    }

    /**
     * @param s      字符串
     * @param n      段数 ip为4段
     * @param ipAddr
     */
    private void search(String s, int n, String ipAddr) {
        if (n == 5 && s.length() == 0) {
            result.add(ipAddr.substring(0, ipAddr.length() - 1));
            return;
        }
        if (n >= 5) {
            return;
        }
        // 剩余几段
        int remain = 5 - n;
        // 判断剩余字符长度是否符合要求
        if (s.length() < remain || s.length() > remain * 3) {
            return;
        }
        // 每一段都可以裁三次
        for (int i = 1; i <= 3; i++) {
            if (s.length() < i) {
                return;
            }
            String part = s.substring(0, i);
            int num = Integer.valueOf(part);
            // 01 得 1 的情况
            if (part.length() != String.valueOf(num).length()) {
                return;
            }
            if (num > 255) {
                return;
            }
            search(s.substring(i), n + 1, ipAddr + part + ".");
        }
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                result.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses addresses = new RestoreIpAddresses();
        System.out.println(addresses.restoreIpAddresses("25335669"));
    }
}
