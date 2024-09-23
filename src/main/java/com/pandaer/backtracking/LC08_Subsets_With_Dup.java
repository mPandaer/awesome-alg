package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/subsets-ii/
 * 子集 II
 */
public class LC08_Subsets_With_Dup {


    /**
     * 思路:
     * 第一个点：那么需要分几个阶段？换句话说得到一个解需要几步，题目要求的解是一个子集，那么得到一个子集需要几步呢？我认为是集合个数的步数，
     * 比如例子中[1,2,2]，我认为可以分为3步。第一步，1这个数是不是该子集的元素，第二步2这个数是不是该子集的元素，第三步第二个2是不是该子集的元素。
     * 第二个点：我们需要明确每个阶段的选择列表，根据第一点划分的步骤，那么每一步的选择列表就是当前这个数是子集的元素，以及当前这个数不是子集的元素。
     * 而且由于题目要求不能出现重复的子集，我们需要通过举例子，发现重复子集的规律，并对选择列表进行一定的限制。针对这道题，通过举例子我们发现的规律是这样的，
     * 在这个数字不是该子集的元素的选择时，进入下一阶段时，我们构造的下一阶段的选择列表需要跳过当前这个数。
     * @param nums
     * @return
     */

    private List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> path = new ArrayList<>(n);
        subsetsWithDup_r(nums,0,n,path);
        return resList;
    }

    private void subsetsWithDup_r(int[] nums, int k, int n, List<Integer> path) {
        // 阶段完成
        if (k == n) {
            resList.add(new ArrayList<>(path));
            return;
        }

        // 第一种选择：当前数是该子集的元素
        path.add(nums[k]);
        subsetsWithDup_r(nums,k+1,n,path);
        path.remove(path.size() - 1);

        // 第二种选择：当前数不是该子集的元素
        while (k + 1 < n && nums[k + 1] == nums[k] ) {
            k++;
        }
        subsetsWithDup_r(nums,k + 1,n,path);

    }
}
