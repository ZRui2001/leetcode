package com.programmercarl.greedy;

/**
 * ClassName: E376
 * Package: com.programmercarl.greedy
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/2 23:08
 * @Version 1.0
 */
public class E376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int preDiff = 0;
        int curDiff = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                count++;
            }
            if (curDiff != 0) {
                preDiff = curDiff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        E376 e376 = new E376();
        int[] nums = {1,7,4,9,2,5};
        System.out.println(e376.wiggleMaxLength(nums));
    }
}
