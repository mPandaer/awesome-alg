package com.pandaer.dp.profit;

/**
 * 买卖股票的最佳时机含手续费
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 */
public class LC01_Max_Profit {

    /**
     * 动态规划 买卖股票
     * 状态 dp[i][0] 表示第i天后，手上没有股票的最大收益，dp[i][1]表示第i天后，手上有股票的最大收益
     * 状态转移方程
     *  dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee)
     *  dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i])
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        // 定义状态
        int[][] dp = new int[prices.length][2];

        // 初始化 DONE

        // 设置初项
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 填表
        for (int i = 1; i< prices.length;i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }

        // 返回结果
        return dp[prices.length-1][0];
    }
}
