package com.programmercarl.greedy;

/**
 * ClassName: E134
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/24 10:24
 * @Version 1.0
 */
public class E134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;  // 全局最小值
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                start = i + 1;
            }
        }
        return sum >= 0 ? start : -1;
    }
}