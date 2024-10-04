package com.pandaer.dp.rob;


/**
 * 打家劫舍
 * https://leetcode.cn/problems/house-robber/description/
 */
public class LC02_Rob2 {

    /**
     * 动态规划 打家劫舍模型
     * 状态 dp[i] 表示在完成第i家之后，当前的最大总金额
     * 状态转移方程 dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1])
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        // 返回结果
        return Math.max(doRob(nums,0,nums.length-2),doRob(nums,1,nums.length-1));
    }

    private int doRob(int[] nums, int start, int end) {
        // 定义状态
        int[] dp = new int[end - start + 1];
        // 初始化 DONE

        // 设置初项
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start + 1]);

        // 填表
        for (int i = start + 2; i<=end;i++) {
            dp[i - start] = Math.max(dp[i-start-2] + nums[i],dp[i-start-1]);
        }

        // 返回结果
        return dp[dp.length-1];
    }
}
