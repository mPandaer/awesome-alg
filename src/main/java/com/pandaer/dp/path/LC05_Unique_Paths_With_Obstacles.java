package com.pandaer.dp.path;

/**
 * https://leetcode.cn/problems/unique-paths-ii/
 * 不同路径 II
 */
public class LC05_Unique_Paths_With_Obstacles {

    /**
     * 动态规划 路径模型
     * 状态 dp[i][j]表示达到点(i,j)的走法
     * 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        // 定义状态
        int[][] dp = new int[row][col];

        // 初始化 DONE

        // 设置首项
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }


        // 填表
        for (int i = 0; i< row;i++) {
            for (int j = 0; j<col;j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) continue;
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
        return dp[row-1][col-1];
    }
}
