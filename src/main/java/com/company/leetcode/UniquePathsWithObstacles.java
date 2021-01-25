package com.company.leetcode;

public class UniquePathsWithObstacles {


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int w = obstacleGrid[0].length;
        int h = obstacleGrid.length;

        int[][] dp = new int[h][w];


        for (int i = 0; i < w; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                while (i < w) {
                    dp[0][i++] = 0;
                }
                break;
            }
        }
        for (int i = 0 ; i < h; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            }else {
                while (i < h) {
                    dp[i++][0] = 0;
                }
                break;
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[h-1][w-1];
    }
}
