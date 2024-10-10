package com.pandaer.recursion;

public class Code05_EatPeaches {

    int[] cache;
    public int eatPeaches(int nDays) {
        cache = new int[nDays + 1];
        return eatPeaches_r(nDays - 1);
    }

    public int eatPeaches_r(int nDays) {
        if (nDays == 0) {
            return 1;
        }
        if (cache[nDays] != 0) {
            return cache[nDays];
        }
        cache[nDays] = (eatPeaches_r(nDays - 1) + 1) * 2 ;
        return cache[nDays];
    }

    public static void main(String[] args) {
        System.out.println(new Code05_EatPeaches().eatPeaches(3));
    }
}
