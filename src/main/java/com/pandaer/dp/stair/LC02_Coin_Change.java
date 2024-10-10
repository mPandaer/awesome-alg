package com.pandaer.dp.stair;

import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode.cn/problems/coin-change/description/
 */
public class LC02_Coin_Change {

    /**
     * 动态规划 爬楼梯模型
     * 定义状态：dp[i] 表示当金额为i时，需要的最小的硬币数
     * 状态转移方程：dp[i] = Math.min(dp[i-coins[1]],dp[i-coins[2]],dp[i-coins[j]]) + 1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 定义状态
        int[] dp = new int[amount + 1];

        // 初始化
        for (int i = 0; i<= amount;i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 设置首项
        dp[0] = 0;

        // 填表
        for (int i = 1; i <= amount;i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 0; j<coins.length;j++) {
               if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                   minCount = Math.min(minCount, dp[i - coins[j]]);
               }
            }
            if (minCount != Integer.MAX_VALUE) {
                dp[i] = minCount + 1;
            }

        }

//        System.out.println(Arrays.toString(dp));
        // 返回结果
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new LC02_Coin_Change().coinChange(new int[]{2}, 3));
    }
}
