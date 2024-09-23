package com.pandaer.backtracking;

import java.util.*;

/**
 * 子集
 * https://leetcode.cn/problems/subsets/description/
 */
public class LC05_Subsets {


    /**
     * 思路
     * 根据题意，我们可以分析出这道题的特点，第一需要得到所有可能的解，第二这些解可以分步骤完成。
     * 根据题目的特点就可以知道，可以利用回溯的思路去解决，而利用回溯的思路解决问题，需要知道两个东西，如何分阶段完成，以及在某个阶段应该干什么
     * 1. 可以根据集合的个数来分阶段
     * 2. 每个阶段干两件事情，选择或者没有选择
     * @param nums
     * @return
     */

    private Set<List<Integer>> resList = new TreeSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        subsets_r(nums,0,n,path);
        return resList.stream().toList();
    }

    private void subsets_r(int[] nums, int k, int n, List<Integer> path) {
        if (k == n) {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            newPath.sort(Integer::compareTo);
            resList.add(newPath);
            return;
        }

        // 选择
        path.add(nums[k]);
        subsets_r(nums,k + 1,n,path);
        path.remove(path.size() - 1);
        // 未选择
        subsets_r(nums,k + 1,n,path);
    }
}
