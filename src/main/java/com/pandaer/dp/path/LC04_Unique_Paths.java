package com.pandaer.dp.path;

/**
 * 不同路径
 * https://leetcode.cn/problems/unique-paths/description/
 */
public class LC04_Unique_Paths {

    /**
     * 动态规划 路径模型
     * dp[i][j] 表示到达点(i,j)的走法
     * 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // 定义状态
        int[][] dp = new int[m][n];

        // 初始化 DONE

        // 设置首项
        dp[0][0] = 1;


        // 填表
        for (int i = 0; i<m;i++) {
            for (int j = 0; j<n;j++) {
                if (i == 0 && j==0) continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        // 返回结果
        return dp[m-1][n-1];

    }
}
