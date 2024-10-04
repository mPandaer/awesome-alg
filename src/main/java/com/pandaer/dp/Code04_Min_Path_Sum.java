package com.pandaer.dp;

/**
 * 最短路径和
 */
public class Code04_Min_Path_Sum {


    /**
     * 贪心的做法
     * @param grid
     * @param n
     * @param m
     * @return
     */
    public int minPathSum(int[][] grid, int n, int m) {
        int x = 0,y = 0;
        int res = grid[x][y];

        while (x != m - 1 || y != n-1) {
            int costRight = x + 1 < m ? grid[y][x + 1] : Integer.MAX_VALUE;
            int costDown = y + 1 < n ? grid[y + 1][x] : Integer.MAX_VALUE;
            if (costRight > costDown) {
                y++;
                res += costDown;
            }else {
                x++;
                res += costRight;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code04_Min_Path_Sum().minPathSum(new int[][]{
                new int[]{1, 3, 5, 9},
                new int[]{2, 1, 3, 4},
                new int[]{5, 2, 6, 7},
                new int[]{6, 8, 4, 3},
        }, 4, 4));
    }
}
