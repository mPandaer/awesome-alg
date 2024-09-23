package com.pandaer.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * N 皇后问题
 * https://leetcode.cn/problems/eight-queens-lcci/
 */
public class LC01_Solve_N_Queens {

    /**
     * 思路：回溯解法
     * 根据题意，这道题有两个特点，给出所有可能的解，这个问题可以分步骤解决。很明显这个符合回溯的解法
     * 1. 确认需要分解的步骤 按照皇后的数量分解，分为N步
     * 2. 每一个阶段该做什么？ 做出选择，并检查做出选择后是否符合要求，符合要求就可以进入下一个阶段
     * @param n
     * @return
     */

    private List<List<String>> resList = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] broads = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                broads[i][j] = '.';
            }
        }

        solveNQueens_r(broads,0,n);

        return resList;


    }

    private void solveNQueens_r(char[][] broads, int k, int n) {
        if (k == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i< n; i++) {
                list.add(new String(broads[i]));
            }
            resList.add(list);
        }

        // 遍历选择列表
        for (int i = 0; i< n;i++) {
            if (isOk(broads,k,i)) {
                broads[k][i] = 'Q';
                solveNQueens_r(broads,k + 1,n);
                broads[k][i] = '.';
            }
        }
    }

    private boolean isOk(char[][] broads, int rowIndex, int colIndex) {

        // 检查列
        for (int i = 0; i< rowIndex;i++) {
            if (broads[i][colIndex] == 'Q') {
                return false;
            }
        }

        // 检查主对角线
        for (int i = rowIndex -1,j=colIndex-1; i >= 0 && j >= 0; i--,j--) {
            if (broads[i][j] == 'Q') {
                return false;
            }
        }

        // 检查副对角线
        int n = broads.length;
        for (int i = rowIndex -1,j=colIndex+1; i >= 0 && j < n; i--,j++) {
            if (broads[i][j] == 'Q') {
                return false;
            }
        }

        return true;


    }
}




















