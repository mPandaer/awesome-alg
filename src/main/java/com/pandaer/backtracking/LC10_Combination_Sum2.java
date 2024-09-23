package com.pandaer.backtracking;

import java.util.*;

/**
 * 组合总和 II
 * https://leetcode.cn/problems/combination-sum-ii/description/
 */
public class LC10_Combination_Sum2 {

    /**
     * 思路：回溯
     * 由于每个数字在最后的解只有两种情况要么存在，要么不存在 【选择列表】
     * 只要path中求和的值 >= target函数就结束
     * @param candidates
     * @param target
     * @return
     */

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序方便剪枝
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        combinationSum2_r(candidates,0,target,path);

        return resList;
    }

    private void combinationSum2_r(int[] candidates, int k, int target, List<Integer> path) {
        int pathSum = path.stream().mapToInt(it -> it).sum();
        if (target == pathSum) {
            resList.add(new ArrayList<>(path));
            return;
        }

        if (pathSum > target) {
            return;
        }

        if (k == candidates.length) {
            return;
        }

        int num = candidates[k];

        // 剪枝
        if (pathSum + num > target) {
            return;
        }

        path.add(num);
        combinationSum2_r(candidates,k + 1,target,path);
        path.remove(path.size() - 1);

        // 去重
        for (int i = k + 1; i < candidates.length;i++) {
            if (candidates[i] == candidates[k]) {
                k++;
            }
        }
        combinationSum2_r(candidates,k + 1,target,path);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LC10_Combination_Sum2().combinationSum2(new int[]{3,1,3,5,1,1}, 8);
        System.out.println(lists);
    }
}
