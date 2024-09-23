package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 全排列 II
 * https://leetcode.cn/problems/permutations-ii/
 */
public class LC07_Permute_Unique {

    /**
     * 思路：
     * 根据题意我们可以分析题目的特点，第一个特点就是返回所有可能的解，第二个特点就是每一个解都可以分阶段完成，那么就可以使用回溯来解决
     * 要想利用回溯来解决问题，就需要明确两个点，一个点是如何分步骤，另外一个点就是枚举每个步骤的所有可能
     *
     * @param nums
     * @return
     */

    private List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<Integer> path = new ArrayList<>();
        permuteUnique_r(nums,0,n,path);

        return list;
    }



    private void permuteUnique_r(int[] nums, int k, int n, List<Integer> path) {
        if (k == n) {
            list.add(new ArrayList<>(path));
            return;
        }

        List<Integer> numsList = new ArrayList<>(IntStream.of(nums).boxed().toList());
        for (int i = 0; i< path.size(); i++) {
            numsList.remove(path.get(i));
        }
        numsList = numsList.stream().distinct().toList();

        for (int i = 0; i< numsList.size();i++) {
            if (i > 0 && numsList.get(i).equals(numsList.get(i-1))) {
                continue;
            }

            path.add(numsList.get(i));
            permuteUnique_r(nums,k + 1,n,path);
            path.remove(path.size() - 1);

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new LC07_Permute_Unique().permuteUnique(new int[]{3,3,0,3});
        System.out.println(lists);
    }


}
