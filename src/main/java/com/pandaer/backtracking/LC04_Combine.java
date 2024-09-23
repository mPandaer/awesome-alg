package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LC04_Combine {

    /**
     * 思路
     * 根据题意，我们可以总结出这样的特点，第一要求返回所有可能的解，第二解决这个问题可以分步骤解决，即可以使用回溯的思想解决问题
     * 根据回溯的核心思路，我们需要确定解决这个问题需要几个阶段，以及每个阶段要做什么
     * 1. 既然最后的返回结果一定是K个数，那么我们就划分为K个阶段。
     * 2. 每个阶段要做什么？ 每个阶段，判断这个这个数是否被选中，选中就进入下一阶段，没有选中就跳过，这个数，维持这个阶段。
     * @param n
     * @param k
     * @return
     */

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] path = new int[k];
        combine_r(1,n,0,k,path);
        return resList;
    }

    private void combine_r(int start, int max, int k, int n, int[] path) {
        if (k == n) {
            resList.add(IntStream.of(path).boxed().toList());
            return;
        }

        if (start > max) {
            return;
        }

        //选中当前数
        path[k] = start;
        combine_r(start + 1,max,k +1,n,path);

        // 未选中当前数
        combine_r(start + 1,max,k,n,path);
    }
}
