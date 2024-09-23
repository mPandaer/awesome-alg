package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * https://leetcode.cn/problems/permutations/
 */
public class LC06_Permute {


    /**
     * 思路
     * 根据题意可知，这道题的特点有两个，需要所有可能的解，而且每个解都可以分步骤得到，这显然符合回溯解法的特点
     * 回溯需要找到两个关键点，第一个是如何分步骤，第二个是在每个步骤中遍历所有可能的选择，并进入下一步
     * 1. 分步骤：根据最终的解的长度为n,可以分为n步，一步确定一个位置。
     * 2. 在每一步中遍历所有可能的选择
     * @param nums
     * @return
     */

    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        permute_r(nums,0,n,path);
        return resList;
    }

    private void permute_r(int[] nums, int k, int n, List<Integer> path) {
        if (k == n) {
            resList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n;i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            permute_r(nums,k + 1,n,path);
            path.remove(path.size() - 1);
        }
    }


}
