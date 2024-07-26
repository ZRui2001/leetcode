package com.programmercarl.string;

import org.junit.Test;

/**
 * ClassName: ReverseStr
 * Package: com.programmercarl.string
 * Description:
         * 541.反转字符串Ⅱ
         * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
         * 如果剩余字符少于 k 个，则将剩余字符全部反转。
         * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

         * 示例 1：
         * 输入：s = "abcdefg", k = 2
         * 输出："bacdfeg"
         * 示例 2：
         * 输入：s = "abcd", k = 2
         * 输出："bacd"

         * 提示：
         * 1 <= s.length <= 104
         * s 仅由小写英文组成
         * 1 <= k <= 104
 * @Author Zhirui Zhao
 * @Create 2024/3/15 14:57
 * @Version 1.0
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
//        char[] c = s.toCharArray();
//        int len = c.length;
//        int count = 0;
//
//        // 每2k一个循环，每次都反转前k个，k+1 - 2k不变
//        while (len >= ++count * k) {
//            // 反转前k个
//            reverseSubArr(c, (count - 1) * k, (count - 1) * k + k - 1);
//            count++;
//        }
//        if (len > --count * k) {
//            // 不足k个，则全部反转
//            reverseSubArr(c, count * k, c.length - 1);
//        }
//
//        return new String(c);
        char[] c = s.toCharArray();

        int start = 0, end;
        for (; start < s.length(); start += 2 * k) {
            end = Math.min(start + k - 1, s.length() - 1);
            reverseSubArr(c, start, end);
        }

        return new String(c);
    }

    private void reverseSubArr(char[] chars, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            char temp = chars[endIdx];
            chars[endIdx] = chars[startIdx];
            chars[startIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }
    
    @Test
    public void test0(){
        String s = "abcd";
        int k = 3;
        System.out.println(reverseStr(s, k));
    }
}
