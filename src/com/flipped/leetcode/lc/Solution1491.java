package com.flipped.leetcode.lc;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 给你一个整数数组salary，数组里每个数都是 唯一的，其中salary[i] 是第i个员工的工资。
 * <p>
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * 示例 2：
 * <p>
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 * 示例 3：
 * <p>
 * 输入：salary = [6000,5000,4000,3000,2000,1000]
 * 输出：3500.00000
 * 示例 4：
 * <p>
 * 输入：salary = [8000,9000,2000,3000,6000,1000]
 * 输出：4750.00000
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= salary.length <= 100
 * 10^3<= salary[i] <= 10^6
 * salary[i]是唯一的。
 * 与真实值误差在10^-5 以内的结果都将视为正确答案。
 * @author: Flipped
 * @create: 2020-10-30 20:28
 **/
public class Solution1491 {
    /**
     * Except: 2500.00000
     */
    public static final int[] SALARY = {4000, 3000, 1000, 2000};

    public static void main(String[] args) {
        System.out.println(solution(SALARY));
        System.out.println(solution2(SALARY));
    }

    public static double solution(int[] arr) {
        double sum = 0;
        // 注意这两个值千万别写反了
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return (sum - max - min) / (arr.length - 2);
    }

    public static double solution2(int[] arr) {
        // 排序，去掉首尾/arr.length - 2即可
        Arrays.sort(arr);
        double sum = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2);
    }
}
