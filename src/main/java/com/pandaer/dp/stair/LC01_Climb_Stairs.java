package com.pandaer.dp.stair;

/**
 * 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/description/
 */
public class LC01_Climb_Stairs {

    /**
     * 动态规划解法 爬楼梯模型
     * 定义状态：dp[i] 表示在第i阶楼梯时的到达数
     * 状态转移方程 dp[i] = dp[i-1] + dp[i-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;
        // 定义状态
        int[] dp = new int[n + 1];

        // 初始化 DONE

        // 设置初项
        dp[1] = 1;
        dp[2] = 2;

        // 填表
        for (int i = 3; i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        // 返回结果
        return dp[n];
    }


}
