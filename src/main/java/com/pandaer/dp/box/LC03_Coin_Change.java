package com.pandaer.dp.box;

/**
 * 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 */
public class LC03_Coin_Change {

    /**
     * 回溯的解法
     * 状态 dp[i][j] 表示在第i个阶段，达到金额j的需要花费的最小硬币数
     * 状态转移方程 dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j - coins[i]] + 1,dp[i-1][j - x*coin[i]] + x)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 定义状态
        int[][] dp = new int[coins.length][amount + 1];

        // 初始化
        for (int i = 0; i<coins.length;i++) {
            for (int j = 0; j<=amount;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 设置首项
        for (int i = 0; i<=amount;i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            }
        }

        // 填表
        for (int i = 1; i<coins.length;i++) {
            for (int j = 0; j<=amount;j++) {
                int counts = j / coins[i];
                for (int count = 0; count <= counts; count++) {
                    if (dp[i-1][j - (count * coins[i])] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j - (count * coins[i])] + count);
                    }
                }
            }
        }

        // 返回结果
        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount] ;
    }

    public static void main(String[] args) {
        System.out.println(new LC03_Coin_Change().coinChange(new int[]{2,5,10,1}, 27));
    }
}
