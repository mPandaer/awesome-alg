package com.pandaer.greedy;

import java.util.Arrays;
import java.util.List;

public class Code02_Find_Min_Waiting_Time {
    public int findMinWaitingTime(List<Integer> t, int n) {
        t.sort(Integer::compare);
        int[] sumArr = new int[t.size()];
        for (int i = 1; i< t.size();i++) {
            sumArr[i] = sumArr[i-1] + t.get(i-1);
        }

        return Arrays.stream(sumArr).sum();
    }
}
