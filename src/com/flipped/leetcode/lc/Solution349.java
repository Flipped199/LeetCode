package com.flipped.leetcode.lc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: LeetCode
 * @description: 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * @author: Flipped
 * @create: 2020-11-02 13:12
 **/
public class Solution349 {

    public static final int[] ARR1 = {1, 2, 2, 1};
    public static final int[] ARR2 = {2, 2};

    public static final int[] ARR3 = {4, 9, 5};
    public static final int[] ARR4 = {9, 4, 9, 8, 4};

    public static void main(String[] args) {
        System.out.println("方法一：");
        System.out.println(Arrays.toString(intersection(ARR1, ARR2)));
        System.out.println(Arrays.toString(intersection(ARR3, ARR4)));

        System.out.println("方法三：");
        System.out.println(Arrays.toString(intersection3(ARR1, ARR2)));
        System.out.println(Arrays.toString(intersection3(ARR3, ARR4)));

        System.out.println("方法二：");
        System.out.println(Arrays.toString(intersection2(ARR1, ARR2)));
        System.out.println(Arrays.toString(intersection2(ARR3, ARR4)));

    }

    /**
     * 使用map
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && !list.contains(i)) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 排序后
     * 使用双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                if (!list.contains(nums1[i])) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 使用Stream API
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection3(int[] nums1, int[] nums2) {
        // int[] 转为 List
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        // 过滤，只保留并集元素
        List<Integer> l2 = Arrays.stream(nums2).filter(l1::contains).distinct()
                .boxed().collect(Collectors.toList());
        // List 转为 int[]
        return l2.stream().mapToInt(Integer::valueOf).toArray();
    }
}
