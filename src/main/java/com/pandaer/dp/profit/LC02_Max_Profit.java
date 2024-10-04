package com.pandaer.dp.profit;

/**
 * 买卖股票的最佳时机含冷冻期
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class LC02_Max_Profit {


    /**
     * 动态规划 股票购买
     * 定义状态 dp[i][0] 表示第i天后，持有持有股票的最大累计利润，
     *        dp[i][1] 表示第i天后，没有股票的而且处于冷静期最大累计利润
     *        dp[i][2] 表示第i天后，没有股票的而且不处于冷静期最大累计利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 定义状态
        int[][] dp = new int[prices.length][3];

        // 初始化 DONE

        // 设置初项
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        // 填表
        for (int i = 1; i< prices.length;i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);
        }

        // 返回结果
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
}
