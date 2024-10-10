package com.pandaer.dp.box;

public class Code01_Solve_Knapsack {

    /**
     * 定义状态 dp[i][j] :表示在第i个物品决策之后，当前背包的重量为j这个状态是否可达
     * 状态转移方程 dp[i][j] = dp[i-1][j] || dp[i-1][j-weights[i]]
     *
     * @param w
     * @param n
     * @param weights
     * @return
     */
    public boolean solveKnapsack(int w, int n, int[] weights) {
        // 定义状态
        boolean[][] dp = new boolean[n][w + 1];

        // 初始化 DONE 因为boolean值默认就是false，自动完成

        // 设置初项
        dp[0][0] = true;
        if (weights[0] <= w) {
            dp[0][weights[0]] = true;
        }

        // 填表 根据状态转移方程
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weights[i] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - weights[i]];
                }
            }
        }

        // 返回结果
        return dp[n - 1][w];
    }
}
