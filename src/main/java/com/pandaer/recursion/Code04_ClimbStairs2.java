package com.pandaer.recursion;

public class Code04_ClimbStairs2 {

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
        if (n == 3) {
            return 4;
        }
        if (cache[n] != 0) {
            return cache[n];
        }

        int part1 = climbStairs_r(n - 1) % 1000000007;
        int part2 = climbStairs_r(n - 2) % 1000000007;
        int part3 = climbStairs_r(n - 3) % 1000000007;

        cache[n] = (((part1 + part2) % 1000000007) + part3) % 1000000007;
        return cache[n];
    }
}
