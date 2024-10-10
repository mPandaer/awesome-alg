package com.pandaer.dp.match;

import java.util.Arrays;

/**
 * 最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 */
public class LC03_LengthOfLIS {

    /**
     * 动态规划
     * 定义状态：dp[i] 表示使用i个数，得到的最长递增子序列的长度
     * 状态转移方程： dp[i] = Math.max(dp[j]) + 1
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // 定义状态
        int[] dp = new int[nums.length];

        // 初始化 DONE

        // 设置首项
        dp[0] = 1;

        // 填表
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 返回结果
        int max = 0;
        for (int i = 0; i<nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LC03_LengthOfLIS obj = new LC03_LengthOfLIS();
        System.out.println(obj.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
