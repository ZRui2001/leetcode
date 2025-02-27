package com.programmercarl.array.min_subarray_len;

/**
 * ClassName: Solution
 * Package: PACKAGE_NAME
 * Description:
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。

 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1

 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0

 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105

 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * @Author Zhirui Zhao
 * @Create 2024/3/3 13:23
 * @Version 1.0
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int minLen = nums.length + 1;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                minLen = Math.min(end - start + 1, minLen);
                sum -= nums[start++];
            }
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        Solution ans = new Solution();
        System.out.println(ans.minSubArrayLen(target, nums));
    }
}
