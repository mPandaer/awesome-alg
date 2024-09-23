package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 */
public class LC12_Partition {

    /**
     * 思路：回溯
     * 扫描字符串，如果扫描的字符串是回文，就继续扫描，如果不是就暂停，知道剩余的字符串为""
     *
     * @param s
     * @return
     */
    private List<List<String>> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        char[] charArray = s.toCharArray();
        partition_r(charArray, 0, path);
        return list;
    }

    private void partition_r(char[] charArray, int index, List<String> path) {
        if (index == charArray.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < charArray.length; i++) {

            // 剪枝
            if (isOk(charArray, index, i)) {
                // 前缀是回文就添加
                path.add(new String(charArray, index, (i - index + 1)));
                partition_r(charArray, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isOk(char[] charArray, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
