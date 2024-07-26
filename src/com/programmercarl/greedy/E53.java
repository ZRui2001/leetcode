package com.programmercarl.greedy;

/**
 * ClassName: E53
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/22 13:35
 * @Version 1.0
 */
public class E53 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Integer.max(sum, max);
            sum = Integer.max(0, sum);
        }
        return max;
    }
}
