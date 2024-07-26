package com.programmercarl.string;

import org.junit.Test;

/**
 * ClassName: RepeatedSubstringPattern
 * Package: com.programmercarl.string
 * Description:
         * 459.重复的子字符串
         * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。

         * 示例 1:
         * 输入: s = "abab"
         * 输出: true
         * 解释: 可由子串 "ab" 重复两次构成。
         * 示例 2:
         * 输入: s = "aba"
         * 输出: false
         * 示例 3:
         * 输入: s = "abcabcabcabc"
         * 输出: true
         * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)

         * 提示
         * 1 <= s.length <= 104
         * s 由小写英文字母组成
 * @Author Zhirui Zhao
 * @Create 2024/3/18 14:33
 * @Version 1.0
 */
public class RepeatedSubstringPattern {
    /**
     * 暴力解
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int subLen = 1; subLen <= len / 2; subLen++) {
            if (len % subLen == 0) {
                boolean isFlag = true;
                for (int i = subLen; i < len; i++) {
                    if (s.charAt(i) != s.charAt(i % subLen)) {
                        isFlag = false;
                        break;
                    }
                }
                if (isFlag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 移动匹配
     * 原理：s+s中去掉头尾字符，若还包含一个完整的s，则s可被一个子串重复构成
     * 时间复杂度：O(mn)，indexOf的复杂度就是O(mn)
     */
    public boolean repeatedSubstringPattern1(String s) {
        StringBuilder sb = new StringBuilder(s + s);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        return sb.indexOf(s) >= 0;
    }

    /**
     * KMP
     */
    public boolean repeatedSubstringPattern2(String s) {
        if (s.equals("")) {
            return false;
        }

        int len = s.length();
        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造 next 数组过程，j从0开始(空格)，i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1]) {
                j = next[j];
            }
            // 匹配成功，j往后移
            if (chars[i] == chars[j + 1]) {
                j++;
            }
            // 更新 next 数组的值
            next[i] = j;
        }

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }

    @Test
    public void test0(){
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern1("abab"));
    }
}
