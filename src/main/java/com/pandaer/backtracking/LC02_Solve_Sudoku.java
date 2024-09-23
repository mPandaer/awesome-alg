package com.pandaer.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解数独
 * https://leetcode.cn/problems/sudoku-solver/
 */
public class LC02_Solve_Sudoku {

    /**
     * 思路：回溯
     * 根据题意，可以总结出这道题的特点，可以分为多个步骤解决问题，并且可以通过枚举，列出所有可能的解，并找出唯一正确的解
     * 根据这道题的特点，倒也是可以利用回溯来解决
     * 1. 分为几个步骤来解决 只要棋盘中存在 . 就说明还没有结束
     * 2. 每个步骤干什么？ 填入1-9数字判断，判断是否符合要求。
     * @param board
     */
    int len = 9;
    public void solveSudoku(char[][] board) {
        // 计算解决问题需要的总步数
        List<Integer> totalStep = new ArrayList<>();
        for (int i = 0; i< board.length;i++) {
            for (int j = 0; j< board[i].length;j++) {
                if (board[i][j] == '.') {
                    totalStep.add(i * 9 + j);
                }
            }
        }
        solveSudoku_r(board,totalStep,0);

    }

    private boolean solveSudoku_r(char[][] board, List<Integer> totalStep, int index) {
        if (index == totalStep.size()) {
            return true;
        }

        int rowIndex = totalStep.get(index) / len;
        int colIndex = totalStep.get(index) % len;

        for (int i = 1; i<=len ;i++) {
            char numChar = (char) ('0' + i);
            if (isOk(board,rowIndex,colIndex,numChar)) {
                board[rowIndex][colIndex] = numChar;
                if (solveSudoku_r(board,totalStep,index + 1)) {
                    return true;
                }
                board[rowIndex][colIndex] = '.';
            }
        }

        return false;

    }

    private boolean isOk(char[][] board, int rowIndex, int colIndex, char value) {
        // 检查行
        for (int i = 0; i < len; i++) {
            if (i != colIndex && board[rowIndex][i] == value) {
                return false;
            }
        }

        // 检查列
        for (int i = 0; i < len; i++) {
            if (i != rowIndex && board[i][colIndex] == value) {
                return false;
            }
        }

        // 检查所属区域
        int startRow = (rowIndex / 3) * 3;
        int startCol = (colIndex / 3) * 3;

        for (int i = startRow; i< startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i != rowIndex && j != colIndex && board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        char[][] broads = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new LC02_Solve_Sudoku().solveSudoku(broads);
        System.out.println(Arrays.deepToString(broads));
    }
}
