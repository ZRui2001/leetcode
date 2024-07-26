package com.programmercarl.greedy;

/**
 * ClassName: E122
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/22 14:06
 * @Version 1.0
 */
public class E122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            result += Math.max(prices[i + 1] - prices[i], 0);
        }
        return result;
    }
}
