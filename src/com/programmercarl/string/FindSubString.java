package com.programmercarl.string;

import org.junit.Test;

/**
 * ClassName: FindSubString
 * Package: com.programmercarl.string
 * Description:
         * 28.找出字符串中第一个匹配项的下标
         * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。

         * 示例 1：
         * 输入：haystack = "sadbutsad", needle = "sad"
         * 输出：0
         * 解释："sad" 在下标 0 和 6 处匹配。
         * 第一个匹配项的下标是 0 ，所以返回 0 。
         * 示例 2：
         * 输入：haystack = "leetcode", needle = "leeto"
         * 输出：-1
         * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。

         * 提示：
         * 1 <= haystack.length, needle.length <= 104
         * haystack 和 needle 仅由小写英文字符组成
 * @Author Zhirui Zhao
 * @Create 2024/3/17 21:45
 * @Version 1.0
 */
public class FindSubString {
    /**
     * 暴力遍历
     * 时间复杂度：O((n - m) * n)
     * @param haystack：原串，长度为n
     * @param needle：匹配串，长度为m
     * @return 原串中与匹配串相等的第一个子串的首字符的索引
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int recordIdx;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            // 母串中出现子串首字符，则判断后续字符是否相同
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                // 记录当前位置
                recordIdx = i;
                // 判断后续字符是否相同
                while (haystack.charAt(i++) == needle.charAt(j++)) {
                    if (j >= needle.length()) {
                        return i - needle.length();
                    }
                }
                // 母串不包含子串全部字符，index回到记录位置
                i = recordIdx;
            }

        }
        return -1;
    }

    /**
     * KMP
     */
    public int strStr1(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        // 获取next数组，next[i]表示前i个字符的最大公共前后缀长度
        int[] next = getNext(needle);

        // i->原串，j->匹配串
        for (int i = 0, j = 0;
             i < haystack.length() && haystack.length() - i >= needle.length() - j;
             i++) {
            // 字符匹配成功，i、j顺移
            while (haystack.charAt(i) == needle.charAt(j)){
                // 匹配串遍历完毕
                if (j >= needle.length() - 1) {
                    return i - needle.length() + 1;
                }

                i++;
                j++;
            }

            // 不匹配，j回退，i不动
            if (j > 0) {
                j = next[j - 1];
                i--;
            }
            // j=0则i顺移
        }
        return -1;
    }

    // 返回字符串的前缀表
    int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        // i->前缀的最后字符，j->后缀的最后字符
        for (int j = 1, i = 0; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                next[j] = i + 1;
                i++;
            } else {
                // s[i] != s[j]
                if (i > 0) {
                    i = next[i - 1];
                    j--;
                } else {
                    next[j] = 0;
                }
            }
        }
        return next;
    }

    @Test
    public void test0(){
//        System.out.println(strStr1("mississippi", "issip"));
//        System.out.println(strStr1("aabaaabaaac", "aabaaac"));
//        System.out.println(strStr1("leetcode", "leeto"));
//        System.out.println(strStr1("aaa", "aaaa"));
        System.out.println(strStr1("mississippi", "issipi"));
    }
}
