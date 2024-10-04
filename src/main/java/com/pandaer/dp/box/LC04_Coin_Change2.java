package com.pandaer.dp.box;

/**
 * 零钱兑换 II
 * https://leetcode.cn/problems/coin-change-ii/description/
 */
public class LC04_Coin_Change2 {

    /**
     * 回溯的解法
     * 状态 dp[i][j] 表示在第i个阶段，达到金额j的方案数
     * 状态转移方程 dp[i][j] = dp[i-1][j] + (dp[i-1][j - coins[i]] + 1) + (dp[i-1][j - x*coin[i]] + x)
     * @param coins
     * @param amount
     * @return
     */
    public int change(int amount, int[] coins) {
        // 定义状态
        int[][] dp = new int[coins.length][amount + 1];

        // 初始化 DONE

        // 设置首项
        for (int i = 0; i<=amount;i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        // 填表
        for (int i = 1; i<coins.length;i++) {
            for (int j = 0; j<=amount;j++) {
                int counts = j / coins[i];
                for (int count = 0; count <= counts; count++) {
                    if (dp[i-1][j - (count * coins[i])] != 0) {
                        dp[i][j] += dp[i-1][j - (count * coins[i])];
                    }
                }
            }
        }

        // 返回结果
        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        System.out.println(new LC04_Coin_Change2().change(5,new int[]{1,2,5}));
    }
}
