package com.flipped.leetcode.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//////
/**
 * @program: LeetCode
 * @description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，
 * 使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * @author: Flipped
 * @create: 2020-11-01 13:17
 **/
public class Solution140 {
    /**
     * [
     * "cats and dog",
     * "cat sand dog"
     * ]
     */
    public static final String STR1 = "catsanddog";
    public static final String[] WORD_DICT1 = {"cat", "cats", "and", "sand", "dog"};

    /**
     * [
     * "pine apple pen apple",
     * "pineapple pen apple",
     * "pine applepen apple"
     * ]
     */
    public static final String STR2 = "pineapplepenapple";
    public static final String[] WORD_DICT2 = {"apple", "pen", "applepen", "pine", "pineapple"};
    /**
     * []
     */
    public static final String STR3 = "catsandog";
    public static final String[] WORD_DICT3 = {"cats", "dog", "sand", "and", "cat"};

    public static void main(String[] args) {
        System.out.println(wordBreak(STR1, Arrays.asList(WORD_DICT1)));
        System.out.println();
        System.out.println(wordBreak(STR2, Arrays.asList(WORD_DICT2)));
        System.out.println();
        System.out.println(wordBreak(STR3, Arrays.asList(WORD_DICT3)));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 1;
        StringBuilder sb = new StringBuilder();
        while (right <= s.length()){
            String temp = s.substring(left,right);
            if (wordDict.contains(temp)){
                left = right;
                sb.append(temp).append(" ");
            }else if(right == s.length()){

            }
            right++;
        }
        res.add(sb.toString().trim());
        return res;
    }
}
