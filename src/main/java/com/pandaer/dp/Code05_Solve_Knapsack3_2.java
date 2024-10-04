package com.pandaer.dp;

public class Code05_Solve_Knapsack3_2 {

    /**
     * 思路：定义状态 填表
     * 每一个阶段，都有对应的物品重量
     * 状态 dp[n][w+1] 表示在某个阶段，背包的重量为x时，有几种方案
     * 状态转移方程 dp[i][j] = dp[i-1][j] + dp[i-1][j - weight[i]];
     * @param w
     * @param n
     * @param weights
     * @return
     */
    // 一维数组 空间优化
    public int solveKnapsack(int w, int n, int[] weights) {
        // 创建状态
        int[] status = new int[w + 1];

        // 初始化状态 DONE

        // 设置首项
        status[0] = 1;
        if (weights[0] <= w) {
            status[weights[0]] = 1;
        }

        // 填表
        for (int i = 1; i< n;i++) {
            for (int j = w; j>=0;j--) {
                if (j - weights[i] >=0) {
                    status[j] += status[j - weights[i]];
                }
            }
        }

        // 返回结果
        return status[w];
    }

//    // 滚动数组 空间优化
//    public int solveKnapsack(int w, int n, int[] weights) {
//        // 创建状态
//        int[][] status = new int[2][w + 1];
//
//        // 初始化状态 DONE
//
//        // 设置首项
//        status[0][0] = 1;
//        if (weights[0] <= w) {
//            status[0][weights[0]] = 1;
//        }
//
//        // 填充状态
//        int turn = 1;
//        for (int i = 1; i< n; i++) {
//            for (int j = 0; j<=w;j++) {
//                int count = 0;
//                if (status[(turn + 1) % 2][j] != 0) {
//                    count += status[(turn + 1) % 2][j];
//                }
//                if (j - weights[i] >= 0 && status[(turn + 1) % 2][j - weights[i]] != 0) {
//                    count += status[(turn + 1) % 2][j - weights[i]];
//                }
//                status[turn][j] = count;
//            }
//            turn = (turn + 1) % 2;
//        }
//
//        // 返回结果
//        return status[(turn + 1) % 2][w];
//    }



    /*=================================非空间优化的版本======================================*/
//    public int solveKnapsack(int w, int n, int[] weights) {
//        // 创建状态
//        int[][] status = new int[n][w + 1];
//
//
//        // 设置首项
//        status[0][0] = 1;
//        if (weights[0] <= w) {
//            status[0][weights[0]] = 1;
//        }
//
////        // 填充状态 正向填充
////        for (int i = 1; i< n; i++) {
////            for (int j = 0; j <= w; j++) {
////                if (status[i-1][j] != 0) {
////                    status[i][j] += status[i-1][j];
////                    if (j + weights[i] <= w) {
////                        status[i][j + weights[i]] += status[i-1][j];
////                    }
////                }
////            }
////        }
//
//        // 填充状态 逆向填充
//        for (int i = 1; i< n; i++) {
//            for (int j = 0; j<=w; j++) {
//                if (status[i-1][j] != 0) {
//                    status[i][j] += status[i-1][j];
//                }
//                if (j - weights[i] >=0 && status[i-1][j - weights[i]] != 0) {
//                    status[i][j] += status[i-1][j - weights[i]];
//                }
//            }
//        }
//
//        // 返回结果
//        return status[n-1][w];
//    }

    public static void main(String[] args) {
        System.out.println(new Code05_Solve_Knapsack3_2().solveKnapsack(10, 6, new int[]{3, 1, 4, 2, 10, 7}));
    }
}
