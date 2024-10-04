package com.pandaer.dp;

public class Code02_Solve_Knapsack2 {

    /**
     * 思路：定义状态 填表
     * @param w
     * @param n
     * @param weights
     * @return
     */
    public int solveKnapsack(int w, int n, int[] weights) {
        boolean[][] status = new boolean[n][w + 1];

        // 设置初始状态
        status[0][0] = true;
        if (weights[0] <= w) {
            status[0][weights[0]] = true;
        }

        // 基于初始状态进行状态转移
        for (int i = 1; i< n;i++) {
            for (int j = 0; j < w + 1; j++) {
                if (status[i-1][j]) {
                    status[i][j] = true;
                    if (j + weights[i] <= w) {
                        status[i][j + weights[i]] = true;
                    }
                }
            }
        }

        for (int i = w; i>=0; i--) {
            if (status[n-1][i]) return i;
        }
        return 0;
    }
}
