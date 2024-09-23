package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * 组合总和
 * https://leetcode.cn/problems/combination-sum/description/
 */
public class LC09_Combination_Sum {

    /**
     * 思路：回溯
     * 根据题意，我们可以分析出这个问题的两个特点，一个是需要得到所有可能的解，一个是每一个解可以通过分步骤来解决，很显然这可以利用回溯的思想来解决问题
     * 要用回溯来解决问题，就需要明确两个点，一个是需要如何来分步骤，另一个是在一步步骤中如何选择所有可能的答案，并排除绝对不可能的答案
     * @param candidates
     * @param target
     * @return
     */

    private Set<List<Integer>> resList = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>(candidates.length);
        combinationSum_r(candidates,target,path);
        return resList.stream().toList();
    }

    private void combinationSum_r(int[] candidates, int target, List<Integer> path) {
        // 得到一个可能的解
        int pathSum = path.stream().mapToInt(it -> it).sum();
        if (pathSum == target) {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            newPath.sort(Integer::compare);
            resList.add(newPath);
            return;
        }

        if (pathSum > target) {
            return;
        }

        // 遍历选择列表
        for (int i = 0; i< candidates.length;i++) {
            path.add(candidates[i]);
            combinationSum_r(candidates,target,path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LC09_Combination_Sum().combinationSum(new int[]{7,3,2}, 18);
        System.out.println(lists);
    }
}
