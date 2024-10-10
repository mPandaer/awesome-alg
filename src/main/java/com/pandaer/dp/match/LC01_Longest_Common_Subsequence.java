package com.pandaer.dp.match;

/**
 * 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/description/
 */
public class LC01_Longest_Common_Subsequence {

    /**
     * 动态规划 匹配模型
     * 定义状态：dp[i][j] 表示当s1的长度为i,s2的长度为j时的最长公共子串
     * 状态转移方程：
     * 当 s1[i-1] == s2[j-1],即当s1的长度为i,s2的长度为j时，且两个字符串的最后一个字符相等，那么最长公共子串：dp[i][j] = dp[i-1][j-1] + 1;
     * 当 s1[i-1] != s2[j-1],最长公共子串 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // 定义状态
        int row = text1.length();
        int col = text2.length();
        int[][] dp = new int[row + 1][col + 1];
        // 初始化 DONE

        // 设置初项 DONE

        // 填表
        for (int i = 1; i <= row; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= col; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 返回结果
        return dp[row][col];
    }
}
