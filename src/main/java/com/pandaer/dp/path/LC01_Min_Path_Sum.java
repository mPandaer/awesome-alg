package com.pandaer.dp.path;

import java.util.Arrays;

/**
 * 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/description/
 */
public class LC01_Min_Path_Sum {

    /**
     * 动态规划的解法
     * 定义状态 dp[i][j] 表示走到(i,j)时的最小路径和
     * 状态转移方程 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // 定义状态
        int[][] dp = new int[row][col];

        // 初始化 DONE

        // 设置首项
        dp[0][0] = grid[0][0];

        // 填表
        for (int i = 0; i< row;i++) {
            for (int j = 0; j< col;j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                }
            }
        }

        // 返回结果
        return dp[row-1][col-1];
    }


}
