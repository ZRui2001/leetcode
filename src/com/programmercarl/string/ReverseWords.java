package com.programmercarl.string;

import org.junit.Test;

/**
 * ClassName: ReverseWords
 * Package: com.programmercarl.string
 * Description:
         * 151.反转字符串中的单词
         * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
         * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
         * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
         * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

         * 示例 1：
         * 输入：s = "the sky is blue"
         * 输出："blue is sky the"
         * 示例 2：
         * 输入：s = "  hello world  "
         * 输出："world hello"
         * 解释：反转后的字符串中不能存在前导空格和尾随空格。
         * 示例 3：
         * 输入：s = "a good   example"
         * 输出："example good a"
         * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。

         * 提示：
         * 1 <= s.length <= 104
         * s 包含英文大小写字母、数字和空格 ' '
         * s 中 至少存在一个 单词

         * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 * @Author Zhirui Zhao
 * @Create 2024/3/16 13:12
 * @Version 1.0
 */
public class ReverseWords {
    public String reverseWords(String s) {
        /**
         * 1.去除首尾及多余空格
         * 2.反转整个字符串
         * 3.反转各个单词
         */
        // 1.去除首尾及多余空格
        StringBuilder sb = removeSpaces(s);
        // 2.反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    /**
     * 去除字符串首尾及多余空格
     */
    StringBuilder removeSpaces(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 遍历str
        while (i < str.length()) {
            // 跳过空格
            while (str.charAt(i) == ' ') {
                i++;
                // 遍历到str尾部直接return，否则index溢出
                if (i >= str.length()) {
                    return sb;
                }
            }
            // 除第一次外，每次添加单词前先加空格
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            // 添加单词
            while (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
                i++;
                // 遍历到str尾部直接return，否则index溢出
                if (i >= str.length()) {
                    return sb;
                }
            }
        }
        return sb;
    }

    /**
     * 反转字符串下标范围为[from, to]的部分
     */
    void reverse(StringBuilder sb, int from, int to) {
        while (from < to) {
            char temp = sb.charAt(from);
            sb.setCharAt(from, sb.charAt(to));
            sb.setCharAt(to, temp);
            from++;
            to--;
        }
    }

    /**
     * 反转字符串中的每个单词
     * @param sb：首尾无空格且每个单词间隔一个空格的字符串
     */
    void reverseEachWord(StringBuilder sb) {
        // first指向单词词首，last指向单词词尾
        int first = 0, last;
        for (int i = 0; i < sb.length(); i++) {
            // 有空格则表示一个单词遍历结束
            if (sb.charAt(i) == ' ') {
                last = i - 1;
                // 反转单词
                reverse(sb, first, last);
                // 更新first，指向下一个单词的词首
                first = i + 1;
            }

            // 最后一个单词无法以空格作为遍历结束的识别符
            // 让last指向字符串尾，反转最后一个单词
            if (i == sb.length() - 1) {
                last = i;
                reverse(sb, first, last);
            }
        }
    }
    
    @Test
    public void test0(){
        String s = "the sky is blue";
        String ans = reverseWords(s);
        System.out.println(ans);
    }
}
