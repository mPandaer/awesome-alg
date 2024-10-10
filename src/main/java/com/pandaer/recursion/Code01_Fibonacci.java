package com.pandaer.recursion;


public class Code01_Fibonacci {

    /**
     * 可能会超
     * @param n
     * @return
     */

    int[] cache;
    public int fibonacci(int n) {
        cache = new int[n + 1];
        return fibonacci_r(n);
    }

    public int fibonacci_r(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (cache[n] != 0) return cache[n];
        int part1 = fibonacci_r(n - 1) % 1000000007;
        int part2 = fibonacci_r(n - 2) % 1000000007;
        cache[n] = (part1 + part2) % 1000000007;
        return cache[n];
    }

    public static void main(String[] args) {
        new Code01_Fibonacci().fibonacci(10);
    }
}
