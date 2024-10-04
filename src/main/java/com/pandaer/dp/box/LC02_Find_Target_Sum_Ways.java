package com.pandaer.dp.box;


import java.util.Arrays;

/**
 * 目标和
 * https://leetcode.cn/problems/target-sum/description/
 */
public class LC02_Find_Target_Sum_Ways {

    /**
     * 动态规划的解法
     * 状态 dp[i][j] 表示第i个阶段，表达式的和为j的个数
     * 状态转移方程 dp[i][j] = dp[i-1][j + nums[i]] + dp[i-1][j - nums[i]]
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum) {
            return 0;
        }
        if (target < -sum) {
            return 0;
        }
        // 定义状态 集体偏移sum个步长
        int[][] dp = new int[nums.length][sum + sum + 1];

        // 初始化 DONE

        // 设置首项
        dp[0][nums[0]*(-1) + sum] += 1;
        dp[0][nums[0] + sum] += 1;

        // 填表
        for (int i = 1; i< nums.length;i++) {
            for (int j = 0; j<=sum * 2;j++) {
                if (j + nums[i] <= sum*2 && dp[i - 1][j + nums[i]] != 0) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
                if (j - nums[i] >= 0 && dp[i-1][j - nums[i]] != 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }

        // 返回结果
        return dp[nums.length - 1][target + sum];
    }

    public static void main(String[] args) {
        System.out.println(new LC02_Find_Target_Sum_Ways().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
