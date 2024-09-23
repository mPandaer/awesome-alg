package com.pandaer.backtracking;

import java.util.*;

public class Code03_Phone_Number {

    /**
     * 思路：回溯
     * 根据题意，我们可以分析出问题的特点，需要这个问题所有可能的解，这个问题可以分步骤解决，这很符合回溯的核心思想
     * 根据回溯的解法，我们需要明确分几个步骤，以及每个步骤干什么
     * 1. 分len个步骤
     * 2. 如果这个步骤处于最后一步，就将字符数组拼接为字符串，如果不是最后一步，就随意选取数字对应的字符数组中的一个，加入到path中，并进入下一步
     * 时间复杂度：O(n^m)
     * 空间复杂度：O(n)
     * @param digits
     * @return
     */

    Map<Character,char[]> map  = Map.of(
            '2',new char[]{'a','b','c'},
            '3',new char[]{'d','e','f'},
            '4',new char[]{'g','h','i'},
            '5',new char[]{'j','k','l'},
            '6',new char[]{'m','n','o'},
            '7',new char[]{'p','q','r','s'},
            '8',new char[]{'t','u','v'},
            '9',new char[]{'w','x','y','z'}
    );

    private Set<String> resSet = new TreeSet<>();

    public List<String> digitsToChars(String digits) {
        char[] charNums = digits.toCharArray();
        int len = charNums.length;
        char[] path = new char[len];
        digitsToChars_r(charNums,0,len,path);
        return resSet.stream().toList();
    }

    private void digitsToChars_r(char[] charNums, int k, int len, char[] path) {

        // 最后一步
        if (k == len) {
            String res = String.valueOf(path);
            resSet.add(res);
            return;
        }

        // 非最后一步
        char numChar = charNums[k];
        char[] chars = map.get(numChar);
        for (int i = 0; i< chars.length;i++) {
            path[k] = chars[i];
            digitsToChars_r(charNums,k + 1,len,path);
        }

    }

}
