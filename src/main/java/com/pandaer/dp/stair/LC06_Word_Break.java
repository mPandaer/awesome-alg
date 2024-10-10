package com.pandaer.dp.stair;

import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 * https://leetcode.cn/problems/word-break/description/
 */
public class LC06_Word_Break {


    /**
     * 动态规划 爬楼梯模型
     * 定义状态：dp[i]表示s长度为i时，是否匹配
     * 状态转移方程 dp[i] = dp[i-len(words)] && (s[words.len] is OK) || ...
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 定义状态
        boolean[] dp = new boolean[s.length() + 1];

        // 初始化 DONE

        // 设置初项
        dp[0] = true; // 初项的设置可以带具体的实例进去

        // 填表
        for (int i = 1; i<=s.length();i++) {
            for (String word : wordDict) {
                if (i - word.length() >=0 && dp[i- word.length()] && isOk(s,word,i)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        // 返回结果
        return dp[s.length()];


    }

    private boolean isOk(String s, String word, int sEnd) {
        int n = word.length();
        int i = sEnd-1;
        int j = n-1;
        for (int count = 0; count< n; count++) {
            if (word.charAt(j) != s.charAt(i)) {
                return false;
            }
            j--;
            i--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LC06_Word_Break().wordBreak("leetcode", List.of("leet", "code")));
    }
}
