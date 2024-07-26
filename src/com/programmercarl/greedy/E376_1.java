package com.programmercarl.greedy;

/**
 * ClassName: E376_1
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/7/22 9:19
 * @Version 1.0
 */
public class E376_1 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int count = 1;
        int preDiff = 0;
        int curDiff;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
