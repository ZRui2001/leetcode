package com.programmercarl.array.binary_search;

/**
 * ClassName: com.leetcode.Solution704
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author Zhirui Zhao
 * @Create 2024/2/24 17:59
 * @Version 1.0
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;

        if ((target < nums[left]) || (target > nums[right])) {
            return -1;
        }

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else
                return mid;
        }

        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int targetIdx = s.search(new int[]{-1, 0, 3, 5, 9, 12}, 11);
        System.out.println(targetIdx);
    }
}
