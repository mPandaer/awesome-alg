package com.pandaer.greedy;

import java.util.Comparator;
import java.util.List;

public class Code03_Find_Most_Intervals {

    public int findMostIntervals(List<List<Integer>> intervals, int n) {
        // 排序
        intervals.sort((l1,l2) -> {
            if (l1.get(1).equals(l2.get(1))) {
                return l1.get(0) - l2.get(0);
            }
            return l1.get(1) - l2.get(1);
        });

        // 遍历
        int count = 1;
        int end = intervals.get(0).get(1);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).get(0) >= end) {
                count++;
                end = intervals.get(i).get(1);
            }
        }

        return count;

    }

}
