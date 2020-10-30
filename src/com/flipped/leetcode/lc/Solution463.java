package com.flipped.leetcode.lc;

/**
 * @program: LeetCode
 * @description: 岛屿周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿
 * （或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，
 * 且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 *
 * 输出: 16
 * @author: Flipped
 * @create: 2020-10-30 10:38
 **/
public class Solution463 {
    /**
     * [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
     */
    private static final int[][] ARR = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < ARR.length; i++) {
            for (int j = 0; j < ARR[i].length; j++) {
                if (ARR[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int tx = i + DX[k];
                        int ty = j + DY[k];
                        if (tx < 0 || tx >= ARR.length || ty < 0 || ty >= ARR[i].length || ARR[tx][ty] == 0) {
                            sum++;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
