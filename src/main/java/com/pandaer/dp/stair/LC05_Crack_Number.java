package com.pandaer.dp.stair;

import java.util.Arrays;

/**
 * 165. 解密数字
 * https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/description/
 */
public class LC05_Crack_Number {

    /**
     * 动态规划 爬楼梯模型
     * 定义状态：dp[i] 表示长度为i时的解密数
     * 状态转移方程：dp[i] = dp[i-1] + dp[i-2](有条件)
     * @param ciphertext
     * @return
     */
    public int crackNumber(int ciphertext) {
        // 定义状态
        char[] nums = String.valueOf(ciphertext).toCharArray();
        int[] dp = new int[nums.length + 1];

        // 初始化 DONE

        // 设置初项
        dp[0] = 1;
        dp[1] = 1;

        // 填表
        for (int i = 2; i<=nums.length;i++) {
            dp[i] += dp[i-1];
            if (isOk(nums,i-2)) {
                dp[i] += dp[i-2];
            }
        }

        System.out.println(Arrays.toString(dp));
        // 返回结构
        return dp[nums.length];
    }

    private boolean isOk(char[] nums, int start) {
        String num = String.valueOf(nums, start, 2);
        return Integer.parseInt(num) <= 25 && Integer.parseInt(num) >= 10;
    }

    public static void main(String[] args) {
        System.out.println(new LC05_Crack_Number().crackNumber(216612));
    }


}
