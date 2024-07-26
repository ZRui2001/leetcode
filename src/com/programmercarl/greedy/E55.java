package com.programmercarl.greedy;

/**
 * ClassName: E55
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/22 14:25
 * @Version 1.0
 */
public class E55 {
    public boolean canJump(int[] nums) {
        int end = 0;
        int i = 0;
        while (i <= end) {
            end = Math.max(i + nums[i], end);
            if (end >= nums.length - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}
