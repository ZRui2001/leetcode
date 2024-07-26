package com.programmercarl.string;

/**
 * ClassName: ReverseString
 * Package: com.programmercarl.string
 * Description:
         * 344.反转字符串
         * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
         * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

         * 示例 1：
         * 输入：s = ["h","e","l","l","o"]
         * 输出：["o","l","l","e","h"]
         * 示例 2：
         * 输入：s = ["H","a","n","n","a","h"]
         * 输出：["h","a","n","n","a","H"]

         * 提示：
         * 1 <= s.length <= 105
         * s[i] 都是 ASCII 码表中的可打印字符
 * @Author Zhirui Zhao
 * @Create 2024/3/14 19:46
 * @Version 1.0
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        char temp;
        while (left < right) {
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public void reverseString1(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            s[left] ^= s[right]; // l1 = l0 ^ r0
            s[right] ^= s[left]; // r1 = l0 ^ r0 ^ r0 = l0
            s[left] ^= s[right]; // l2 = l0 ^ r0 ^ l0
            left++;
            right--;
        }
    }
}
