package com.pandaer.dp.box;

import java.util.Arrays;

/**
 * 分割等和子集
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class LC01_Can_Partition {


    /**
     * 动态规划的解法
     * 状态：status[i][j] 表示第i个阶段，一个子集的和的可达状态 0表示不可达，1表示可达
     * 状态转移方程 status[i][j] = status[i-1][j] ||  status[i-1][j-nums[i]]
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        // 定义状态
        int sum = Arrays.stream(nums).sum();
        if ((sum / 2) * 2 != sum) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length][sum + 1];
        // 初始化 DONE

        // 设置首项
        dp[0][0] = true;
        dp[0][nums[0]] = true;

        // 填表
        for (int i = 1; i< nums.length;i++) {
            for (int j = 0; j<=sum;j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                }
                if (j - nums[i] >= 0 && dp[i-1][j - nums[i]]) {
                    dp[i][j] = true;
                }
            }
        }

        // 返回结果
        return dp[nums.length - 1][sum / 2];
    }
}
