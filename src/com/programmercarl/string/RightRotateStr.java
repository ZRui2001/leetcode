package com.programmercarl.string;

import java.util.Scanner;

/**
 * ClassName: RightRotateStr
 * Package: com.programmercarl.string
 * Description:
         * 题目描述
         * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
         * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。

         * 输入描述
         * 输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。

         * 输出描述
         * 输出共一行，为进行了右旋转操作后的字符串。

         * 输入示例
         * 2
         * abcdefg

         * 输出示例
         * fgabcde

         * 提示信息
         * 数据范围：
         * 1 <= k < 10000,
         * 1 <= s.length < 10000;
 * @Author Zhirui Zhao
 * @Create 2024/3/17 20:45
 * @Version 1.0
 */
public class RightRotateStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String ans = rightRotateStr1(str, num);
        System.out.println(ans);
        sc.close();
    }

    public static String rightRotateStr0(String str, int num) {
        if (num == 0 || str.isEmpty()) {
            return str;
        }

        num %= str.length();

        char[] chars = str.toCharArray();
        char[] tempArr = new char[num];
        // 把后num个字符存入tempArr
        for (int i = str.length() - num, j = 0; i < str.length(); i++, j++) {
            tempArr[j] = chars[i];
        }
        // 其余字符向右移动num位
        for (int i = str.length() - num - 1; i >= 0 ; i--) {
            chars[i + num] = chars[i];
        }
        // 将tempArr中的字符填入前num位
        for (int i = 0; i < num; i++) {
            chars[i] = tempArr[i];
        }

        return new String(chars);
    }

    /**
     * 不申请额外空间，只用chars
     *
     * 1.反转所有字符
     * 2.分别反转前len-n个和后n个
     *
     * 步骤1和2可以调换
     */
    public static String rightRotateStr1(String str, int num) {
        char[] chars = str.toCharArray();

        // 1.反转所有字符
        reverse(chars, 0, chars.length - 1);
        // 2.分别反转前len-n个和后n个
        reverse(chars, 0, chars.length - num - 1);
        reverse(chars, chars.length - num, chars.length - 1);

        return new String(chars);
    }

    public static void reverse(char[] chars, int from, int to) {
        while (from < to) {
            chars[from] ^= chars[to];
            chars[to] ^= chars[from];
            chars[from] ^= chars[to];
            from++;
            to--;
        }
    }
}
