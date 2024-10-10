package com.pandaer.dp.stair;

/**
 * 131. 砍竹子 I
 * https://leetcode.cn/problems/jian-sheng-zi-lcof/description/
 */
public class LC04_Cutting_Bamboo {

    /**
     * 动态规划 爬梯子模型
     * 定义状态：dp[i]: 当正整数i拆分成整数后，最大的乘积
     * 状态转移方程： dp[i] = Math.max(j * (i-j),j * dp[i-j])
     * @param bamboo_len
     * @return
     */
    public int cuttingBamboo(int bamboo_len) {
        // 定义状态
        int[] dp = new int[bamboo_len + 1];

        // 初始化 DONE

        // 设置初项
        dp[0] = 0;
        dp[1] = 0;

        // 填表
        for (int i = 2; i<= bamboo_len;i++) {
            int max = 0;
            for (int j = 1; j < i;j++) {
                max = Math.max(max,Math.max(j * (i-j),j * dp[i-j]));
            }
            dp[i] = max;
        }

        // 返回结果
        return dp[bamboo_len];

    }


}
