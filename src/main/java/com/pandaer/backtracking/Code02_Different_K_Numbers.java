package com.pandaer.backtracking;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * 不同K数和
 */
public class Code02_Different_K_Numbers {

    /**
     * 思路：回溯解法
     * 根据题意，我们可以知道这个问题的特点是，所有可能的解并且可以分步骤解决这个问题，根据这个特点，我们就可以使用回溯的解法
     * 根据回溯的特点，我们需要确认分几步解决这个问题，每一步要做什么？
     * 1. 分k步解决这个问题
     * 2. 每步的步骤分为两类
     *      2.1 非最后一步，选一个没有用过的数，放入path中，进入下一个阶段
     *      2.2 最后一步，对path进行求和，并加入到最后的结果集中
     * 时间复杂度：O(n^(n+1))
     * 空间复杂度：O(k)
     * @param nums
     * @param n
     * @param k
     * @return
     */

    private Set<Integer> set = new TreeSet<>();

    public List<Integer> sumKNums(int[] nums, int n, int k) {
        int[] path = new int[n];
        sumKNums_r(nums,n,0,k,path);
        return set.stream().toList();
    }

    private void sumKNums_r(int[] nums, int len, int k, int n, int[] path) {

        // 最后一步
        if (k == n) {
            int sum = Arrays.stream(path).sum();
            set.add(sum);
            return;
        }

        // 非最后一步
        for (int i = 0; i< len;i++) {
            int val = nums[i];
            boolean match = Arrays.stream(path).anyMatch(it -> it == val);
            if (!match) {
                path[k] = val;
                sumKNums_r(nums,len,k+1,n,path);
            }
        }
    }


    /**
     * 额外的一个解法，巧妙的运用了，递归是一种特殊的循环的方式，具体参考如下
     */

//    public class Solution {
//
//        public List<Integer> sumKNums(int nums[], int n, int k) {
//            ArrayList<Integer> integers = new ArrayList<>(k);
//            sumKNums(nums, integers, 0, k, 0, 0);
//            return integers.stream()
//                    .distinct()
//                    .sorted(Comparator.comparingInt(o -> o))
//                    .collect(Collectors.toList());
//        }
//
//        private void sumKNums(int nums[], List<Integer> path, int index, int k, int sum, int pathLen) {
//            if (pathLen== k) {
//                path.add(sum);
//                return;
//            }
//            if (index == nums.length) {
//                return;
//            }
              // 每一步只有两个选择，要么被选择参与计算，要么没有选择参与计算，递归树的深度变成了n,但是每一层的宽度却恒定为2
//            sumKNums(nums,path, index + 1, k, sum,pathLen);
//            sumKNums(nums,path, index + 1, k, sum + nums[index],pathLen + 1);
//        }
//
//    }

}
