package com.programmercarl.binary_search;

/**
 * ClassName: E35
 * Package: com.programmercarl.binary_search
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/6/20 17:26
 * @Version 1.0
 */
public class E35 {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (nums[m] < target){
                i = m + 1;
            } else {
                return m;
            }
        }
        return i;
    }
}
