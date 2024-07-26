package com.programmercarl.array.sorted_squares;
/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按非递减顺序排序。

示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]

示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]

提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序

进阶：
请你设计时间复杂度为 O(n) 的算法解决本问题
*/

import java.util.Arrays;

public class Solution {

    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int idx = nums.length - 1;
        int[] res = new int [nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                res[idx--] = nums[right] * nums[right];
                right--;
            } else {
                res[idx--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,2};
        Solution ans = new Solution();
        System.out.println(Arrays.toString(ans.sortedSquares(nums)));
    }
}


