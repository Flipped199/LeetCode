package com.flipped.leetcode.offer;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 *
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * @author: Flipped
 * @create: 2020-10-31 19:27
 **/
public class Solution58_1 {
    public static final String STR1 = "a good  example";
    public static final String STR2 = " hello world! ";
    public static final String STR3 = "the sky is blue";

    public static void main(String[] args) {
        System.out.println(reverse(STR1));
        System.out.println(reverse2(STR1));
    }

    /**
     * 分割 + 倒序 实现单词翻转
     *
     * @param str
     * @return
     */
    public static String reverse(String str) {
        String[] split = str.split(" +");
        System.out.println(Arrays.toString(split));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 双指针实现翻转
     *
     * @param str
     * @return
     */
    public static String reverse2(String str) {
        str = str.trim();
        int right = str.length();
        int left = right - 1;
        StringBuilder res = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && str.charAt(left) != ' ') {
                left--;
            }
            res.append(str, left + 1, right).append(" ");
            while (left >= 0 && str.charAt(left) == ' ') {
                left--;
            }
            right = left+1;
        }
        return res.toString().trim();
    }
}
