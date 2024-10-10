package com.pandaer.dp.stair;

import java.util.Arrays;

/**
 * 零钱兑换 II
 * https://leetcode.cn/problems/coin-change-ii/description/
 */
public class LC03_Coin_Change2 {


    /**
     * 有问题的状态定义，存在问题！！！！
     * 动态规划 爬楼梯模型
     * 定义状态：dp[i]：当金额为i时，硬币的组合数
     * 状态转移方程：dp[i] = dp[i-coins[0]] +  dp[i-coins[1]] + dp[i-coins[j]]
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        // 定义状态
        int[] dp = new int[amount + 1];
        // 初始化 DONE

        // 设置首项
        dp[0] = 1;

        // 填表
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j< coins.length;j++) {
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        System.out.println(Arrays.toString(dp));

        // 返回结果
        return dp[amount];
    }

    public static void main(String[] args) {
        LC03_Coin_Change2 obj = new LC03_Coin_Change2();
        System.out.println(obj.change(5, new int[]{1, 2, 5}));
    }
}
