package com.pandaer.recursion;

public class Code03_ClimbStairs {

    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n + 1];
        return climbStairs_r(n);
    }

    public int climbStairs_r(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = climbStairs_r(n - 1) + climbStairs_r(n - 2);
        return cache[n];
    }
}
