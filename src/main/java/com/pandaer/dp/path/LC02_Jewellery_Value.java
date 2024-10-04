package com.pandaer.dp.path;

/**
 * 珠宝的最高价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class LC02_Jewellery_Value {

    /**
     * 动态规划 最短路径模型
     * 状态 dp[i][j] 表示到达(i,j)位置时，这个位置上的最大珠宝价值
     * 状态转移方程 dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + frame[i][j]
     * @param frame
     * @return
     */
    public int jewelleryValue(int[][] frame) {
        int row = frame.length;
        int col = frame[0].length;

        // 定义状态
        int[][] dp = new int[row][col];

        // 初始化 DONE

        // 设置首项
        dp[0][0] = frame[0][0];

        // 填表
        for (int i = 0; i< row;i++) {
            for (int j = 0; j< col;j++) {
                if (i== 0 && j == 0) continue;
                if (i == 0) {
                    dp[i][j] = dp[i][j-1] + frame[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + frame[i][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + frame[i][j];
                }

            }
        }

        // 返回结果
        return dp[row-1][col-1];
    }
}
