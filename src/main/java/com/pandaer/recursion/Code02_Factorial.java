package com.pandaer.recursion;

public class Code02_Factorial {

    int[] cache;
    public int factorial(int n) {
        cache = new int[n + 1];
        return factorial_r(n);
    }

    public int factorial_r(int n) {
        if (n== 0) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int part1 = factorial_r(n - 1) % 7777777;
        cache[n] = (part1 * n) % 7777777;
        return cache[n];
    }
}
