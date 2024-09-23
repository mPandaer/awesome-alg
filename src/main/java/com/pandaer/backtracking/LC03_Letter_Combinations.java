package com.pandaer.backtracking;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 */
public class LC03_Letter_Combinations {


    /**
     * 思路：
     * 根据题意我们不难得出这道题的特点，枚举出所有可能的解，且可以分步骤完成 很明显这符合回溯算法的特点
     * 根据回溯算法的特点，我们需要知道如何分阶段，以及在一个阶段中该做什么
     * 1. 可以根据给定的输入字符串的长度为阶段数
     * 2. 每个阶段就从对应的字母列表中做出一个选择即可
     * @param digits
     * @return
     */

    private List<String> resList = new ArrayList<>();

    private Map<Character,char[]> map = Map.of(
            '2',new char[]{'a','b','c'},
            '3',new char[]{'d','e','f'},
            '4',new char[]{'g','h','i'},
            '5',new char[]{'j','k','l'},
            '6',new char[]{'m','n','o'},
            '7',new char[]{'p','q','r','s'},
            '8',new char[]{'t','u','v'},
            '9',new char[]{'w','x','y','z'}

    );

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return resList;
        }
        char[] inputNums = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        letterCombinations_r(inputNums,0,inputNums.length,sb);
        return resList;
    }

    private void letterCombinations_r(char[] inputNums, int k, int n, StringBuilder path) {
        if (k == n) {
            resList.add(path.toString());
            return;
        }

        char num = inputNums[k];

        char[] chars = map.get(num);
        for (char ch : chars) {
            path.append(ch);
            letterCombinations_r(inputNums,k + 1,n,path);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
