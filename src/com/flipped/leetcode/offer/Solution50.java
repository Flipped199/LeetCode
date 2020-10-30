package com.flipped.leetcode.offer;

import java.util.HashMap;

/**
 * @description: 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 限制：0 <= s 的长度 <= 50000
 * @author: Flipped
 * @create: 2020-10-27 17:19
 **/
public class Solution50 {

    public static final String STR = "abaccdeff";

    public static void main(String[] args) {
        Character s = new Solution50().firstUniqCharByHash(STR);
        Character s2 = new Solution50().firstUniqCharByArray(STR);
        System.out.println(s);
        System.out.println(s2);
    }

    /**
     * 通过hash解决
     * @param str
     * @return
     */
    public Character firstUniqCharByHash(String str) {
        HashMap<Character, Boolean> res = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            res.put(c, !res.containsKey(c));
        }
        for (char c : chars) {
            if (res.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 通过数组解决
     * @param s
     * @return
     */
    public Character firstUniqCharByArray(String s){
        if (s == null || s.equals("")) {
            return ' ';
        }
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            count[index]++;
        }
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (count[index] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}
