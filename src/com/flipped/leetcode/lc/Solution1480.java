package com.flipped.leetcode.lc;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 * @author: Flipped
 * @create: 2020-10-30 19:57
 **/
public class Solution1480 {

    /**
     * Except: [1,3,6,10]
     */
    public static final int[] ARR = {1, 2, 3, 4};

    public static void main(String[] args) {
        // 注意：这里调用需要区分先后顺序，因为solution2改变了原数组
        System.out.println(Arrays.toString(solution1(ARR)));
        System.out.println(Arrays.toString(solution2(ARR)));
    }

    /**
     * 一维数组动态和解法1
     *
     * @param arr
     * @return
     */
    public static int[] solution1(int[] arr) {
        int[] res = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            res[i] = sum;
        }
        return res;
    }

    /**
     * 一维数组动态和解法2
     *
     * @param arr
     * @return
     */
    public static int[] solution2(int[] arr) {
        // 因为计算和的话，第一个元素不需要加，所以直接从第二个开始遍历
        // 注意：这里改变了传过来的嗯原数组，需要注意题目要求
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }
}
