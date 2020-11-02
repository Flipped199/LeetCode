package com.flipped.leetcode.lc;

/**
 * @program: LeetCode
 * @description: 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @author: Flipped
 * @create: 2020-11-01 18:07
 **/
public class Solution70 {
    public static void main(String[] args) {

        System.out.println(climbStairs2(45));
        System.out.println(climbStairs3(45));
    }

    /**
     * 通过递归解决
     * Fn = Fn-1 + Fn-2
     * 时间复杂度 O(2^n)
     * 空间复杂度 O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 通过递归解决,记忆优化
     * Fn = Fn-1 + Fn-2
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    public static int climbStairsMemo(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 1) {
            memo[n] = 1;
        } else if (n == 2) {
            memo[n] = 2;
        } else {
            memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
        return memo[n];
    }

    /**
     * 动态规划
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
