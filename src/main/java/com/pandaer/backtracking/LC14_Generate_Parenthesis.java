package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode.cn/problems/generate-parentheses/description/
 */
public class LC14_Generate_Parenthesis {

    /**
     * 思路：回溯
     * 这道题可以分为n个步骤解决问题，每一次确定两个位置上的括号，合法的只有(( () 可以很明显的看出来，每一步中必须是左括号在前，然后才是可选的右括号
     * @param n
     * @return
     */

        List<String> list = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            StringBuilder path = new StringBuilder();
            generateParenthesis_r(0,0,n,path);
            return list;
        }

        private void generateParenthesis_r(int left, int right, int max, StringBuilder path) {
            if (left + right == max * 2) {
                list.add(path.toString());
                return;
            }

            // 剪枝
            if (left < max) {
                path.append("(");
                generateParenthesis_r(left + 1,right,max,path);
                path.deleteCharAt(path.length() - 1);
            }

            // 剪枝
            if (right < left) {
                path.append(")");
                generateParenthesis_r(left,right + 1,max,path);
                path.deleteCharAt(path.length() - 1);
            }
        }

}
