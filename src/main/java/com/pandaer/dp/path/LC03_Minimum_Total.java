package com.pandaer.dp.path;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/triangle/
 * 三角形最小路径和
 */
public class LC03_Minimum_Total {

    /**
     * 动态规划 最短路径模型
     * 状态: dp[i][j] 表示到达这个点的最小路径和
     * 状态转移方程 dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j]
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 定义状态
        List<List<Integer>> dp = new ArrayList<>(triangle.size());
        // 初始化
        for (int i = 0; i < triangle.size(); i++) {
            ArrayList<Integer> list = new ArrayList<>(triangle.get(i).size());
            for (int j = 0; j<triangle.get(i).size();j++) {
                list.add(0);
            }
            dp.add(list);
        }

        // 设置首项
        dp.get(0).set(0,triangle.get(0).get(0));

        // 填表
        for (int i = 1; i< dp.size();i++) {
            for (int j = 0; j < dp.get(i).size();j++) {
                if (j >= dp.get(i-1).size()) {
                    dp.get(i).set(j,dp.get(i-1).get(j-1) + triangle.get(i).get(j));
                } else if (j - 1 < 0) {
                    dp.get(i).set(j,dp.get(i-1).get(j) + triangle.get(i).get(j));
                }else {
                    dp.get(i).set(j,Math.min(dp.get(i-1).get(j-1),dp.get(i-1).get(j)) + triangle.get(i).get(j));
                }
            }
        }

        // 返回结果
        int res = Integer.MAX_VALUE;
        for (int i =0; i< dp.get(dp.size()-1).size();i++ ) {
            res = Math.min(res,dp.get(dp.size()-1).get(i));
        }

        return res;
    }
}
