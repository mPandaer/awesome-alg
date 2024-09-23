package com.pandaer.backtracking;

/**
 * N皇后问题
 */
public class Code01_N_Queens_Problem {

    /**
     * 思路：回溯解法
     * 根据题目的意思，我们很容易发现这个问题，是一个问题的所有可能的解，而且这个问题还能分为多个步骤。
     * 根据这个特点，我们不难发现这个问题可以利用回溯的思想来解决
     * 在n*n的棋盘上下n个棋，所以我们可以分为n个阶段，每个阶段有n种选择，
     * 在做出选择之后，需要判断这次选择是否符合要求，如果符合要求就可以进入下一个阶段，不然就只能做出下一个选择。
     * 时间复杂度：(n^(n+1))
     * 空间复杂度： O(n^2)
     * @param n
     * @return
     */
    public int solveNQueues(int n) {
        // n * n的棋盘
        int[][] broads = new int[n][n];
        // 当前进行到哪一个阶段了
        int k = 0;
        solveNQueues_r(broads,k,n);
        return totalNum;
    }

    private int totalNum = 0;

    private void solveNQueues_r(int[][] broads, int k, int n) {
        // 判断当前阶段是否完成
        if (k == n) {
            totalNum++;
            return;
        }
        // 如果没有完成，执行处理逻辑，并判断是否可以进入下一个阶段
        for (int i = 0; i< n; i++) {
            // 落棋
            broads[k][i] = 1;
            // 检查
            if (isRight(broads,n,k,i)) {
                // 符合要求进入下一阶段
                solveNQueues_r(broads,k + 1,n);
            }
            // 清理
            broads[k][i] = 0;
        }

    }

    // 检查落棋后，当前棋盘是否满足要求
    private boolean isRight(int[][] broads, int n, int rowIndex, int colIndex) {

        // 检查列
        for (int i = 0; i< rowIndex;i++) {
            if (broads[i][colIndex] == 1) {
                return false;
            }
        }

        // 检查主对角线
        for (int i = rowIndex-1,j=colIndex-1; i >= 0 && j >=0; j--,i--) {
            if (broads[i][j] == 1) {
                return false;
            }
        }

        // 检查副对角线
        for (int i = rowIndex-1,j=colIndex+1; i>=0 && j < n;j++,i--) {
            if (broads[i][j] == 1) {
                return false;
            }
        }

        return true;

    }

}
