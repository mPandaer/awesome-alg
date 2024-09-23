package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 * https://leetcode.cn/problems/combination-sum-iii/description/
 */
public class LC11_Combination_Sum3 {

    /**
     * 思路：回溯
     * 分为3个步骤，一次确定一个解的一个位置上的数
     * 每一步从的选择列表 为path最后一个的下一个位置开始遍历
     * @param k
     * @param n
     * @return
     */

    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<Integer> path = new ArrayList<>();
        combinationSum3_r(1,0,k,n,path);

        return list;
    }

    private void combinationSum3_r(int start, int k, int n, int target, List<Integer> path) {
        int pathSum = path.stream().mapToInt(it -> it).sum();
        if (k == n) {
            if (pathSum == target) {
                list.add(new ArrayList<>(path));
            }
            return;
        }



        for (int i = start; i <= 9; i++) {
            // 剪枝
            if (pathSum + i > target) {
                break;
            }
            path.add(i);
            combinationSum3_r(i+1,k+1,n,target,path);
            path.remove(path.size() - 1);

        }

    }
}
