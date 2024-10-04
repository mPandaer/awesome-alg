package com.pandaer.greedy;

import java.util.Arrays;

/**
 * 分糖果
 * https://www.codecrush.cn/oj/problem/50
 */
public class Code01_Find_Most_Children {

    /**
     * 思路：
     * @param s
     * @param g
     * @return
     */
    public int findMostChildren(int[] s, int[] g){
        // 排序
        Arrays.sort(s);
        Arrays.sort(g);

        // 遍历糖果，记录总个数
        int count = 0;
        int i = 0,j = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                count++;
                j++;
            }
            i++;
        }

        return count;

    }
}
