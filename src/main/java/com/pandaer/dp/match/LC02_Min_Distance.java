package com.pandaer.dp.match;

/**
 * 编辑距离
 * https://leetcode.cn/problems/edit-distance/description/
 */
public class LC02_Min_Distance {

    /**
     * 匹配模型 动态规划  错误解法，题解看不懂！！！
     * 定义状态: dp[i][j]表示 当s1的长度为i,s2的长度为j时，最小操作数
     * 状态转移方程：
     * 当 s1[i-1] == s2[j-1] dp[i][j] = dp[i-1][j-1]
     * 当 s1[i-1] != s2[j-1] dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + 1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {

        // 定义状态
        int row = word1.length();
        int col = word2.length();
        int[][] dp = new int[row+ 1][col + 1];

        // 初始化
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 设置初项
        for (int j = 0; j<=col;j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i<=row; i++) {
            dp[i][0] = i;
        }

        // 填表

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                int curMin = Integer.MAX_VALUE;
                if (dp[i-1][j] != Integer.MAX_VALUE) {
                    curMin = Math.min(curMin, dp[i-1][j]);
                }
                if (dp[i][j-1] != Integer.MAX_VALUE) {
                    curMin = Math.min(curMin, dp[i][j-1]);
                }
                dp[i][j] = curMin + 1;
            }
        }

        // 返回结构
        return dp[row][col];
    }
}
