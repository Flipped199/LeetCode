package com.flipped.leetcode.offer;

/**
 * @program: LeetCode
 * @description: 字符串左旋
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *
 * @author: Flipped
 * @create: 2020-10-27 17:09
 **/
public class Solution58_2 {

    public static final String STR = "abcdefg";
    public static final int K = 2;

    public static void main(String[] args) {
        String s = new Solution58_2().reverseLeftWords(STR, K);
        System.out.println(s);
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
