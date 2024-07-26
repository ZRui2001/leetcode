package com.programmercarl.hash_table;

import java.util.HashSet;

/**
 * ClassName: IsHappy
 * Package: com.programmercarl.hash_table
 * Description:
 *      编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」 定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

     * 示例 1：
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1

     * 示例 2：
     * 输入：n = 2
     * 输出：false

     * 提示：
     * 1 <= n <= 2^31 - 1
 * @Author Zhirui Zhao
 * @Create 2024/3/11 13:42
 * @Version 1.0
 */
public class IsHappy {
    public boolean isHappy(int n) {
        // 记录每次迭代的平方和，若出现过则进入无限循环，返回false
        HashSet<Integer> record = new HashSet<>();
        while (!(record.contains(n) || n == 1)) {
            record.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    private int getNextNum(int num) { // 计算各数位的平方和并返回
        int sum = 0;
        while (num > 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
