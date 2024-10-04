package com.pandaer.dp;

import java.util.Arrays;

public class Code03_Solve_Knapsack3 {

    /**
     * 思路：定义状态 填表
     * @param w
     * @param n
     * @param weights
     * @return
     */
    public int solveKnapsack(int w, int n, int[] weights) {
        // 标识不同重量下的方案数
        int[] dp = new int[w + 1];
        //初始化
        dp[0] = 1;
        // 填表 状态转移方程 dp[i] = dp[i] + dp[i - weight]
        for (int weight : weights) {
            for (int j = w; j >= weight; j--) {
                dp[j] = dp[j] + dp[j - weight];
            }
        }

        // 返回最后的结构
        return dp[w];
    }

    public static void main(String[] args) {
        System.out.println(new Code03_Solve_Knapsack3().solveKnapsack(10, 6, new int[]{3, 1, 4, 2, 10, 7}));
    }
}
